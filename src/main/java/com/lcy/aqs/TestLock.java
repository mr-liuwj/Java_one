package com.lcy.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuweijin
 * @date 2024-07-04
 * @desc
 */
public class TestLock {
    private static FlashLock flashLock = new FlashLock();

    public static long count = 0;

    private static void add() {
        flashLock.lock();
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        flashLock.lock();
//        add2();
//        flashLock.unlock();
        // 没啥异常，我就直接释放锁了
        flashLock.unlock();
    }
}
