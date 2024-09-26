import java.util.concurrent.locks.ReentrantLock;

public class AvoidDeadlockExample {
    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    public void method1() {
        try {
            if (lock1.tryLock()) {
                System.out.println("Thread 1: Holding lock 1...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                if (lock2.tryLock()) {
                    try {
                        System.out.println("Thread 1: Holding lock 1 & 2...");
                    } finally {
                        lock2.unlock();
                    }
                } else {
                    System.out.println("Thread 1: Couldn't acquire lock 2, releasing lock 1...");
                }
            }
        } finally {
            lock1.unlock();
        }
    }

    public void method2() {
        try {
            if (lock2.tryLock()) {
                System.out.println("Thread 2: Holding lock 2...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                if (lock1.tryLock()) {
                    try {
                        System.out.println("Thread 2: Holding lock 2 & 1...");
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println("Thread 2: Couldn't acquire lock 1, releasing lock 2...");
                }
            }
        } finally {
            lock2.unlock();
        }
    }

    public static void main(String[] args) {
        AvoidDeadlockExample example = new AvoidDeadlockExample();

        Thread t1 = new Thread(example::method1);
        Thread t2 = new Thread(example::method2);

        t1.start();
        t2.start();
    }
}
