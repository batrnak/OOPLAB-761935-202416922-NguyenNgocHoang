package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaCompareByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaCompareByCostTitle();
    private final int id;
    private String title;
    private final String category;
    private float cost;
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Media media) {
            return Objects.equals(this.title, media.getTitle());
        }
        return false;
    }


    public static void main(String[] args) {
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
