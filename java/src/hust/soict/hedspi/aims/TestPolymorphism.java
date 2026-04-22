package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class TestPolymorphism {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<Media>();

        Media dvd = new DigitalVideoDisc("Sci-Fi", 19.99f, "Christopher Nolan", 148,"Inception") ;
        Media cd = new CompactDisc("Starboy", 60,"The Weeknd" , "Pop", 15.0f, 2, "The Weeknd");
        Media book = new Book(3, "Java Programming", "Education", 25.5f);

        mediaList.add(dvd);
        mediaList.add(cd);
        mediaList.add(book);

        for (Media m : mediaList) {
            System.out.println(m.toString());
        }
    }
}