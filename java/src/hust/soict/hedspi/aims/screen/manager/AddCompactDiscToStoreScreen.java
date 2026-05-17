package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends JFrame {
    private Store store;

    public AddCompactDiscToStoreScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add CD");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
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

    private JPanel createHeader() {
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

    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(8, 2, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField directorField = new JTextField();
        JTextField lengthField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField costField = new JTextField();
        JTextField idField = new JTextField();
        JTextField artistField = new JTextField();

        center.add(new JLabel("Director"));
        center.add(directorField);
        center.add(new JLabel("Length"));
        center.add(lengthField);
        center.add(new JLabel("Title"));
        center.add(titleField);
        center.add(new JLabel("Category"));
        center.add(categoryField);
        center.add(new JLabel("Cost"));
        center.add(costField);
        center.add(new JLabel("ID"));
        center.add(idField);
        center.add(new JLabel("Artist"));
        center.add(artistField);

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(e -> {
            String director = directorField.getText();
            int length = Integer.parseInt(lengthField.getText());
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            int id = Integer.parseInt(idField.getText());
            String artist = artistField.getText();
            store.addMedia(new CompactDisc(director, length, title, category, cost, id, artist));
            JOptionPane.showMessageDialog(this, "CD added to store.");
            new StoreManagerScreen(store);
            dispose();
        });

        center.add(new JLabel(""));
        center.add(addButton);

        return center;
    }
}
