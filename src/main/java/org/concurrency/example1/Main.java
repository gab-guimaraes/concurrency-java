package org.concurrency.example1;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(() -> {
            System.out.println("we are in thread " + Thread.currentThread().getName() + " before");
        });

        thread.setName("new Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("we are in thread " + Thread.currentThread().getName() + " before");
        thread.start();
        System.out.println("we are in thread " + Thread.currentThread().getName() + " after");
        Thread.sleep(10000);
    }
}