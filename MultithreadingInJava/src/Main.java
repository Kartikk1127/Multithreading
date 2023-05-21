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

        Stack stack = new Stack(5);

        new Thread(()->{
            int counter=0;
            while(++counter<10)
                System.out.println("Pushed " + stack.push(100));
        }, "Pusher").start();

        new Thread(()->{
            int counter=0;
            while(++counter<10)
                System.out.println("Popped " + stack.pop());
        }, "Popper").start();

        System.out.println("Main is exiting");

    }
}