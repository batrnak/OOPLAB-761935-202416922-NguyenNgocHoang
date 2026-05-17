package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            new StoreManagerScreen(store);
            dispose();
        });
        menu.add(viewStore);
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            dispose();
        });
        JMenuItem addCd = new JMenuItem("Add CD");
        addCd.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            dispose();
        });
        JMenuItem addDvd = new JMenuItem("Add DVD");
        addDvd.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            dispose();
        });
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCd);
        smUpdateStore.add(addDvd);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    JComponent createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }
        return new JScrollPane(center);
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.addMedia(new DigitalVideoDisc("Sci-Fi", 19.99f, "Christopher Nolan", 148, "Inception"));
        store.addMedia(new CompactDisc("Director 1", 90, "Starboy", "Pop", 15.0f, 1, "The Weeknd"));
        store.addMedia(new Book(3, "Java Programming", "Education", 45.0f));
        store.addMedia(new DigitalVideoDisc("Action", 12.50f, "John Woo", 118, "Hard Boiled"));
        store.addMedia(new Book(4, "Clean Code", "Software", 40.0f));
        store.addMedia(new CompactDisc("Director 2", 110, "Random Access Memories", "Electronic", 18.0f, 2, "Daft Punk"));
        store.addMedia(new DigitalVideoDisc("Drama", 14.00f, "Denis Villeneuve", 116, "Arrival"));
        store.addMedia(new Book(5, "Design Patterns", "Software", 50.0f));
        store.addMedia(new DigitalVideoDisc("Adventure", 16.00f, "Peter Jackson", 201, "The Hobbit"));
        new StoreManagerScreen(store);

    }
}