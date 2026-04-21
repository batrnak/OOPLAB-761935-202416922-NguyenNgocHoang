package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media {
    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;
    // Getter and setter

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public static void setNbDigitalVideoDiscs(int nbDigitalVideoDiscs) {
        DigitalVideoDisc.nbDigitalVideoDiscs = nbDigitalVideoDiscs;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // constructor

    public DigitalVideoDisc(String title) {
        this.setTitle(title);
        this.setId(++nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(String category,String title, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String director,String category,  String title, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.setCost(cost);
        this.setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String category, float cost, String director, int length, String title) {
        this.setCategory(category);
        this.setCost(cost);
        this.director = director;
        this.length = length;
        this.setTitle(title);
        this.setId(++nbDigitalVideoDiscs);
    }

    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }
    public boolean isMatch(int id) {
        return this.getId() == id;
    }
}
