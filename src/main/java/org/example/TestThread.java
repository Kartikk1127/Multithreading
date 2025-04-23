package org.example;

//this example focuses on the join method of the thread which can help us in knowing when a thread has finished executing.
public class TestThread extends Thread{

    @Override
    public void run() {
//        System.out.println("Thread is running....");
        for (int i = 1; i <= 5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestThread t1 = new TestThread();
        t1.start();
        t1.join(); //this method waits for the thread to finish its execution after which the control will move forward.
        System.out.println("Hello");
    }
}
