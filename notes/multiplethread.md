# Multiple Thread

## Creation:
- Extends Thread Class
```aiignore
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread using extends thread");
    }
}
   Thread t = new MyThread();
t.start();
```
- Implements Runnable
```aiignore
public class MyRunnable implements Runnable{
    @Override
    public void run() {
    System.out.println("Start new thread using Runnable");
    }
}
Thread t2 = new Thread(new MyRunnable());
```
- Callable
```aiignore
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
    return "Start new thread using Callable";
    }
}
```

## t.start() vs t.run()
- t.start(): Creates a new thread, caseing the run() method to execute in parallel
- t.run: Executes the run() method in the current thread just like any other method call, without starting a new thread


## call() vs run()
- call() can return a result and throw checked exceptions, work with ExecutorService and get the result via Future
- run() cannot return a result and not check exceptions


## new Thread vs Runnable:
- Better Separation of Concerns
- Allows Extending Other classes
- Better for Thread pools
- Reusability of the Runnable Object
- Clearer API Contracts



## Thread status
- New: a thread that has been created but not yet started, before start() is 
- Runnable: A thread that is ready to run or is actively running
- Blocked: A Thread that is blocked, waiting for a monitor lock to enter a synchronized block or method.
- Waiting: A thread that is waiting indefinitely for another thread to perform a specific action
  - Object.wait(), Thread.join() without a timeout, or LockSupport.park()
- Timed_Waiting: A thread that is waiting for another thread to perform an action for a specified period. 
  - Thread.sleep(), Object.wait() with a timeout, Thread.join() with a timeout, or LockSupport.parkNanos() or parkUntil().
- Terminated: A thread that has completed execution either by returning from the run() method or due to an unhandled exception


## Interrupt, Daemon, Join
- Interrupt: Does not stop the thread immediately, sleeping thread will throw InterruptedException, running thread will set a flag
  - If a thread is blocked (Thread.sleep(), Object.wait(), or join()), calling interrupt will cause the thread to take up, throw an interruptedexception, and reset the status
  - if a thread is running(not blocked), calling interupt to set a flag, can can check this flag with Thread.interrupted() or isInterrupted()














