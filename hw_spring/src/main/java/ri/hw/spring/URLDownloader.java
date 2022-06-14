package ri.hw.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

@Component("URLDownloader")
public class URLDownloader {
    @Value("${URLDownloader.filePath}")
    private String filePath;

    private FileParser fileParser;
    private FixedThreadPool fixedThreadPool;

    @Autowired
    public URLDownloader(FileParser fileParser, FixedThreadPool fixedThreadPool) {
        this.fileParser = fileParser;
        this.fixedThreadPool = fixedThreadPool;
    }

    public String getFilePath() {
        return filePath;
    }

    public void downloadAll() {
        List<URL> allUrls = fileParser.getAllLines();

        for (int i = 0; i < allUrls.size(); i++) {
            int finalI = i;
            fixedThreadPool.execute(() -> {
                System.out.println("i:" + finalI + " " + allUrls.get(finalI));
                try {
                    downloadFile(allUrls.get(finalI), String.format("books/test_%d.zip", finalI));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void downloadFile(URL url, String outputFileName) throws IOException
    {
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(outputFileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }
}
