package Proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RealSongService implements SongService {
    private static int SONG_ID_COUNTER = 0;
    private HashMap<Integer, Song> songHashMapbyId;


    public RealSongService() {
        this.songHashMapbyId = new HashMap<Integer, Song>();
    }

    @Override
    public Song searchById(Integer songID) {
        try {
            System.out.println("waiting");
            Thread.sleep(1000);
        } catch (Exception e) {

        }

        return this.songHashMapbyId.get(songID);

    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            System.out.println("waiting");
            Thread.sleep(1000);
        } catch (Exception e) {

        }

        ArrayList<Song> songResults = new ArrayList<>();
        for (Song song : this.songHashMapbyId.values()) {
            if (song.getTitle().equals(title)) {
                songResults.add(song);
            }
        }

        return songResults;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            System.out.println("waiting");
            Thread.sleep(1000);
        } catch (Exception e) {

        }

        ArrayList<Song> songResults = new ArrayList<>();
        for (Song song : this.songHashMapbyId.values()) {
            if (song.getAlbum().equals(album)) {
                songResults.add(song);
            }
        }

        return songResults;
    }


    public void uploadSong(Song song) {
        this.songHashMapbyId.put(SONG_ID_COUNTER, song);
        SONG_ID_COUNTER++;
    }
}
