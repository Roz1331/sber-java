import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        int iterations = 100000;
        for (int i = 0; i < iterations; i++) {
            map.put(i, "value" + i);
        }
    }
}
