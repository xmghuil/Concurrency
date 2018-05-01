package com.mall.concurrency.example.atomic;

import com.mall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample4 {

    // 修饰的字段必须是以volatile修饰的，不能是static修饰的
    private static AtomicIntegerFieldUpdater<AtomicExample4> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample4.class, "count");

    @lombok.Getter
    public volatile int count = 100;
    public static void main(String[] args) {

        AtomicExample4 example4 = new AtomicExample4();
        if (updater.compareAndSet(example4, 100, 200)) {
            log.info(" updater success 1, {}", example4.getCount());
        }
        if (updater.compareAndSet(example4, 100, 200)) {
            log.info(" updater success 2, {}", example4.getCount());
        } else {
            log.info(" updater failed, {}", example4.getCount());
        }
    }
}
