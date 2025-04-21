package org.example;

public class Test {
    public static void main(String[] args) {

        World world = new World();
//        world.run();
        Thread t1 = new Thread(world); //NEW state of thread
        t1.start(); //RUNNABLE

        for(; ;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
