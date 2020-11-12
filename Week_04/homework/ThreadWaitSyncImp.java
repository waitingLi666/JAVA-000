package week04;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadWaitSyncImp {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Object obj = new Object();
        AtomicInteger result = new AtomicInteger();
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronized (obj){
                            result.set(sum());
                            obj.notify();
                        }
                    }
                }
        );
        thread.start();
        synchronized (obj){
            try {
                obj.wait();
                System.out.println("异步计算结果为："+result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
