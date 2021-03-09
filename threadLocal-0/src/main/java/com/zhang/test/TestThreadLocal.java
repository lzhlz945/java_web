package com.zhang.test;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class TestThreadLocal {

    private static Map<String,Object> map=new ConcurrentHashMap<>();
    private static Random random = new Random();
    public  void test(){

        String name=Thread.currentThread().getName();

        int i=random.nextInt(1000);
        System.out.println("线程之前"+name+": "+i);
        map.put(name,i);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object o = map.get(name);
        System.out.println("线程之后"+name+": "+o);

    }

    public static void main(String[] args) {
        for (int j = 0; j < 3; j++) {

        new Thread(new MyRunnable()).start();
        }
    }
}
class MyRunnable implements Runnable{


    @Override
    public void run() {
        TestThreadLocal testThreadLocal = new TestThreadLocal();
        testThreadLocal.test();

    }

}
