# Multithreading

## CPU
The CPU, often referred to as teh brain of the computer, is responsible for executing instructions from programs. It performs basic arithmetic, logic, control, and input/output operations specified by the instructions.

## Core
A core is as individual processing unit within a CPU. Modern CPUs can have multiple cores, allowing them to perform multiple tasks simultaneously.
A quad-core processor has four cores, allowing it to perform four tasks simultaneously. For instance, on core could handle your web browser, another a music player, another a download manager, and another a background system update.

## Program
A program is a set of instructions written in a programming language that tells the computer how to perform a specific task. 
Microsoft Word is a program that allows users to create and edit documents.

## Process
A process is an instance of a program that is being executed. When a program runs, the operating system creates a process to manage its execution.
When we open Microsoft Word, it becomes a process in the operating system.

## Thread
A thread is the smallest unit of execution within a process. A process can have multiple threads, which share the same resources but can run independently.
A web browser like Google Chrome might use multiple threads for different tabs, with each tab running as a separate thread.

## Multitasking
Multitasking allows an operating system to run multiple processes simultaneously. On single core CPUs, this is done through time-sharing, rapidly switching between tasks. On multicore CPUs, true parallel execution occurs with tasks distributed across cores. The OS scheduler balances the load, ensuring efficient and responsive system performance.  
eg: Browsing internet while listening to music and downloading a file.

Multitasking utilizes the capabilities of a CPU and its cores. When an operating system performs multitasking, it can assign different tasks to different cores. This is more efficient than assigning all tasks to a single core.

## Multithreading
Multithreading refers to the ability to execute multiple threads within a single process concurrently.  
eg: A web browser can use multithreading by having separate threads for rendering the page, running JavaScript, managing user inputs. This makes the browser more responsive and efficient.

Multithreading enhances the efficiency of multitasking by breaking down individual tasks into smaller sub-tasks or threads. These threads can be processed simultaneously, making better use of the CPU's capabilities.

_In a single-core system both threads and processes are managed by the OS scheduler through [time slicing](#time-slicing) and context switching to create the illusion of simultaneous execution._  
_In a multicore system both threads and processes can run in true parallel on different cores, with the OS scheduler distributing tasks across the cores to optimize the performance._

### Time Slicing
**Definition**: Time slicing divides CPU time into small intervals called time slices or quanta.

**Function**: The OS  scheduler allocates these time slices to different processes and threads, ensuring each gets a fair share of the CPU time.

**Purpose**: This prevents any single process or thread from monopolizing the CPU, improving responsiveness and enabling concurrent execution.

### Context Switching
**Definition**: This is the process of saving the state of a currently running process or thread and loading the state of the next one to be executed.

**Function**: When a process or thread's time slices expires, the OS scheduler performs a context switch to move the CPU's focus to another process or thread.

**Purpose**: This allows multiple processes and threads to share the CPU, giving the appearance of simultaneous execution on a single-core CPU or improving parallelism on multicore CPUs.


### Key Differences

| Aspect                 | Multitasking                                             | Multithreading                                                   |
|------------------------|----------------------------------------------------------|------------------------------------------------------------------|
| **Definition**         | Running multiple applications or processes concurrently. | Running multiple threads within a single application or process. |
| **Level of Operation** | Operates at the level of **processes**.                  | Operates at the level of **threads**.                            |
| **Granularity**        | Coarse-grained; deals with independent programs.         | Fine-grained; deals with parts (threads) of the same program.    |
| **Memory Management**  | Each process has its own memory and resources.           | Threads share the same memory and resources within a process.    |
| **Resource Handling**  | Manages resources between separate programs.             | Manages resources within a single program.                       |
| **Use Case**           | Ideal for running multiple applications simultaneously.  | Ideal for improving performance within a single application.     |
| **Benefit**            | Enhances system utilization and overall productivity.    | Enhances application responsiveness and efficiency.              |

### Real-Life Analogy

Imagine you're at a restaurant kitchen:

- **Multitasking** is like multiple chefs each working on separate orders at the same time — each with their own tools and ingredients (like separate processes).
- **Multithreading** is like one chef preparing different parts of the same dish at once — boiling pasta, frying veggies, and garnishing — all tasks (threads) share the same kitchen.

-> In java, multithreading is the concurrent execution of two or more threads to maximize the utilization of the CPU. Java's multithreading capabilities are part of the java.lang package, making it easy to implement concurrent execution.  
-> Java supports multithreading through its **java.lang.Thread** class and **java.lang.Runnable** interface.

## Important
1. To create a new thread in Java, you can either extend the Thread class or implement the Runnable interface

## Lifecycle of Thread
The lifecycle of a thread in Java consists of several states, which a thread can move through during its execution.
1. **New :** A thread is in this state when it is created but not yet started.
2. **Runnable :** After the start method is called, the thread becomes runnable. It's ready to run and is waiting for CPU time.
3. **Running :** The thread is in this state when it is executing.
4. **Blocked/Waiting :** A thread is in this state when it is waiting for a resource or for another thread to perform an action.
5. **Terminated :** A thread is in this state when it has finished executing.

#### When to use Thread and Runnable?
If a class is already extending another class, in that case extending Thread class is not possible and hence implementing Runnable interface is the solution.
For any other scenario either extending Thread class or implementing Runnable interface is fine.
