package com.mall.concurrency.example.singleton;

import com.mall.concurrency.annotations.NotThreadSafe;
import com.mall.concurrency.annotations.ThreadSafe;

/**
 *  饿汉模式
 *  类加载的时候实例化对象
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有构造函数
    private SingletonExample2 () {}

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
