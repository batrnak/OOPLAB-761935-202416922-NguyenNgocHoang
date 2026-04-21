package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    public CompactDisc(String director, int length, String title, String category, float cost, int id) {
        super(director, length, title, category, cost, id);
    }

    public CompactDisc(String director, int length, String title, String category, float cost, int id, String artist) {
        super(director, length, title, category, cost, id);
        this.artist = artist;
    }
    public void addTrack(Track track) {
        tracks.add(track);
    }
    public void removeTrack(Track track) {
        tracks.remove(track);
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
