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
    public Media search(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void printStore() {
        System.out.println("\n********** STORE **********");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i+1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***************************");
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}