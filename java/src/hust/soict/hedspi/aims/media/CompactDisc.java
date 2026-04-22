package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String director, int length, String title, String category, float cost, int id) {
        this(director, length, title, category, cost, id, null);
    }

    public CompactDisc(String director, int length, String title, String category, float cost, int id, String artist) {
        super(director, length, title, category, cost, id);
        this.tracks = new ArrayList<Track>();
        this.artist = artist;
    }
    public void addTrack(Track track) {
        tracks.add(track);
    }
    public void removeTrack(Track track) {
        tracks.remove(track);
    }
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    public String getArtist() {
        return artist;
    }


}
