package com.mall.concurrency.example.singleton;

import com.mall.concurrency.annotations.NotRecommend;
import com.mall.concurrency.annotations.ThreadSafe;

/**
 *  懒汉模式的升级版，线程安全但是效率低
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private SingletonExample3() {}

    private static SingletonExample3 instance;

    public synchronized static SingletonExample3 getInstance() {

        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
