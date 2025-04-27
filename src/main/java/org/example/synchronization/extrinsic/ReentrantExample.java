package org.example.synchronization.extrinsic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* A ReentrantLock means the same thread can acquire the same lock multiple times without getting stuck.

Each lock() call must match with a unlock() call, otherwise the lock won't fully release.

 If normal locks (without reentrancy) were used, the thread would deadlock when it tried to lock again inside innerMethod().
*/
public class ReentrantExample {
    private final Lock lock = new ReentrantLock();


    public void outerMethod(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod(){
        //this line reacquires lock on the current thread, is possible in case of reentrant locks else would have been a deadlock condition.
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();
    }
}
