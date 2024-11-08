package com.lcy.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author liuweijin
 * @date 2024-07-04
 * @desc
 */
public class FlashLock {

    public void lock() {
        System.out.println("lock");
        sync.acquire(1);
    }

    public void unlock() {
        System.out.println("unlock");
        sync.release(1);
    }

    private final Sync sync = new Sync();

    // 这个内部类就是继承并实现了 AQS 但我这里只先实现两个方法
    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        public boolean tryAcquire(int acquires) {
            final Thread thread = Thread.currentThread();

            int state = getState();
            if(state==0){
//                if(hasQueuedPredecessors()){
//                    return false;
//                }
                // CAS 方式尝试获取锁，成功返回true，失败返回false
                if (compareAndSetState(0, 1)) {
                    setExclusiveOwnerThread(thread);
                    return true;
                }
            }else if(thread==getExclusiveOwnerThread()){
                setState(state+acquires);
                return true;
            }
//            System.out.println("--"+state);
//            boolean b = getExclusiveOwnerThread() == thread;
//            System.out.println(b);

            return false;
        }
        @Override
        protected boolean tryRelease(int releases) {
            // 释放锁，这里为什么不像上面那样也是 CAS 操作呢？请读者思考
            setState(0);
            return true;
        }
    }

}
