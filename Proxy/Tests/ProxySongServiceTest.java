package Proxy.Tests;

import Proxy.ProxySongService;
import Proxy.RealSongService;
import Proxy.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ProxySongServiceTest {
    private RealSongService realSongService;
    private ProxySongService proxySongService;
    @BeforeEach
    public void init() {
        realSongService = new RealSongService();
        realSongService.uploadSong(new Song("song1", "artist", "album1", 1));
        realSongService.uploadSong(new Song("song1", "artist2", "album1", 1));
        realSongService.uploadSong(new Song("song3", "artist", "album1", 1));
        realSongService.uploadSong(new Song("song4", "artist", "album1", 1));
        proxySongService = new ProxySongService(realSongService);

        //start caching
        proxySongService.searchByAlbum("album1");
        proxySongService.searchByTitle("song1");
        proxySongService.searchById(0);

    }

    @Test
    @Timeout(value=1, unit= TimeUnit.SECONDS)
    void searchById() {
        Song song = proxySongService.searchById(0);
        assertEquals("song1", song.getTitle());
        assertEquals("artist", song.getArtist());
    }

    @Test
    @Timeout(value=1, unit= TimeUnit.SECONDS)
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
}