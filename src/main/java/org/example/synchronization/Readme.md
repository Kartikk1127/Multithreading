# Thread Synchronization Issue

### Shared Resource(Race Condition):
Both ```thread1``` and ```thread2``` are sharing the same **counter** object. Since the ```increment()``` method is not synchronized, both threads can access and modify ```count``` simultaneously, leading to the race condition.

### Non-Atomic Operation:
The ```count++``` statement isn't atomic, thereby the two threads might overwrite each other's value and cause loss of increments.

### Context Switching
Both threads might read the same value before either updates, thereby making one increment **invisible**.

### No Synchronization
Both threads execute ```increment()``` method concurrently without restriction.

## Fix
The above issue can be fixed by :
1. Making the method **synchronized** 
2. Increasing the count inside a **synchronized block**.
3. Using a thread safe data type for count like **AtomicInteger**

## Terminologies
**Mutual Exclusion**: This concept ensures that multiple threads should not access the critical section simultaneously.

**Lock**: This is a synchronization mechanism used to control access to a shared resource by multiple threads. It ensures only one thread can access the critical section at a time.  
There are 2 types of locks:     
1. _Intrinsic Lock_ : These are built into every object in Java. You don't see them, but they're there. When you use a synchronized keyword, you're using these locks.  
2. _Extrinsic Lock_ : These are more advanced locks you can control yourself using the Lock class from ```java.util.concurrent.locks```. You explicitly say when to lock and unlock, giving you more control over how and when threads can access the critical section.

