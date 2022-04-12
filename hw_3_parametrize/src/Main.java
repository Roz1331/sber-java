import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("#1\tПараметризовать CountMap");
        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        System.out.println(map.getCount(5));
        System.out.println(map.getCount(6));
        System.out.println(map.getCount(10));

        CountMap<Integer> map2 = new CountMapImpl<>();
        map2.add(10);

        map.addAll(map2);
        System.out.println("after addAll");
        System.out.println(map.getCount(10));

        Map<Integer, Integer> map3 = map.toMap();

        System.out.println("testing toMap:");
        map3.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });

    }

}
