package org.concurrency.music_player;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Song song = new Song("I miss you", "Blink 182", 7.0);
        Song song2 = new Song("Be like that", "3 Doors Down", 5.0);
        Song song3 = new Song("Let me go", "3 Doors Down", 4.0);
        ArrayList<Song> listSongs = new ArrayList<>();
        listSongs.add(song);
        listSongs.add(song2);
        listSongs.add(song3);
        PlayList playList = new PlayList("Rock", listSongs);
        playList.start();
    }
}
