package Proxy;

import java.util.List;

public class Driver {

    public static void main(String[] args) {
       Song s1 = new Song("John L", "Black Midi", "Cavalcade", 314);
       Song s2 = new Song("Marlene Dietrich", "Black Midi", "Cavalcade", 174 );
       Song s3 = new Song("Of Schlagenheim", "Black Midi", "Schlagenheim", 385);
       Song s4 = new Song("Western", "Black Midi", "Schlagenheim", 489 );
       Song s5 = new Song("same", "bruh", "album 1", 31);
       Song s6 = new Song("same", "bruv", "album 10", 29);

       Song[] songs = {s1, s2, s3, s4, s5, s6};

       RealSongService realSongService = new RealSongService();
       for (Song song: songs){
           realSongService.uploadSong(song);
       }

       SongService proxy = new ProxySongService(realSongService);

       //grabs song first time, caches
       System.out.println(proxy.searchById(0));


       System.out.println("Cached");
       //grabs song again, is cached so immediately returns
       System.out.println(proxy.searchById(0));


       //searches songs by title, caches resulting list
        List<Song> songTitleList = proxy.searchByTitle("same");
        for(Song song : songTitleList){
            System.out.println(song);
        }

        //searches for songs by title again, returns cached list
        songTitleList = proxy.searchByTitle("same");
        System.out.println("Cached");
        for(Song song : songTitleList){
            System.out.println(song);
        }

        //searches songs by title, caches resulting list
        List<Song> songAlbumList = proxy.searchByAlbum("Cavalcade");
        for(Song song : songAlbumList){
            System.out.println(song);
        }

        //searches songs by title, returned cached list
        songAlbumList = proxy.searchByAlbum("Cavalcade");
        System.out.println("Cached");
        for(Song song : songAlbumList){
            System.out.println(song);
        }

    }

}
