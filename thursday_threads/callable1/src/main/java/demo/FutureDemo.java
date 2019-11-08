package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author ibenk
 */
public class FutureDemo {
    
    private static final ExecutorService threadpool = Executors.newCachedThreadPool();
    
    private static List<Future<String>> futures =  new ArrayList();
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        for (int i = 0; i < 100; i++) {
           Future<String> fut = threadpool.submit(new MyCallable()); //return value of submit is a Future
           futures.add(fut);
        }
        for (Future<String> fut : futures) {
            System.out.println(fut.get());
        }
    }
    
    private static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName();
        }
    }
    
}
