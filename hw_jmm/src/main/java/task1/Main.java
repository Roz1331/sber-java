package task1;

public class Main {

    public static void main(String[] args) {

        Task<Integer> task = new Task<>(() -> 0);

        Runnable runnable = () -> {
            try {
                task.get();
            }
            catch (MyCoolException e) {
                e.printStackTrace();
            }
        };

        int threadsCount = 10;
        for (int i = 0; i < threadsCount; i++) {
            new Thread(runnable).start();
        }

    }
}
