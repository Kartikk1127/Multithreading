package org.example.synchronization.intrinsic;

public class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        if (balance>=amount){
            System.out.println(Thread.currentThread().getName() + " proceeding to withdraw");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e){
            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance");
        }
    }
}
