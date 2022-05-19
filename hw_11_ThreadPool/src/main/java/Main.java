public class Main {

    public static void main(String[] args) {

//        ThreadPool threadPool = new FixedThreadPool(5);

        // TODO fix InterruptedException

        ThreadPool threadPool = new ScalableThreadPool(5, 10);

        threadPool.start();

        for (int i = 0; i < 20; i++) {
            threadPool.execute(new Task(i));
        }
    }
}
