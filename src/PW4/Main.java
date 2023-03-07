package PW4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        MyExecutorService service = new MyExecutorService(3);
        for (int i = 0; i < 10; i++) {
            Future<String> res = service.submit(() -> Thread.currentThread().getName());
            try {
                System.out.println(i + " " + res.get());
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        service.shutdown();
    }
}
