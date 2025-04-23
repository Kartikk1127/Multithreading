package org.example;

//Thread.yield() is a static method in Java used to hint to the thread scheduler that the current thread is willing to pause and let other threads of the same or higher priority run.
//The current thread gives others a chance to execute.
//The thread does not go to sleep or wait, it stays RUNNABLE.
//There is no guarantee that the scheduler will allow the other threads to run, it might happen it might not.
public class YieldThread extends Thread{

    public YieldThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++){
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        YieldThread thread1 = new YieldThread("t1");
        YieldThread thread2 = new YieldThread("t2");
        thread1.start();
        thread2.start();
    }

    /* OUTPUT:
* t1 is running
t2 is running
t2 is running
t1 is running
t1 is running
t2 is running
t1 is running
t1 is running
t1 is running
t2 is running
t2 is running
t2 is running*/
}
