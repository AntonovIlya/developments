package multithreading.concurrentCollections;

import java.util.Random;

public class Specialist implements Runnable {

    private static final int CALL_PROCESSING = 4000 + (new Random().nextInt(2000) - 1000);

    private final CallsQueue callsQueue;

    public Specialist(CallsQueue callsQueue) {
        this.callsQueue = callsQueue;
    }

    @Override
    public void run() {
        while (callsQueue.getBlockingQueue().peek() != null) {
            try {
                String call = callsQueue.getBlockingQueue().poll();
                System.out.println(Thread.currentThread().getName() + ": " + call + " processed!");
                Thread.sleep(CALL_PROCESSING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
