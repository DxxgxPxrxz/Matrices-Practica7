import java.util.Objects;
import java.util.Scanner;

public class Part1 {

    public static void main(String [] Args) {

        int[][] matrix;

        matrix = new int[4][4];
        Scanner entry = new Scanner(System.in);
        Scanner menu = new Scanner(System.in);

        Operations.defineElements(matrix, entry);
        Operations.showMatrix(4,4,matrix);


        System.out.println("\nchoose an option:\n ");
        System.out.println("a. Sum a line \nb. Sum a column\nc. sum diagonal\nd. sum inverted diagonal\ne. obtain the matrix average");

        String indent = menu.next();

        if (Objects.equals(indent, "a")) {

            Operations.showMatrix(4,4,matrix);
            System.out.println("\nChoose a line:\n ");
            int result, option;
            option = Operations.verifyLength(matrix);
            result = 0;
            for (int i = 0; i<4; i++) {
                result += (matrix[option-1][i]);
            }
            System.out.println("the result of the summation is: "+ result);
        }
        if (Objects.equals(indent, "b")) {
            Operations.showMatrix(4,4,matrix);
            System.out.println("\nChoose a column:\n ");
            int option, result;
            option = Operations.verifyLength(matrix);
            result = 0;
            for (int i = 0; i<4; i++) {
                result += (matrix[i][option-1]);
            }
            System.out.println("the result of the summation is: " + result);
            }
        if (Objects.equals(indent, "c")) {
            Operations.showMatrix(4,4,matrix);
            int result;
            result = 0;
            for (int i = 0; i<4; i++) {
                result += (matrix[i][i]);
            }
            System.out.println("the result of the diagonal is: "+ result);
        }
        if (Objects.equals(indent, "d")) {
            Operations.showMatrix(4,4,matrix);
            int result;
            result = 0;
            for (int i = 0; i<4; i++) {
                result += (matrix[3-i][i]);
            }
            System.out.println("the result of the inverted diagonal is: "+ result);
        }
        if (Objects.equals(indent, "e")) {
            Operations.showMatrix(4,4,matrix);
            int sum, result;
            sum = 0;
            for(int i=0; i< 4;i++)
                for (int j = 0; j < 4; j++) {
                    sum += (matrix[i][j]);
                }
            result = (sum / 4);
            System.out.println("Matrix average:  "+ result);
        }
        }


    }








