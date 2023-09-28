package org.concurrency.player;

import java.util.ArrayList;

public class PlayList extends Thread {
    private String playListName;
    private ArrayList<Song> songList;

    public PlayList (String playListName, ArrayList<Song> songList) {
        this.playListName = playListName;
        this.songList = songList;
    }

    @Override
    public void run() {
        System.out.println("Playing playlist" + playListName);
        for (Song song : songList) {
            PlaySong playSong = new PlaySong(song);
            playSong.start();
            try {
                playSong.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
