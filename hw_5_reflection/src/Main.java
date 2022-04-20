import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
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
        Set<String> methodNames = new HashSet<String>();

        allMethods.forEach(elem -> {
            methodNames.add(String.format("%s %s", elem.getReturnType(), elem.getName()));
        });

        methodNames.forEach(System.out::println);

    }
}
