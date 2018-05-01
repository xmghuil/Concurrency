package com.mall.concurrency.example.singleton;

import com.mall.concurrency.annotations.NotThreadSafe;

/**
 *  懒汉模式
 *  第一次调用的时候才初始化对象
 */
@NotThreadSafe
public class SingletonExample1 {

    // 私有构造函数
    private SingletonExample1 () {}

    // 单例对象
    private static SingletonExample1 instance = null;

    // 静态工厂方法
    public static SingletonExample1 getInstance() {

        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
