package com.mall.concurrency.example.singleton;

import com.mall.concurrency.annotations.ThreadSafe;

/**
 *  懒汉模式
 *  程序加载时实例化对象
 */
@ThreadSafe
public class SingletonExample6 {

    private SingletonExample6() {}

    // 使用静态块实现单例模式，一定要注意静态块和instance的定义的顺序
    // 如果static静态块写在前面，那么instance初始化后又会赋值成为null

    private static SingletonExample6 instance = null;

    static{
        instance = new SingletonExample6();
    }

    public static SingletonExample6 getInstance() {
        return  instance;
    }

    public static void main(String[] args) {
        System.out.println( SingletonExample6.getInstance().hashCode() );
        System.out.println( SingletonExample6.getInstance().hashCode() );
    }

}
