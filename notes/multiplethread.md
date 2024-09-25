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