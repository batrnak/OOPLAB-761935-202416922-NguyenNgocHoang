package hust.soict.hedspi.aims.Design;


public class TestPassingParamater {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
    }
    public static void swap(Object o1, Object o2){
        Object tmp=o1;
        o1=o2;
        o2=tmp;
    }
    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle=dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
// QUESTION:
//After the call of swap(jungleDVD, cinderellaDVD) why does the title of these two objects still remain?
//After the call of changeTitle(jungleDVD, cinderellaDVD.getTitle()) why is the title of the JungleDVD changed?
//ANSWER:
// Java là ngôn ngữ Pass by Value vì nó chỉ truyền bản sao của giá trị biến vào phương thức.
// Trong hàm swap, tiêu đề không đổi vì phương thức chỉ tráo đổi hai bản sao địa chỉ cục bộ, không hề tác động đến các tham chiếu gốc ở hàm main.
// Ngược lại, tiêu đề của jungleDVD thay đổi trong changeTitle,
// vì phương thức đã sử dụng bản sao địa chỉ đó để truy cập và sửa đổi trực tiếp nội dung của đối tượng thật trong bộ nhớ thông qua hàm setter.