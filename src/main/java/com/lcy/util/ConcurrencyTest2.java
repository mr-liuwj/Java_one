package com.lcy.util;

/**
 * @author liuweijin
 * @date 2024-10-17
 * @desc
 */
public class ConcurrencyTest2 extends Thread{

    public ConcurrencyTest2(String name){
        super(name);
    }

    @Override
    public void run() {
        this.getName();
        this.yield();
        super.run();
    }

    static Integer num = 0;
    public void testThread1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 50000; j++) {
                num++;
            }
        });
        t1.yield();
        t1.start();
        t1.join();;

    }
    public void testThread2() throws InterruptedException {
        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 50000; j++) {
                num++;
            }
        });
        t2.start();
        t2.join();
    }
    public static void main(String[] args) {
        int i=10;
        int x = i++;
        System.out.println(x);
        System.out.println(i);
        i=10;
        System.out.println(++i);

        String binaryString = Integer.toBinaryString(2229);
        System.out.println(binaryString);
        int i1 = 2229 >>> 2;
        System.out.println(Integer.toBinaryString(i1));
    }
}
