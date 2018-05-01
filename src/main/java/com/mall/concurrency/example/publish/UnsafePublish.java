package com.mall.concurrency.example.publish;

import com.mall.concurrency.annotations.NotRecommend;
import com.mall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnsafePublish {

    // 不安全的发布对象，不推荐这种写法

    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish publish = new UnsafePublish();
        log.info("{}", Arrays.toString(publish.states));
        publish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(publish.getStates()));
    }
}
