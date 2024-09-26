import java.util.concurrent.locks.ReentrantLock;

public class InterruptibleLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void performTask() {
        try {
            System.out.println(Thread.currentThread().getName() + ": Trying to acquire the lock...");
            lock.lockInterruptibly();  // Acquires the lock but can be interrupted
            System.out.println(Thread.currentThread().getName() + ": Lock acquired.");
            Thread.sleep(3000);  // Simulate work
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": Interrupted while waiting for the lock.");
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + ": Lock released.");
            }
        }
    }

    public static void main(String[] args) {
        InterruptibleLockExample example = new InterruptibleLockExample();

        Thread t1 = new Thread(example::performTask, "Thread-1");
        Thread t2 = new Thread(example::performTask, "Thread-2");

        t1.start();
        t2.start();

        // Interrupt Thread-2 while it's waiting for the lock
        try {
            Thread.sleep(1000);
            t2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
