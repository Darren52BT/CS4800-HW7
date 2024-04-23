package Proxy;

public class Song {
    private String title;
    private String artist;
    private String album;
    private int duration;

    public Song(String title, String artist, String album, int duration){
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getAlbum() {
        return album;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return this.title + " by " + this.artist + ", Album: " + this.album + ", Duration: " + this.duration;
    }
}
