public class Task implements Runnable{
    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.printf("Task-%d is running, %s\n", id, Thread.currentThread().getName());
    }
}
