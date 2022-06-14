package ri.hw.spring;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

public class TestSpring {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();

        ThreadPool threadPool2 = context.getBean("fixedThreadPool", FixedThreadPool.class);
        System.out.println(threadPool2.getThreadsNumber());

//        String fileName = "links.txt";
//
//        List<URL> links = getAllLines(fileName);
//
//        ThreadPool threadPool = new FixedThreadPool(3);
//        threadPool.start();
//
//        for (int i = 0; i < links.size(); i++) {
//            int finalI = i;
//            threadPool.execute(() -> {
//                System.out.println("i:" + finalI + " " + links.get(finalI));
//            });
//        }
//
//        System.out.println("starting downloading");
//        for (int i = 0; i < links.size(); i++) {
//            downloadFile(links.get(i), String.format("books/test_%d.zip", i));
//        }
//        System.out.println("downloading completed");
//
//        System.exit(0);

    }
    public static void downloadFile(URL url, String outputFileName) throws IOException
    {
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(outputFileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }


    public static List<URL> getAllLines(String filePath) {
        List<URL> res = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = reader.readLine()) != null) {
                res.add(new URL(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }
}
