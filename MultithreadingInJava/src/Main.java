import com.Kartikey.Stack;
import com.Kartikey.Thread1;
import com.Kartikey.Thread2;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main is starting");

//        Thread thread1 = new Thread1("thread1");
//        thread1.setDaemon(false); //now this is a user thread
//        thread1.start();
//
//        Thread thread2 = new Thread(()->{
//            for(int i=0;i<5;i++)
//              System.out.println(Thread.currentThread() + ", "+i);
//        }, " thread2");
//        thread2.start();

//        Stack stack = new Stack(5);
//
//        new Thread(()->{
//            int counter=0;
//            while(++counter<10)
//                System.out.println("Pushed " + stack.push(100));
//        }, "Pusher").start();
//
//        new Thread(()->{
//            int counter=0;
//            while(++counter<10)
//                System.out.println("Popped " + stack.pop());
//        }, "Popper").start();
//
//        System.out.println("Main is exiting")

//        Thread thread = new Thread(()->{
//            try{
//                Thread.sleep(1);
//                for(int i=10000;i>0;i--);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }, "States");
//
//        thread.start();
//
//        while (true){
//            Thread.State state = thread.getState();
//            System.out.println(state);
//            if(state== Thread.State.TERMINATED) break;
//        }

//        Thread thread = new Thread(()->{
//            System.out.println(Thread.currentThread());
//        }, "Our thread");
//
//        thread.start();
//
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("Main is exiting");

        //creating a deadlock

        String lock1 = "Kartik";
        String lock2 = "Srivastava";

        Thread thread1 = new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){
                    System.out.println("Lock acquired");
                }
            }
        } ,"thread1");
        Thread thread2 = new Thread(()->{
            synchronized (lock2){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1){
                    System.out.println("lock acquired");
                }
            }
        } ,"thread2");

        thread1.start();
        thread2.start();

        System.out.println("Main is exiting");
    }
}