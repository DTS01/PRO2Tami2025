package ex4;

public class Ex4 {
    static int[][] data = {
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
            {20, 30, 30, 40, 50, 50, 40, 30, 30, 20},
            {30, 40, 50, 50, 50, 50, 50, 50, 40, 30},
    };

    public static void main(String[] args) {
        printTheaterFloor();

        int[] seat = isTicketAvailable(30);
        System.out.println("Første ledige pladser til pris 30: række "
                + seat[0] + ", sæde " + seat[1]);

        boolean success = buyTicket(7, 3);
        System.out.println("Køb af billet: " + success);
        buyTicket(7, 4);
        buyTicket(7, 5);
        printTheaterFloor();
    }


    public static int[] isTicketAvailable(int price) {
        // Fin en ledig plads til en given pris
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] == price) {
                    return new int[]{row + 1, col + 1};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static boolean buyTicket(int rowNo, int setNo) {
        int row = rowNo - 1; // konverter til 0-based
        int col = setNo - 1;
        if (data[row][col] != 0) {
            data[row][col] = 0; //marker solgt
            return true;
        } else {
            return false;
        }
    }

    public static void printTheaterFloor() {
        System.out.println("Teatersalen: ");
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] == 0) {
                    System.out.printf("%4s", "--");
                } else {
                    System.out.printf("%4d", data[row][col]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
