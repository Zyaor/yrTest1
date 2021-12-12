package java.com.yr;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class hello {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
           5,10,1L,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.CallerRunsPolicy()
        ) ;


        for (int i = 10; i > 0; i--) {
            System.out.println("线程名:"+i);
            int finalI = i;
            executor.execute(
                () ->{
                    try {
                        Thread.sleep(100);
                        System.out.println("第"+ finalI +"个线程，线程名："+Thread.currentThread().getName());
                    }catch (Exception e){

                    }
                }
            );
        }
        executor.shutdown();
        try {
            executor.awaitTermination(5,TimeUnit.SECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("测试分支");
    }
}
