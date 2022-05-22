package task1;

import java.util.concurrent.Callable;

public class Task<T> {

    private Callable<? extends T> callable;
    volatile MyCoolException exception;
    volatile T result;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() throws MyCoolException {

        if(exception != null) {
            System.out.println("my exception");
            throw exception;
        }

        if (result != null) {
            System.out.println("cash");
            return result;
        }


        synchronized (this) {
            try {
                System.out.println("callable.call");
                result = callable.call();
            } catch (Exception e) {
                exception = new MyCoolException(e);
                throw exception;
            }
        }



        return result;
    }
}
