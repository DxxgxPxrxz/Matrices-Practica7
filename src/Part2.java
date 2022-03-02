public class Part2 {

    public static void main(String [] args) {

        System.out.println("Welcome to the magic square generator! ");

        int matrixDimensions;

        do {
            System.out.print("Enter an odd number: ");
            matrixDimensions = Operations.verifyNumber();
        } while (matrixDimensions % 2 == 0 | matrixDimensions == 1);


        int x_ant = 0;
        int y_ant = 0;
        int initial_point = matrixDimensions / 2;

        int [][]magic_square = new int[matrixDimensions][matrixDimensions];

        Operations.setUpBoxes(matrixDimensions, magic_square);

        int x = 0;
        int y = initial_point;

        Operations.FillBoxes(matrixDimensions, magic_square, x, y, x_ant, y_ant);

        Operations.showMagicSquare(matrixDimensions, magic_square);

    }
}
