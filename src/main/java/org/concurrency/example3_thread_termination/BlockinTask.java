package org.concurrency.example3_thread_termination;

public class BlockinTask implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockinTask());
        thread.setDaemon(true);
        // deamon thread is a thread that does not prevent the JVM
        // from exiting when the program finishes but the thread is still running
        thread.start();
        thread.interrupt();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            System.out.println("Exiting blocking thread");
        }
    }
}
