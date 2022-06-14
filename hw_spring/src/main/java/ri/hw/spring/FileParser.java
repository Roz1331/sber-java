package ri.hw.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileParser {
    @Value("${URLDownloader.filePath}")
    private String filePath;

    public List<URL> getAllLines() {
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
