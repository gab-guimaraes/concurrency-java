package org.concurrency.example2;

public abstract class HackerThread extends Thread {
    protected Vault vault;

    public HackerThread(Vault vault) {
        this.vault = vault;
        this.setName(this.getClass().getName());
        this.setPriority(Thread.MAX_PRIORITY);
    }

    @Override
    public void start() {
        System.out.println("Starting thread" + this.getName());
        super.start();
    }

}