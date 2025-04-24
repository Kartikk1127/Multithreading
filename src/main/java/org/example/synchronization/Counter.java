package org.example.synchronization;

public class Counter {
    private int count = 0;

/*    public void increment(){ this method will not fetch the desired results since there is no synchronization. This condition is known as Race Condition.
        count++;
    }*/

    public void increment(){ //this method will fetch the desired results since there is proper synchronization
        synchronized (this){
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}
