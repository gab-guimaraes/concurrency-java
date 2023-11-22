package org.concurrency.article;

public class GameExample {

    public static void main(String[] args) {

        //Create Threads
        ControllerInputThread t1 = new ControllerInputThread();
        EnemiesThread t2 = new EnemiesThread();

        //Start t1 and t2 "simultaneously"
        t1.start();
        t2.start();
    }
}

class ControllerInputThread extends Thread {
    @Override
    public void run() {
        setName("Controller Input");
        System.out.println(getName());
        try {
            //Waiting 3s
            Thread.sleep(3000);
            System.out.println("Finishing thread " + getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class EnemiesThread extends Thread {
    @Override
    public void run() {
        setName("Enemies");
        System.out.println(getName());
        try {
            //Waiting 2s
            Thread.sleep(2000);
            System.out.println("Finishing thread " + getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}