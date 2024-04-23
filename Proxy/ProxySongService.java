package Proxy;

import java.util.HashMap;
import java.util.List;

public class ProxySongService implements SongService {
    private SongService realSongService;

    private HashMap<Integer, Song> songHashMapbyId;

    private HashMap<String, List<Song>> songHashMapbyTitle;
    private HashMap<String, List<Song>> songHashMapbyAlbum;


    public ProxySongService(SongService songService) {
        this.realSongService = songService;
        this.songHashMapbyId = new HashMap<>();
        this.songHashMapbyTitle = new HashMap<>();
        this.songHashMapbyAlbum = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {


        if (!this.songHashMapbyId.containsKey(songID)) {
            this.songHashMapbyId.put(songID, this.realSongService.searchById(songID));
        }

        return this.songHashMapbyId.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (!this.songHashMapbyTitle.containsKey(title)) {
            this.songHashMapbyTitle.put(title, this.realSongService.searchByTitle(title));
        }

        return this.songHashMapbyTitle.get(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (!this.songHashMapbyAlbum.containsKey(album)) {
            this.songHashMapbyAlbum.put(album, this.realSongService.searchByAlbum(album));
        }

        return this.songHashMapbyAlbum.get(album);
    }
}
