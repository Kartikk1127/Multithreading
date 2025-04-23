package org.example.threads;

//We can also set the priority of threads as to which thread we want to execute first.
//By default, the min value = 1, max value = 10 and normal value = 5
//It is not guaranteed that the priority we set always has its precedence. So even if you set a thread with the highest priority,
// there are still chances that the thread might not be executed first.
public class PriorityThread extends Thread{

    public PriorityThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++){
            StringBuilder a = new StringBuilder();
            for(int j = 0; j<10000; j++){
                a.append("b");
            }
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - Count: " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e){

            }
        }
    }

    public static void main(String[] args) {
        PriorityThread low = new PriorityThread("low");
        PriorityThread medium = new PriorityThread("medium");
        PriorityThread high = new PriorityThread("high");

        low.setPriority(Thread.MIN_PRIORITY);
        medium.setPriority(Thread.NORM_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);

        low.start();
        medium.start();
        high.start();
    }
}
