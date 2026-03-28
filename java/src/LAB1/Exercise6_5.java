package LAB1;
import java.util.Arrays;
import javax.swing.JOptionPane;
public class Exercise6_5 {
        public static void main(String[] args) {
            String sizeStr = JOptionPane.showInputDialog("Số lượng phần tử của mảng:");
            int n = Integer.parseInt(sizeStr);
            double[] myArray = new double[n];
            for (int i = 0; i < n; i++) {
                String val = JOptionPane.showInputDialog("Phần tử thứ " + (i + 1) + ":");
                myArray[i] = Double.parseDouble(val);
            }
            String originalArray = Arrays.toString(myArray);
            Arrays.sort(myArray);
            double sum = 0;
            for (double num : myArray) {
                sum += num;
            }
            double average = sum / n;
            StringBuilder result = new StringBuilder();
            result.append("Mảng đã sắp xếp: ").append(Arrays.toString(myArray)).append("\n");
            result.append("Tổng: ").append(sum).append("\n");
            result.append("Trung bình: ").append(String.format("%f", average));

            JOptionPane.showMessageDialog(null, result.toString(), "Xử lý mảng", JOptionPane.INFORMATION_MESSAGE);

            System.exit(0);
        }

    }
