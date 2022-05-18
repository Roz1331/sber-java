import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FixedThreadPool implements ThreadPool{

    private int threadsNumber;

    private List<Thread> threads;
    private Queue<Runnable> queue;

    public FixedThreadPool(int n) {
        threadsNumber = n;
        threads = new ArrayList<>();
        queue = new LinkedList<>();
    }

    @Override
    public void start() {
        for (int i = 0; i < threadsNumber; i++) {
            Thread thread = new TaskThread();
            thread.start();
            threads.add(thread);
            System.out.println(thread.getName() + " started");
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (queue) {
            queue.add(runnable);
            queue.notify();
        }
    }


    private class TaskThread extends Thread{

        @Override
        public void run() {
            Runnable runnable;
            while(true) {
                synchronized (queue) {
                    while(queue.isEmpty()) {
                        System.out.println(this.getName() + " is ready");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    runnable = queue.remove();
                }
                runnable.run();
            }
        }
    }

}
