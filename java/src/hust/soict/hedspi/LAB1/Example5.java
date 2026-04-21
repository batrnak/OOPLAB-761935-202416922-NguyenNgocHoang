package hust.soict.hedspi.LAB1;

import javax.swing.JOptionPane;

public class Example5 {
    public static void main(String[] args) {
        String strNum1 ;
        String strNum2 ;
        strNum1 = JOptionPane.showInputDialog(null,"Please enter your first number:","Input the first number",JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,"Please enter your second number:","Input the first number",JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        JOptionPane.showMessageDialog(null,"Sum of "+num1+" and "+num2+" is "+(num1+num2),"Result",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Difference of "+num1+" and "+num2+" is "+(num1-num2),"Result",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Product of "+num1+" and "+num2+" is "+(num1*num2),"Result",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Quotient of "+num1+" and "+num2+" is "+(num1/num2),"Result",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}