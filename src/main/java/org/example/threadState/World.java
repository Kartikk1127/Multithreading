package org.example.threadState;

/*public class World extends Thread{
    @Override
    public void run() {
        for(; ;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}*/

public class World implements Runnable{
    @Override
    public void run() {
        //RUNNING state of thread
        for(; ;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
