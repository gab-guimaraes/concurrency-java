package org.concurrency.example5_sync;

public class SyncExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("starting main...");
        Games game = new Games();
        Thread increase = new Thread(new Increase(game));
        Thread decrease = new Thread(new Decrease(game));
        increase.start();
        decrease.start();
        increase.join();
        decrease.join();
        System.out.println(game.getCount());
        System.out.println("finished main");
    }
}

class Increase implements Runnable {
    private final Games game;

    public Increase(Games game) {
        this.game = game;
    }

    @Override
    public void run() {
        System.out.println("running thread increase");
        for (int i = 0; i < 100000; i++) {
            game.increase();
        }
    }
}

class Decrease implements Runnable {
    private final Games game;

    public Decrease(Games game) {
        this.game = game;
    }

    @Override
    public void run() {
        System.out.println("running thread decrease");
        for (int i = 0; i < 100000; i++) {
            game.decrease();
        }
    }
}

class Games {
    private int count;

    public int getCount() {
        return count;
    }

    public Games() {
        this.count = 0;
    }

    public synchronized void increase() {
        count++;
    }

    public synchronized void decrease() {
        count--;
    }
}