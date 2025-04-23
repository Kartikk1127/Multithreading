package org.example;
/*
* 1. A daemon thread is a background thread that provides services to user threads. Think of it like a helper thread that runs in the background and dies automatically when all user threads(like main) are done.
* 2. These are like garbage collector.
* 3. They automatically terminate when all user threads have finished, the JVM exits at that point.
* 4. They can be terminated abruptly without completing their work hence not meant for critical tasks.
* 5. User threads keep JVM alive, but daemon threads CANNOT prevent JVM shutdown.*/
public class DaemonThread extends Thread{

    @Override
    public void run() {
        while(true){
            System.out.println("Hello world!");
        }
    }

    public static void main(String[] args) {
        DaemonThread t1 = new DaemonThread();
        t1.setDaemon(true);
        t1.start(); //this is not a daemon thread yet
        System.out.println("Main done");
    }
}
