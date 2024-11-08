package com.lcy.util;

/**
 * @author liuweijin
 * @date 2024-10-17
 * @desc
 */
public class ConcurrencyTest {

    private static final long[] count = new long[]{10000, 100000, 1000000, 10000000, 100000000};

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < count.length; i++) {
            System.out.println("===> 测试数据量：" + count[i]);
            // 并发执行
            concurrency(count[i]);
            // 单线程执行
            serial(count[i]);
        }
    }
    private static void concurrency(long count) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (int i = 0; i < count; i++) {
                a += 5;
            }

        });
        thread.start();

        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        Thread.yield();
        long end = System.currentTimeMillis();
        System.out.println("多线程执行：" + (end - start));
    }
    private static void serial(long count) {
        long start = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long end = System.currentTimeMillis();
        System.out.println("单线程执行：" + (end - start));
    }
}