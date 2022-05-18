public class Main {

    public static void main(String[] args) {

        FixedThreadPool threadPool = new FixedThreadPool(5);

        threadPool.start();

        for (int i = 0; i < 20; i++) {
            threadPool.execute(new Task(i));
        }
    }
}
