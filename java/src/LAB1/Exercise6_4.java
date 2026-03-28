package LAB1;

import java.util.Scanner;
public class Exercise6_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = 0;
        int year;
        while (true) {
            System.out.print("Month: ");
            String input = sc.nextLine().trim().toLowerCase();
            month = getMonth(input);
            if (month != -1) break;
            System.out.println("Try again: ");
        }
        while (true) {
            System.out.print("Year: ");
            try {
                year = Integer.parseInt(sc.nextLine());
                if (year >= 0) break;
            } catch (Exception e) {}

            System.out.println("Try again:");
        }
        boolean isLeap = isLeapYear(year);
        int days;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = isLeap ? 29 : 28;
                break;
            default:
                days = 0;
        }

        System.out.println("Number of day: " + days);
        sc.close();
    }
    public static int getMonth(String m) {
        switch (m) {
            case "january": case "jan": case "1": return 1;
            case "february": case "feb": case "2": return 2;
            case "march": case "mar": case "3": return 3;
            case "april": case "apr": case "4": return 4;
            case "may": case "5": return 5;
            case "june": case "jun": case "6": return 6;
            case "july": case "jul": case "7": return 7;
            case "august": case "aug": case "8": return 8;
            case "september": case "sep": case "9": return 9;
            case "october": case "oct": case "10": return 10;
            case "november": case "nov": case "11": return 11;
            case "december": case "dec": case "12": return 12;
            default: return -1;
        }
    }

    public static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}
