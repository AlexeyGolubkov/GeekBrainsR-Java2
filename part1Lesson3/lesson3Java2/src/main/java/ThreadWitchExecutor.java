import java.util.concurrent.Executor;

public class ThreadWitchExecutor implements Executor {
    public void execute(Runnable r) {
        r.run();

    }


}