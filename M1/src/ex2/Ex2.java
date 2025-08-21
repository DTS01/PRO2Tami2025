package ex2;

import static ex1.Ex1.print;
import static ex1.Ex1.setValueAt;

public class Ex2 {
    public static void main(String[] args) {
        int[][] numbers = {
                { 0, 4, 3, 9, 6 },
                { 1, 3, 5, 2, 2 },
                { 3, 3, 1, 0, 1 },
                { 0, 0, 9, 7, 1 },
        };

        //2.1: Sæt alle felter til 5
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col] = 5;
            }
        }

        print(numbers);

        //2.2: Indholdet i arrayet skal være 2 i alle lige rækker og 3 i alle ulige rækker.
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                if (row % 2 == 0) {
                    numbers[row][col] = 2; // lige row
                } else {
                    numbers[row][col] = 3; // ulige row
                }
            }
        }

        //2.3: Indholdet i arrayet skal være 2 i alle lige søjler og 3 i alle ulige søjler.
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                if (col % 2 == 0) {
                    numbers[row][col] = 2; // lige col
                } else {
                    numbers[row][col] = 3; // ulige col
                }
            }
        }

        //2.4: Elementerne i arrayet skal være skiftende med 0’er og 1’er som på et skakbræt.
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                if ((row + col) % 2 == 0) {
                    numbers[row][col] = 0; // lige
                } else {
                    numbers[row][col] = 1; // ulige
                }
            }
        }

        /* 2.5: Alle elementer i øverste og nederste række skal være 5,
        alle elementer i første og sidste søjle skal være 5, resten skal være 2 */
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                if (row == 0 || row == numbers.length - 1) {
                    setValueAt(numbers, row, col, 5);
                }
                else if (col == 0 || col == numbers[row].length - 1) {
                setValueAt(numbers, row, col, 5);
                }
                else {
                    setValueAt(numbers, row, col, 2);
                }
            }
        }
        print(numbers);
    }
}
