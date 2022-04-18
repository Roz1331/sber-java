package part3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {

    public static void readContent(String url) throws IOException {
        String content = null;
        URLConnection connection;
        connection =  new URL(url).openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        scanner.useDelimiter("\\Z");
        content = scanner.next();
        scanner.close();
        System.out.println(content);
    }


    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter some url: ");
            Scanner input = new Scanner(System.in);
            String url = input.nextLine();
            try {
                readContent(url);
                break;
            }
            catch (MalformedURLException ex) {
                System.out.println("Invalid URL! Try again :(");
            }
            catch (IOException e) {
                System.out.println("Something went wrong, try again :(");
            }
        }
    }
}
