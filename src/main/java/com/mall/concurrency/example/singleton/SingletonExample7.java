package com.mall.concurrency.example.singleton;

import com.mall.concurrency.annotations.Recommend;
import com.mall.concurrency.annotations.ThreadSafe;

/**
 *  枚举模式  最安全
 */
@Recommend
@ThreadSafe
public class SingletonExample7 {

    private SingletonExample7() {}

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton {
        INSTANCE;

        private  SingletonExample7 singleton;

        // JVM保证该方法只被执行一次
        Singleton () {
            singleton = new SingletonExample7();
        }

        public  SingletonExample7 getSingleton() {
            return singleton;
        }
    }

}
