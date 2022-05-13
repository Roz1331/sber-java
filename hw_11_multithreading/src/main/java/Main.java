import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int n = list.size();
        for (int num : list) {
            Thread object = new Thread(new MyMultithreading(num));

            object.start();
        }


    }
}
