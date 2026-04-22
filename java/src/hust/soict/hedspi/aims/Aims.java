package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    private static int dvdInCart = 0;

    public static void main(String[] args) {
        initSetup();

        int choice;
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }



    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
    public static void viewStore() {
        store.printStore(); // Giả định bạn đã viết hàm này ở bài trước
        int choice;
        while (true) {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;

            switch (choice) {
                case 1: // See details
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media m = store.search(title); // Cần viết hàm search trong Store
                    if (m != null) {
                        System.out.println(m.toString());
                        handleMediaDetails(m);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 2: // Add to cart
                    System.out.print("Enter media title: ");
                    String t = scanner.nextLine();
                    Media mediaToAdd = store.search(t);
                    if (mediaToAdd != null) {
                        cart.addMedia(mediaToAdd);
                        if (mediaToAdd instanceof DigitalVideoDisc) {
                            dvdInCart++;
                            System.out.println("Number of DVDs in current cart: " + dvdInCart);
                        }
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 3: // Play
                    System.out.print("Enter media title: ");
                    String tp = scanner.nextLine();
                    Media mp = store.search(tp);
                    if (mp instanceof Playable) {
                        ((Playable) mp).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 4:
                    viewCart();
                    break;
            }
        }
    }

    public static void handleMediaDetails(Media m) {
        while (true) {
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice == 1) {
                cart.addMedia(m);
                if (m instanceof DigitalVideoDisc) {
                    dvdInCart++;
                    System.out.println("Number of DVDs in current cart: " + dvdInCart);
                }
            }
            if (choice == 2) {
                if (m instanceof Playable) ((Playable) m).play();
                else System.out.println("Cannot play this type.");
            }
        }
    }

    public static void updateStore() {
        System.out.println("1. Add Media | 2. Remove Media");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.println("Choose media type: 1. DVD | 2. CD | 3. Book");
            int type = scanner.nextInt();
            scanner.nextLine();
            if (type == 1) {
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Category: ");
                String category = scanner.nextLine();
                System.out.print("Cost: ");
                float cost = scanner.nextFloat();
                scanner.nextLine();
                System.out.print("Director: ");
                String director = scanner.nextLine();
                System.out.print("Length: ");
                int length = scanner.nextInt();
                scanner.nextLine();
                store.addMedia(new DigitalVideoDisc(category, cost, director, length, title));
            } else if (type == 2) {
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Category: ");
                String category = scanner.nextLine();
                System.out.print("Cost: ");
                float cost = scanner.nextFloat();
                scanner.nextLine();
                System.out.print("Director: ");
                String director = scanner.nextLine();
                System.out.print("Length: ");
                int length = scanner.nextInt();
                scanner.nextLine();
                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Artist: ");
                String artist = scanner.nextLine();
                store.addMedia(new CompactDisc(director, length, title, category, cost, id, artist));
            } else if (type == 3) {
                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Category: ");
                String category = scanner.nextLine();
                System.out.print("Cost: ");
                float cost = scanner.nextFloat();
                scanner.nextLine();
                store.addMedia(new Book(id, title, category, cost));
            } else {
                System.out.println("Invalid media type.");
            }
        } else {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media m = store.search(title);
            if (m != null) store.removeMedia(m);
        }
    }

    public static void viewCart() {
        cart.print();
        while (true) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            switch (choice) {
                case 1: // Filter
                    System.out.println("1. By ID | 2. By Title");
                    int f = scanner.nextInt();
                    scanner.nextLine();
                    if (f == 1) {
                        System.out.print("Enter id: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        cart.SearchById(id);
                    } else if (f == 2) {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        cart.SearchByTitle(title);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 2: // Sort
                    System.out.println("1. By Title | 2. By Cost");
                    int s = scanner.nextInt();
                    scanner.nextLine();
                    if (s == 1) cart.sortByTitle(); else cart.sortByCost();
                    cart.print();
                    break;
                case 3: // Remove media from cart
                    System.out.print("Enter media title to remove: ");
                    String removeTitle = scanner.nextLine();
                    Media rm = store.search(removeTitle);
                    if (rm != null) {
                        cart.removeMedia(rm);
                        if (rm instanceof DigitalVideoDisc && dvdInCart > 0) {
                            dvdInCart--;
                        }
                    }
                    else System.out.println("Media not found!");
                    break;
                case 4: // Play media in cart
                    System.out.print("Enter media title to play: ");
                    String playTitle = scanner.nextLine();
                    Media playMedia = store.search(playTitle);
                    if (playMedia instanceof Playable) ((Playable) playMedia).play();
                    else System.out.println("Cannot play this type.");
                    break;
                case 5: // Place order
                    System.out.println("Order created successfully!");
                    cart = new Cart(); // Empty cart
                    dvdInCart = 0;
                    return;
            }
        }
    }

    public static void initSetup() {
        store.addMedia(new DigitalVideoDisc("Sci-Fi", 19.99f, "Christopher Nolan", 148,"Inception"));
        store.addMedia(new CompactDisc("Starboy", 60,"The Weeknd" , "Pop", 15.0f, 2, "The Weeknd"));
        store.addMedia(new Book(3, "Java Programming", "Education", 45.0f));
    }
}
