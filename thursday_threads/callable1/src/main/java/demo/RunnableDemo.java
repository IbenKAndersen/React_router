package demo;

import static java.util.Collections.list;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ibenk
 */
public class RunnableDemo {
    
    public static void main(String[] args) throws InterruptedException{
        
        //Get ExecutorService from Executor utility class, thread pool size is 3
        //3 Threads running means that each second three tasks are solved (call method takes one second)
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        //Create MyCallable instance
        //Runnable runnable = new RunnableDemo();
        
        for (int i = 0; i < 100; i++) {
            final int j = i;
            
            executor.submit(new Runnable(){
                @Override
                public void run() {
                    System.out.println(j);
                }
            });
        }
//        executor.shutdowm();
//        //Or use a CountDownLatch
//        executor.awaitTermination(1, TimeUnit.DAYS);
//        
//        latch.await();
//        for (String str:list) {
//            System.out.println(new Date()+ "::" +str);
//        }
    }
    
}
