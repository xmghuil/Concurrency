package com.mall.concurrency.example.publish;

import com.mall.concurrency.annotations.NotRecommend;
import com.mall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotRecommend
@NotThreadSafe
public class Escape {

    private int isCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public  InnerClass() {
            log.info("{}", Escape.this.isCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
