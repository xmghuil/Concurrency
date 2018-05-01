package com.mall.concurrency.example.threadLocal;

public class RequestHolder {
    private static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long value) {
        requestHolder.set(value);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
