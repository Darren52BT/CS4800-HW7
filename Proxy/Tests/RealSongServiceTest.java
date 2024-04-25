package Proxy.Tests;

import Proxy.RealSongService;
import Proxy.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RealSongServiceTest {

    private RealSongService realSongService;

    @BeforeEach
    public void init() {
        realSongService = new RealSongService();
        realSongService.uploadSong(new Song("song1", "artist", "album1", 1));
        realSongService.uploadSong(new Song("song1", "artist2", "album1", 1));
        realSongService.uploadSong(new Song("song3", "artist", "album1", 1));
        realSongService.uploadSong(new Song("song4", "artist", "album1", 1));
    }
    @Test
    void searchById() {
        Song song = realSongService.searchById(1);

        assertEquals( "song1",song.getTitle());
        assertEquals("artist2",song.getArtist() );
    }

    @Test
    void searchByTitle() {

        List<Song> songList = realSongService.searchByTitle("song1");

        assertEquals(2, songList.size());
        assertEquals("song1", songList.get(0).getTitle());
        assertEquals("song1", songList.get(1).getTitle());

    }

    @Test
    void searchByAlbum() {
        List<Song> songList = realSongService.searchByAlbum("album1");

        assertEquals(4, songList.size());
        assertEquals("album1", songList.get(0).getAlbum());
        assertEquals("album1", songList.get(1).getAlbum());
        assertEquals("album1", songList.get(2).getAlbum());
        assertEquals("album1", songList.get(3).getAlbum());
    }

    @Test
    void uploadSong() {
        realSongService.uploadSong(new Song("random song", "random artist", "random album", 1));

        Song song = realSongService.searchById(4);
        assertEquals("random song", song.getTitle());
    }

    @Test
    void invalidId(){
        Song song = realSongService.searchById(10);
        assertEquals(null, song);
    }
}