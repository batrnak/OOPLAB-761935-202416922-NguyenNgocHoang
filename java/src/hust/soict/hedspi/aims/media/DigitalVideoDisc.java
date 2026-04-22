package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    private static int nbDigitalVideoDiscs = 0;
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    private static int nextId() {
        return ++nbDigitalVideoDiscs;
    }
    // constructor

    public DigitalVideoDisc(String title) {
        super(null, 0, title, null, 0, nextId());
    }
    public DigitalVideoDisc(String category,String title, float cost) {
        super(null, 0, title, category, cost, nextId());
    }

    public DigitalVideoDisc(String director,String category,  String title, float cost) {
        super(director, 0, title, category, cost, nextId());
    }

    public DigitalVideoDisc(String category, float cost, String director, int length, String title) {
        super(director, length, title, category, cost, nextId());
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }
    public boolean isMatch(int id) {
        return this.getId() == id;
    }
}
