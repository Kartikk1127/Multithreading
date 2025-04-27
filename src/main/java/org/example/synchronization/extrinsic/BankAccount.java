package org.example.synchronization.extrinsic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                //this is a better alternative for synchronized since now other threads won't wait for indefinite period of time but just 1 sec, if the lock is released they'll get executed else they won't
                if (balance>=amount){
                    try{
                        System.out.println(Thread.currentThread().getName() + " proceeding to withdraw");
                        Thread.sleep(3000);
                        balance-=amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                    } catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance.");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock. Will try later.");
            }
        } catch (Exception e){
            Thread.currentThread().interrupt();
        }
        if (Thread.currentThread().isInterrupted()){
            //you can perform some operation here.
        }
    }
}
