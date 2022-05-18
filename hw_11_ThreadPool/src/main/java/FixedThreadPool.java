public class FixedThreadPool implements ThreadPool{

    private int threadsNumber;

    public FixedThreadPool(int n) {
        threadsNumber = n;
    }

    @Override
    public void start() {

    }

    @Override
    public void execute(Runnable runnable) {

    }
}
