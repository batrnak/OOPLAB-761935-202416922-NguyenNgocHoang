package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
            Store store =new Store();
            DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animation",19.95f, "Roger Allers", 87,  "The Lion King");
            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Science Fiction", 24.95f, "George Lucas", 87,"Star Wars" );
            DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", 18.99f, "John Musker", 90, "Aladdin"   );
            store.addMedia(dvd1);
            store.addMedia(dvd2);
            store.addMedia(dvd3);
            store.addMedia(dvd2);
    }
}
