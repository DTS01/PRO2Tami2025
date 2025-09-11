package ex3ex4;

import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {
        double[][] m = {
                { 1, 2, 3, 4 },
                { 5, 6.5, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
        };

        System.out.println("Average of the elements in the major diagonal is:"
                + averageMajorDiagonal(m));

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the array: ");
        int rows = input.nextInt();
        int cols = input.nextInt();

        // opretter og udfylder numbers med input fra brugeren
        double[][] numbers = new double[rows][cols];
        System.out.println("Enter the array: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                numbers[i][j] = input.nextDouble();
            }
        }

        int[] location = locateSmallest(numbers);
        System.out.println("The location of the smallest element is at ("
                + location[0] + ", " + location[1] + ")");
    }

    //8.2 i bogen:
    public static double averageMajorDiagonal(double[][] m) {
        int n = m.length;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += m[i][i];
        }
        return sum / n;
    }

    // 8.13: Write the following method that returns the location
    // of the smallest element in a two-dimensional array.
    public static int[] locateSmallest(double[][] a) {
       double smallest = a[0][0];
       int row = 0;
       int col = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][i] < smallest) {
                    smallest = a[i][i];
                    row = i;
                    col = j;
            }
        }
        }
        return new int[] {row, col};
    }
}
