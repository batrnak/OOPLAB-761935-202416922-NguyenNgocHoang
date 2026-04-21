package hust.soict.hedspi.LAB1;
import javax.swing.JOptionPane;
public class Example6 {

    public static void main(String[] args) {
        String[] options = {"Giải PT bậc nhất", "Giải hệ 2 PT", "Giải PT bậc hai"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null,"Bạn muốn giải:", "Giải phương trình",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 3 || choice == -1) break; // Thoát nếu chọn "Thoát" hoặc đóng cửa sổ

            switch (choice) {
                case 0: ptBacNhat(); break;
                case 1: HePT(); break;
                case 2: ptBacHai(); break;
            }
        }
        System.exit(0);
    }

    private static void ptBacNhat() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Hệ số a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Hệ số b:"));

        String result;
        if (a == 0) {
            result = (b == 0) ? "PT vô số nghiệm." : "PT vô nghiệm.";
        } else {
            result = "x = " + (-b / a);
        }
        JOptionPane.showMessageDialog(null, result, "Kết quả", JOptionPane.PLAIN_MESSAGE);
    }

    private static void HePT() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2:"));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        String result;
        if (D != 0) {
            result = String.format("Hệ có nghiệm duy nhất:\nx1 = %.2f\nx2 = %.2f", D1/D, D2/D);
        } else {
            result = (D1 == 0 && D2 == 0) ? "Hệ có vô số nghiệm." : "Hệ vô nghiệm.";
        }
        JOptionPane.showMessageDialog(null, result, "Kết quả", JOptionPane.PLAIN_MESSAGE);
    }

    private static void ptBacHai() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập c:"));

        String result;
        if (a == 0) {
            if (b == 0) {
                result = (c == 0) ? "Vô số nghiệm." : "Vô nghiệm.";
            } else {
                result = "x = " + (-c / b);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                result = "PT vô nghiệm thực.";
            } else if (delta == 0) {
                result = "PT có nghiệm kép: x = " + (-b / (2 * a));
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = String.format("PT có 2 nghiệm phân biệt:\nx1 = %.2f\nx2 = %.2f", x1, x2);
            }
        }
        JOptionPane.showMessageDialog(null, result, "Kết quả", JOptionPane.PLAIN_MESSAGE);
    }
}