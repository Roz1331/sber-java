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
            throw exception;
        }

        if (result != null) {
            return result;
        }


        synchronized (this) {
            try {
                result = callable.call();

            } catch (Exception e) {
                exception = new MyCoolException(e);
                throw exception;
            }
        }



        return result;
    }
}
