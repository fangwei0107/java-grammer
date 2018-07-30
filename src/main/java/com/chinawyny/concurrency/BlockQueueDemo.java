package com.chinawyny.concurrency;

import org.apache.commons.lang.StringUtils;

public class BlockQueueDemo {

    public static void main(String[] args) {
        Integer[] a = {1,2,3};
        System.out.println(StringUtils.join(a, "|"));
    }
}
