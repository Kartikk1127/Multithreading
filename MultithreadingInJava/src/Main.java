import com.Kartikey.Thread1;
import com.Kartikey.Thread2;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main is starting");

        Thread thread1 = new Thread1("thread1");
        thread1.setDaemon(false); //now this is a user thread
        thread1.start();

        Thread thread2 = new Thread(()->{
            for(int i=0;i<5;i++)
              System.out.println(Thread.currentThread() + ", "+i);
        }, " thread2");
        thread2.start();

        System.out.println("Main is exiting");

    }
}