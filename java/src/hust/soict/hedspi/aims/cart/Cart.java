package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private ArrayList<Media> itemsOrdered =new ArrayList<Media>();

    public Cart() {
        this.itemsOrdered = new ArrayList<Media>();
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to the cart");
        } else {
            System.out.println("The cart is full. Cannot add more media.");
        }
    }
    public void removeMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            System.out.println("The media " + media.getTitle() + " is not in the cart");
            return;
        }
        itemsOrdered.remove(media);
        System.out.println("The media " + media.getTitle() + " has been removed from the cart");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }
    public String toString( Media media) {
        StringBuilder sb = new StringBuilder();
        sb.append("Ordered Items:\n");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            sb.append((i + 1) + " " + itemsOrdered.get(i).getTitle() +
                    ": " + itemsOrdered.get(i).getCost() + " $\n");
        }
        sb.append("Total cost: " + totalCost() + " $");
        return sb.toString();
    }

    public void SearchByTitle(String title) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().equals(title)) {
                System.out.println("The disc with title " + title + " is in the cart");
                return;
            }
        }
        System.out.println("The disc with title " + title + " is not in the cart");
    }
    public void SearchById(int id) {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println("The disc with ID " + id + " is in the cart");
                return;
            }
        }
        System.out.println("The disc with ID " + id + " is not in the cart");
    }
    public void print() {
        System.out.println("Ordered Items:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + " " + itemsOrdered.get(i).getTitle() +
                   "- " + itemsOrdered.get(i).getTitle() +
                    "- " + itemsOrdered.get(i).getCategory() +
                    "- " + itemsOrdered.get(i).getCost() + " $");
        }
        System.out.println("Total cost: " + totalCost() + " $");
    }
}
