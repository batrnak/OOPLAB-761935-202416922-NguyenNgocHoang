package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc {
    private static int nbDigitalVideoDiscs = 0;
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    public static void setNbDigitalVideoDiscs(int nbDigitalVideoDiscs) {
        DigitalVideoDisc.nbDigitalVideoDiscs = nbDigitalVideoDiscs;
    }
    // constructor

    public DigitalVideoDisc(String title) {
        super(null, 0, title, null, 0, 0);
        this.setId(++nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(String category,String title, float cost) {
        super(null, 0, title, category, cost, 0);
        this.setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String director,String category,  String title, float cost) {
        super(director, 0, title, category, cost, 0);
        this.setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String category, float cost, String director, int length, String title) {
        super(director, length, title, category, cost, 0);
        this.setId(++nbDigitalVideoDiscs);
    }

    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }
    public boolean isMatch(int id) {
        return this.getId() == id;
    }
}
