package org.concurrency.example4_join;

public class Join implements Runnable {
    private final long time;
    private final String name;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Join("t1", 5000));
        Thread t2 = new Thread(new Join("t2", 10000));
        Thread t3 = new Thread(new Join("t3", 1500));
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        t3.start();

        System.out.println("finished main thread");
    }

    public Join(String name, long time) {
        this.time = time;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("running thread " + name);
        try {
            Thread.sleep(time);
            System.out.println("finished thread" + name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
