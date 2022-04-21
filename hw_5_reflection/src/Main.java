import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {

    public static boolean constantsOKAY(Class cl) {
        List<Field> fields = Arrays.asList(cl.getDeclaredFields());


        for(Field elem : fields) {
            elem.setAccessible(true);
            if ((elem.getModifiers() & Modifier.FINAL) == 16)  {
                String value;
                try {
                    value = (String) elem.get(elem.getName());
                    if (!value.equals(elem.getName())) return false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Task # 1
        System.out.println("Task # 1");
        Calculator c = new CalculatorImpl();
        int number = 3;
        System.out.println(String.format("%d! = %d", number, c.calc(number)));

        // Task # 2
        System.out.println("\nTask # 2");
        Method[] methods = B.class.getMethods();
        Method[] declaredMethods = B.class.getDeclaredMethods();

        Set<Method> allMethods = new HashSet(Arrays.asList(methods.clone()));
        Collections.addAll(allMethods, declaredMethods);

        allMethods.forEach(System.out::println);

        // Task # 3
        System.out.println("\nTask # 3");
        List<Method> methods2 = new ArrayList(Arrays.asList(B.class.getDeclaredMethods().clone()));
        List<Method> getters = new ArrayList<>();
        methods2.forEach(elem -> {
            if (elem.getName().startsWith("get")) {
                getters.add(elem);
            }
        });

        System.out.println("getters list:");
        getters.forEach(System.out::println);

        // Task # 4
        System.out.println("\nTask # 4");
        System.out.println(constantsOKAY(A.class));
        System.out.println(constantsOKAY(B.class));
    }
}
