package ex1;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int[][] numbers = {
                { 0, 4, 3, 9, 6 },
                { 1, 3, 5, 2, 2 },
                { 3, 3, 1, 0, 1 },
                { 0, 0, 9, 7, 1 },
        };

        print(numbers);
        System.out.println("The sum of the numbers in row 1 is: " + sumRow(numbers, 1));
        System.out.println("The sum of the numbers in the column 1 is: " + sumColumn(numbers, 1));
        System.out.println("Total sum of numbers in the 2D array: " + sum(numbers));
    }

    //1.2: Add a method that prints the array as a table using for loops
    public static void print(int[][] numbers) {
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                System.out.printf("%5d ", numbers[row][col]);
            }
            System.out.println();
        }
    }

    //1.3: The first method returns the sum of the numbers in the given row
    public static int sumRow(int[][] numbers, int row) {
        int sum = 0;
        for (int col = 0; col < numbers[row].length; col++) {
                sum += numbers[row][col];
        }
        return sum;
    }

    // The second method sums the numbers in the given column.
    public static int sumColumn(int[][] numbers, int col) {
        for (col = 0; col < numbers[0].length; col++) {
            int sum = 0;
            for (int row = 0; row < numbers.length; row++) {
                sum += numbers[row][col];
            }
        }
        return col;
    }

    //1.4: Add a method that returns the sum of all numbers in the array
    public static int sum(int[][] numbers) {
        int total = 0;
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                total += numbers[row][col];
            }
        }
        return total;
    }

    // These two methods gets and sets the value at (row, col) in the array named numbers
    public static int getValueAt(int[][] numbers, int row, int col) {
        return numbers[row][col];
    }

    public static void setValueAt(int[][] numbers, int row, int col, int value) {
        numbers[row][col] = value;
    }
}
