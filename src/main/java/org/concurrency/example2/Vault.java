package org.concurrency.example2;

public class Vault {
    public static final int MAX_PASSWORD = 400000;
    private final int password;
    public Vault(int password) {
        this.password = password;
    }

    public boolean isCorrectPassword(int guess) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException ignored) {
        }
        return this.password == guess;
    }
}
