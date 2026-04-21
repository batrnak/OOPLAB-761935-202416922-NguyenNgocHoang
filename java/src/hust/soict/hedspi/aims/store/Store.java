package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

import java.util.ArrayList;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();
    public void addDVD(DigitalVideoDisc disc) {
        itemsInStore.add(disc);
        System.out.println("The disc "+ disc.getTitle() +" has been added");
    }
    public void removeDVD(DigitalVideoDisc disc) {
        itemsInStore.remove(disc);
        System.out.println("The disc "+ disc.getTitle() +" has been removed");
    }



}