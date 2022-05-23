package task2;

import javax.naming.Context;

public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
