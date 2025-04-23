package org.example.threads;
//below is an example of the interrupted exception that is thrown by a thread
public class InterruptedThread extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread is running");
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted: " + e); //Sleep interrupted
        }
    }

    public static void main(String[] args) {
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        thread.interrupt(); //this method will interrupt the thread, doesn't matter what is going on in the thread if this method is invoked the thread will throw an exception.

    }
}


/*
* 1. Calling thread.interrupt() doesn't forcibly stop a thread, it just sets an internal flag. If the thread is in a blocking call like sleep(), wait() or join(), it throws an Interrupted Exception.
* 2. Since interrupt()method is called right after start(), there's a race condition. If the thread hasn't reached sleep() yet, the interrupt flag is set, and sleep() will immediately throw an exception. But if the thread finishes execution before interrupt(), the interrupt has no effect.
* 3. Even after throwing InterruptedException, the thread continues unless you explicitly return or stop inside the catch block.*/