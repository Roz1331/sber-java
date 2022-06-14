package ri.hw.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.*;

public class TestSpring {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        URLDownloader urlDownloader = context.getBean("URLDownloader", URLDownloader.class);
        urlDownloader.downloadAll();

        System.out.println("downloading completed");

    }


}
