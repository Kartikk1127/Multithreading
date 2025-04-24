package org.example.synchronization;

public class Test {

    public static void main(String[] args) {

        Counter counter = new Counter();
        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e){

        }
        System.out.println(counter.getCount());
    }
}
