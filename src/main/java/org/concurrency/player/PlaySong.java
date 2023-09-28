package org.concurrency.player;

public class PlaySong extends Thread {
    private final Song song;
    private double point;

    public PlaySong(Song song) {
        this.song = song;
    }

    @Override
    public void run() {
        while (point <= song.getDuration()) {
            System.out.println("Playing " + song.getTitle() + " by " + song.getArtist() + " at " + point + " seconds");
            point += 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
