import java.util.*;
import java.io.*;

public class Main {

    public static void taskCars() {
        List<Car> lst = new ArrayList<Car>();
        lst.add(new Car("Лада", "седан"));
        lst.add(new Car("Лада", "хэтчбек"));
        lst.add(new Car("Мерседес", "седан"));
        lst.add(new Car("Бмв", "кроссовер"));
        lst.add(new Car("Форд", "хэтчбек"));
        lst.add(new Car("Пежо", "кроссовер"));
        lst.add(new Car("Тойота", "седан"));

        List<Car> sedan = new ArrayList<>();
        List<Car> hatchback = new ArrayList<>();
        List<Car> crossover = new ArrayList<>();

        lst.forEach(car -> {
            switch (car.getType()) {
                case "седан":
                    sedan.add(car);
                    break;
                case "хэтчбек":
                    hatchback.add(car);
                    break;
                case "кроссовер":
                    crossover.add(car);
                    break;
                default:
                    System.out.printf("Недопустимый компонент объекта: %s", car.getType());
                    break;
            }
        });

        System.out.println("Lists after sorting by type");

        System.out.println("\nsedan cars:");
        sedan.forEach(System.out::println);
        System.out.println("\nhatchback cars:");
        hatchback.forEach(System.out::println);
        System.out.println("\ncrossover cars:");
        crossover.forEach(System.out::println);
    }

    public static void wordsAnalyzer(String path) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> myStrings = new TreeSet<>((o1, o2) -> {
            if(o1.length() > o2.length())
                return 1;
            else if (o1.length() < o2.length())
                return -1;
            else return o1.compareTo(o2);
        });
        try(FileReader reader = new FileReader(path)) {
            Scanner scan = new Scanner(reader);

            while (scan.hasNextLine()) {
                String line = scan.nextLine().toLowerCase();

                for(String s : line.split("[.,:;!?\"'()^ ]")) {
                    if(!s.isEmpty()) {
                        myStrings.add(s);
                        if(map.containsKey(s))
                            map.replace(s, map.get(s) + 1);
                        else map.put(s, 1);
                    }

                }

            }
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения из файла!");
        }

        System.out.printf("number of dif words: %d\n", myStrings.size());
        myStrings.forEach(System.out::println);

        System.out.println("=========================================");

        System.out.println("words usage");

        map.forEach((key, value) -> {
            System.out.printf("%s: %d\n", key, value);
        });
    }


    public static List<String> reverser(String path) {

        List<String> lst = new LinkedList<>();
        try(FileReader reader = new FileReader(path)) {
            Scanner scan = new Scanner(reader);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                lst.add(line);
            }
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения из файла!");
        }

        return lst;
    }

    public static void printRandom(List<String> list) {
        System.out.printf("Всего в файле %d строки\n" +
                "Введите номер строки, которую вы хотите напечатать\n" +
                "Для выхода введите -1\n", list.size());

        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.print("введите номер строки: ");
            int num = in.nextInt();

            if(num == -1) break;

            if (num < 1 || num > list.size()) {
                System.out.println("Вы ввели некорректное значение. Попробуйте снова");
                continue;
            }

            System.out.printf("Ваша строка: %s\n", list.get(num - 1));

        }
        in.close();
    }

    public static void main(String[] args) {

        taskCars();

        // tasks 1-3
        wordsAnalyzer("test.txt");

        List<String> list = reverser("test.txt");
        CustomLinkedList<String> ctmLst = new CustomLinkedList<>(list);

        // task 4
        System.out.println("list before reverse:");
        list.forEach(System.out::println);

        System.out.println("\nlist after reverse:");
        Collections.reverse(list);
        list.forEach(System.out::println);

        // task 5
        System.out.println("\nprinting by custom iterator:");
        ctmLst.forEach(System.out::println);

        // task 6
        printRandom(list);

    }
}
