package LAB2;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    public int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBER_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc "+ disc.getTitle() +" has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (qtyOrdered < MAX_NUMBER_ORDERED) {
                itemsOrdered[qtyOrdered] = dvd;
                qtyOrdered++;
                System.out.println("The disc \"" + dvd.getTitle() + "\" has been added");
            } else {
                System.out.println("The cart is almost full" + dvd.getTitle());
                break;
            }
        }
    }
    // use varargs to add multiple DVDs
//   public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
//        for (DigitalVideoDisc dvd : dvds) {
//            if (qtyOrdered < MAX_NUMBER_ORDERED) {
//                itemsOrdered[qtyOrdered] = dvd;
//                qtyOrdered++;
//                System.out.println("The disc \"" + dvd.getTitle() + "\" has been added");
//            } else {
//                System.out.println("The cart is almost full.");
//                break;
//            }
//        }
//    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc "+disc.getTitle()+" has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the cart");
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    public String toString( DigitalVideoDisc[] dvdList) {
        StringBuilder sb = new StringBuilder();
        sb.append("Ordered Items:\n");
        for (int i = 0; i < qtyOrdered; i++) {
            sb.append((i + 1) + " " + itemsOrdered[i].getTitle() +
                    ": " + itemsOrdered[i].getCost() + " $\n");
        }
        sb.append("Total cost: " + totalCost() + " $");
        return sb.toString();
    }

    public void SearchByTitle(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equals(title)) {
                System.out.println("The disc with title " + title + " is in the cart");
                return;
            }
        }
        System.out.println("The disc with title " + title + " is not in the cart");
    }
    public void SearchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("The disc with ID " + id + " is in the cart");
                return;
            }
        }
        System.out.println("The disc with ID " + id + " is not in the cart");
    }
    public void print() {
        System.out.println("Ordered Items:");

        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + " " + itemsOrdered[i].getTitle() +
                   "- " + itemsOrdered[i].getTitle() +
                    "- " + itemsOrdered[i].getCategory() +
                    "- " + itemsOrdered[i].getDirector() +
                    "- " + itemsOrdered[i].getLength() +
                    "- " + itemsOrdered[i].getCost() + " $");
        }
        System.out.println("Total cost: " + totalCost() + " $");
    }
}
