import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
    private final ReentrantLock lock = new ReentrantLock(true);  // Fair lock

    public void performTask() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": Lock acquired.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + ": Lock released.");
        }
    }

    public static void main(String[] args) {
        FairLockExample example = new FairLockExample();

        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(example::performTask, "Thread-" + i);
            t.start();
        }
    }
}
