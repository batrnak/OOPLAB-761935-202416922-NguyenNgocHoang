package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {

        //add new dvd to cart
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animation", 19.95f,
                "Roger Allers", 87, "The Lion King");
        anOrder.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Science Fiction", 24.95f,
                "George Lucas", 87, "Star Wars");
        anOrder.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladdin", 18.99f);
        anOrder.addMedia(dvd3);

        //remove dvd2
        anOrder.removeMedia(dvd2);

        //print total cost
        anOrder.print();
    }
}
