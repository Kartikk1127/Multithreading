package org.example.synchronization.extrinsic;

//this is an example where a particular thread when acquires a lock, it might not be able to release the lock due to some problem.
//this will lead to another thread keep waiting which is not good for our system.
//this is happening since the lock acquired by the thread is automatic
public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(50);
            }
        };
        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}
