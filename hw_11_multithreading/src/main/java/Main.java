import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        List<Integer> list = readIntsFromFile("numbers.txt");

        for (int num : list) {
            Thread object = new Thread(new MyMultithreading(num));

            object.start();
        }
    }

    public static List<Integer> readIntsFromFile(String fileName) throws IOException {
        List<Integer> res = new ArrayList<>();

        try(FileReader fr = new FileReader(fileName)) {
            Scanner scan = new Scanner(fr);

            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                Arrays.asList(str.split(" ")).forEach(x -> res.add(Integer.parseInt(x)));
            }
        }

        return res;
    }
}
