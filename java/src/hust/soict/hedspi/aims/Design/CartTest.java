package hust.soict.hedspi.aims.Design;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animation",19.95f, "Roger Allers", 87,  "The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Science Fiction", 24.95f, "George Lucas", 87,"Star Wars" );
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", 18.99f, "John Musker", 90, "Aladdin"   );
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);
        cart.print();
        cart.SearchById(2);
        cart.SearchByTitle("Aladdin");
    }
}
