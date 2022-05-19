import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ScalableThreadPool implements ThreadPool{

    private int threadsNumberMin;
    private int threadsNumberMax;
    private int threadsNumberCur;

    private List<Thread> threads;
    private Queue<Runnable> queue;

    public ScalableThreadPool(int min, int max) {
        threadsNumberMin = min;
        threadsNumberMax = max;
        threadsNumberCur = threadsNumberMin;
        threads = new ArrayList<>();
        queue = new LinkedList<>();
    }

    @Override
    public void start() {
        for (int i = 0; i < threadsNumberMin; i++) {
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
            CheckThreadsNumber();
        }
    }

    private void CheckThreadsNumber() {
        if (queue.size() > threads.size() && threads.size()< threadsNumberMax) {
            Thread thread = new TaskThread();
            thread.start();
            threads.add(thread);
            System.out.println("New " + thread.getName() + " started");
        }
        if (queue.size() < threads.size() && threads.size() > threadsNumberMin) {

            threads.get(threads.size() - 1).interrupt();
            System.out.println("removed extra " + threads.get(threads.size() - 1).getName());
            threads.remove(threads.size() - 1);
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
                            CheckThreadsNumber();

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
