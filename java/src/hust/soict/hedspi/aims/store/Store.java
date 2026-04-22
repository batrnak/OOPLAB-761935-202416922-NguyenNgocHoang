package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public Store() {
        this.itemsInStore = new ArrayList<Media>();
    }

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("The media " + media.getTitle() + " is already in the store");
        } else {
            itemsInStore.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to the store");
        }
    }
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media " + media.getTitle() + " has been removed from the store");
        } else {
            System.out.println("The media " + media.getTitle() + " is not in the store");
        }
    }
}