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
- t.start(): Creates a new thread, causing the run() method to execute in parallel
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

- Daemon: is low priority thread that runs in the background to perform task
  - Difference between Daemon vs non-Daemon
  - Characteristics of Daemon Threads:
    - Background Tasks: They are used for background tasks that should not prevent the JVM from existing
    - JVM exit: The JVM will exit as soon as all non-Daemon threads are finished
    - Setting a thread as daemon: setDaemon(true) before calling start(), otherwise, get an `IllegalThreadStateException`
  - Common use cases: tasks like monitoring, garbage collection, brackground logging, idle resource cleanup

- Join: is used to wait for a thread to finish its execution
  - Without timeout: without any arguments, the calling thread will wait indefinitely unitl the target thread finishes
  - Without time: join(long millis) to specify maximum time to wait for the thread to finsih. After this time, calling thread resume whether the target thread has completed or not
  - 

## Synchronized:
- Ensure only one thread can execute a block or method at a time
- preventing race conditions
- prevent multiple threads from concurrently accessing a critical section of code

## Synchronized Method:
- declare a method as synchronized
- acquires a lock
- no other thread can call any other synchronized method on that object until the lock is released.


## Synchronized Block:
- A synchronized block allows more control over what part of the code is synchronized, which can lead to better performance
- You can choose which object to lock 

## Locking Mechanism:
- Instance Methods: When you synchronize an instance method or block, the lock is acquired on the instance of the class
- Static Methods: When you synchronize a static method, the lock is acquired on the class object itself 

## Drawbacks of synchronized:
- Performance Overhead: Acquiring and releasing locks introduces overhead
- Deadlock Risk: if two or more threads are waiting for each other’s locks
- Limited Flexibility:

## ReentrantLock: Advance Locking Mechanism
- Ability to try to acquire the lock (trylock())
  - attempts to acquire the lock but does not block if the lock is already held by another thread
- interruptible locks
  - lockInterruptibly():
- Fair locking:  passing true to the constructor. A fair lock ensures that threads acquire the lock in the order they requested it (FIFO order).  a non-fair lock (the default behavior) does not guarantee the order
```aiignore
private final Lock lock = new ReentrantLock();
lock.lock();
```

## Pessimistic Lock:
- low performance due to blocking but ensures no conflicts
- locks the resource as soon as accessed 


## Optimistic Locking
- No lock, version checking at commit time
- No Deadlock
- Conflict detected at commit time, transaction may retry
- High performance with low contention, degrades with frequent conflict

## wait(), notify(), notifyAll()
- are used with synchronized and provide basic thread signaling, where the intrinsic lock (monitor) of an object is used to manage concurrency.
- must always be called on an object
- Must be called inside a synchronized block or method


## condition.await() & condition.signal() & condition.signalAll()
- ReentrantLock with Condition
```aiignore
private final Lock lock = new ReentrantLock();
privite final con
```


## Atomic: performing atomic operations without the use of explicit synchronization
-CompareAndSwap(CAS) ensure the operation is performed atomically. compare the current value with an expected value and sets it to a new value if they match

## ThreadPool:
- ThreadPool:
  - Executors class 
  - is a collection of pre-created that are available for use by tasks.
  - reuses a fixed number of threads for executing tasks
  - java.util.concurrent
  - Benefits:
    - Improved Performance: Resuing threads reduces the overhead of creating and destroying
    - Better Resource management control the number of threads in the pool, preventing the system from being overwhelmed by too many threads
    - Task Scheduling: can schedule task efficiently  
    - Automatic Thread Management: Pool manages the lifecycle of threads
    - Return Future Object to see the result
    - use executorService.shutdown() to showdown the thread pool
- Way to create ThreadPool:
  - ExecutorService executorService = Executors.newFixedThreadPool(3);
  - ExecutorService executorService = Executors.newCachedThreadPool();
  - ExecutorService executorService = Executors.newSingleThreadExecutor();
  - ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    - scheduler.schedule(task, 5, TimeUnit.SECONDS); run after 5 second delay
    - scheduler.scheduleAtFixedRate(new Task("Repeated Task"), 2, 3, TimeUnit.SECONDS); run every 3 seconds with initial delay of 2 seconds
  - Type of ThreadPool
    - FixedThreadPool: Fixed number of threads, Threads remain alive throughout the lifecycle
    - CachedThreadPool: Dynamic, create threads as needed, Threads expire after 60 seconds of inactivity
    - SingleThreadExecutor: Only one
    - ScheduledThreadPool
  - using execute without Future object returned (Runnable)
  - using submit return Future object (Callable)
## Future
- Future
  - Runnable without return value, Callable with return value
  - ExecutorService.submit() return Future object
  - Represents a result that will be available in the future once the task in complete
  - retrieve the result of the task using the get method. This call may block until the result is available, but you can check the status of the task without blocking
  - it allows you to check whether the task is completed, cancelled or still running
  - can cancel the task using the cancel method if it hasn't started or is in progress
  - Common Method of the Future interface:
    - get(): Retrieves the result of the task, blocking if necessary until the task is done
      - get(long timeout, timeUnit unit): Retrieves the result with a timeout, if the result is not ready within the specified time, a 
    - isDone: Return true if the task has completed, otherwise fasle
    - cancel(boolean mayInterruptIfRunning) Attempts to cancel the task, if the task is already completed or cancelled, it returns false
    - isCancelled: Returns true if the task was cancelled before it completed


- CompletableFuture
  - non-block execution: allows you to set up callback taht will execute once a task is complete, without blocking the main thread
  - Task chaining: thenApply(), thenAccept(), thenRun()
  - Composing tasks: combine the results of multiple futures using methods like thenCombine and thenCompose
  - exception handing: handle(), exceptionally()
  - Run tasks in parallel, run the tasks concurrently and then combine the results
  - Creating a CompletableFuture:
    - Manually: new CompletableFuture()
    - Automatically: supplyAsync() or runAsync()







