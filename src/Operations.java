import java.util.InputMismatchException;
import java.util.Scanner;

public class Operations {

    public static void defineElements(int[][] matrix, Scanner entry) {

        System.out.println("Enter matrix values: ");
        for(int i=0; i< matrix.length;i++)
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Box [" + i + "][" + j + "]:");
                matrix[i][j] = entry.nextInt();
            }
    }

    public static void showMatrix(int x, int y, int[][] matrix) {

        System.out.println("\nThe matrix is: ");
        for(int i=0; i<x; i++) {
            System.out.print((i+1)+". ");
            for(int j=0; j<y; j++) {
                System.out.print("("+matrix[i][j]+")");
            }
            System.out.println();
        }
    }
    static int verifyLength(int[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        boolean condition;
        int number = 0;
        do {
            try {
                number = scanner.nextInt();
                if (number > matrix.length | number < 1){
                    System.out.println("Line or column incorrect, Check the matrix: ");
                    condition = false;
                } else{
                    condition = true;
                }
            } catch (InputMismatchException ime){
                System.out.println("Warning! only numbers are allowed");
                scanner.next();
                condition = false;
            }
        } while (!condition);
        return number;
    }
    static int verifyNumber() {

        Scanner scanner = new Scanner(System.in);
        boolean condition;
        int number = 0;
        do {
            try {
                number = scanner.nextInt();
                condition = true;
            } catch (InputMismatchException ime) {
                System.out.println("You can put just numbers: ");
                scanner.next();
                condition = false;
            }
        } while (!condition);
        return number;

    }

    public static void showMagicSquare(int matrixDimensions, int [][] magic_square) {
        System.out.println("The magic square is: ");
        for (int i = 0; i<matrixDimensions; i++){
            System.out.print((i+1)+". ");
            for (int j=0; j<matrixDimensions; j++) {
                System.out.print("("+magic_square[i][j]+")");
            }
            System.out.println();
        }
    }
    public static void setUpBoxes (int matrixDimensions, int [][] magic_square) {
        for (int x = 0; x<matrixDimensions; x++) {
            for (int y=0; y<matrixDimensions;y++) {
                magic_square[x][y] = 0;
            }
        }
    }
    public static void FillBoxes (int matrixDimensions, int [][] magic_square, int x, int y, int x_ant, int y_ant) {

        int temp = 1;
        while (temp != (matrixDimensions*matrixDimensions)+1) {

            if (magic_square[x][y] == 0) {
                magic_square[x][y] = temp;
            } else {
                x = x_ant +1;
                y = y_ant;
                magic_square[x][y] = temp;
            }
            x_ant = x;
            y_ant = y;

            temp++;
            y++;
            x--;
            if (x<0 && y == matrixDimensions) {
                x = matrixDimensions -1;
                y = 0;
            } else if (x < 0) {
                x += matrixDimensions;
            } else if (y == matrixDimensions) {
                y = 0;
            }
        }
    }
    static void printGame(int size, char[][] matrix) {
        for(int i=0; i<size; i++) {
            System.out.print((i+1)+". ");
            for(int j=0; j<size; j++) {
                System.out.print("("+matrix[i][j]+")");
            }
            System.out.println();
        }
    }
}








