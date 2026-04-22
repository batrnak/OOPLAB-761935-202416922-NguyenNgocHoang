package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        this(0, title, category, cost);
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.authors = new ArrayList<String>();
    }

    public Book(int id, String title, String category, float cost, List<String> authors) {
        this(id, title, category, cost);
        this.authors.addAll(authors);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("The author " + authorName + " is already in the list");
        } else {
            authors.add(authorName);
            System.out.println("The author " + authorName + " has been added");
        }
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("The author " + authorName + " has been removed");
        } else {
            System.out.println("The author " + authorName + " is not in the list");
        }
    }
}
