package mirea.practice.practice4;

import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        MyExecutorService myExecutorService = new MyExecutorService(4);
        for (int i = 0; i < 10; i++){
            myExecutorService.execute(()->{
                System.out.println("Started " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Finished " + Thread.currentThread().getName());
            });
        }
        myExecutorService.shutdown();
    }
}
