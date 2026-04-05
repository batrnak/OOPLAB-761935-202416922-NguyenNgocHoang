package LAB2;

public class Aims {
    public static void main(String[] args) {

        //add new dvd to cart
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animation", 19.95f,
                "Roger Allers", 87, "The Lion King");
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Science Fiction", 24.95f,
                "George Lucas", 87, "Star Wars");
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladdin", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        //remove dvd2
        anOrder.removeDigitalVideoDisc(dvd2);

        //print total cost
        anOrder.print();
    }
}
