package hust.soict.hedspi.LAB1;
import javax.swing.JOptionPane;

public class Exercise6_6 {

    public static void main(String[] args) {
        int rows = Integer.parseInt(JOptionPane.showInputDialog("Số hàng của ma trận:"));
        int cols = Integer.parseInt(JOptionPane.showInputDialog("Số cột của ma trận:"));
        double[][] matrixA = new double[rows][cols];
        double[][] matrixB = new double[rows][cols];
        double[][] sumMatrix = new double[rows][cols];

        JOptionPane.showMessageDialog(null, "Nhập ma trận A");
        inputMatrix(matrixA, "A");

        JOptionPane.showMessageDialog(null, "Nhập ma trận B");
        inputMatrix(matrixB, "B");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        displayResult(matrixA, matrixB, sumMatrix, rows, cols);
        System.exit(0);
    }

    private static void inputMatrix(double[][] matrix, String name) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                String val = JOptionPane.showInputDialog("Nhập phần tử " + name + "[" + i + "][" + j + "]:");
                matrix[i][j] = Double.parseDouble(val);
            }
        }
    }

    private static void displayResult(double[][] A, double[][] B, double[][] Sum, int r, int c) {
        StringBuilder sb = new StringBuilder("Kết quả cộng hai ma trận:\n\n");

        sb.append("Ma trận A:\n").append(formatMatrix(A)).append("\n");
        sb.append("Ma trận B:\n").append(formatMatrix(B)).append("\n");
        sb.append("Ma trận (A+B):\n").append(formatMatrix(Sum));

        JOptionPane.showMessageDialog(null, sb.toString(), "Kết quả", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String formatMatrix(double[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (double[] row : matrix) {
            for (double val : row) {
                sb.append(String.format("%f ", val));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}