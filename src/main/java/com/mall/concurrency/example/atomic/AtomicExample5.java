package com.mall.concurrency.example.atomic;

import com.mall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
@ThreadSafe
public class AtomicExample5 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同事并发执行的线程数
    public static int threadTotal = 200;

    // AtomicBoolean.compareAndSet 方法确保程序只被执行一次
    public static AtomicBoolean isExecuted = new AtomicBoolean(false);

    public static void main(String[] args) throws Exception{

        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 信号量，同时可以通过的线程数
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            // 执行线程， jdk8 lambda›的写法
            executorService.execute( () -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("isHappened: {}", isExecuted.get());

    }

    private static void test() {
        if (isExecuted.compareAndSet(false, true)) {
            log.info(" execute ");
        }
    }
}
