package org.concurrency.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Vault vault = new Vault(random.nextInt(Vault.MAX_PASSWORD));
        List<Thread> threadList = new ArrayList<>();
        threadList.add(new AscendingHackerThread(vault));
        threadList.add(new DescendingHackerThread(vault));
        threadList.add(new PoliceThread());
        threadList.forEach(Thread::start);
    }
}
