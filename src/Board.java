public class Board {

    char[][] game;

    int size;

    boolean statusGame = true;
    boolean status_x = false;
    boolean status_y = false;
    boolean status_z = false;

    public Board() {

        this.size = 3;
        this.game = new char[this.size][this.size];
    }

    void fillGame() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                game[i][j] = '-';
            }
        }
    }
    void Game() {

        while (statusGame){

            Operations.printGame(size, game);
            player1();
            verifyPosLine();
            verifyPosColumn();
            verifyPosDiagonal();
            verifyInverseDiagonal();
            verifyGame();

            if (statusGame){

                Operations.printGame(size, game);
                player2();
                verifyPosLine();
                verifyPosColumn();
                verifyPosDiagonal();
                verifyInverseDiagonal();
                verifyGame();
            }
        }
        Operations.printGame(size, game);
        if (status_x) {
            System.out.println("PLAYER 1 WINS THE GAME");
        } else if (status_y) {
            System.out.println("PLAYER 2 WINS THE GAME");
        } else {
            System.out.println("IT'S A DRAW");
        }
    }


    int verifyPos() {

        boolean condition = false;
        int number = 0;
        while (!condition){
            number = Operations.verifyNumber();
            if (number > size){
                System.out.println("Line or column incorrect, please check the board and enter other valid one: ");
                Operations.printGame(size, game);
            } else {
                condition = true;
            }
        }
        return number;
    }


    void verifyGame() {

        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (game[i][j] != '-'){
                    count++;
                }
            }
        }
        if (count == (size * size)){
            statusGame = false;
        }
    }

    void player1() {

        System.out.println("\nIT IS PLAYER 1's TURN! ");
        System.out.println("Enter line: ");
        int line = verifyPos();
        line --;
        System.out.println("Enter column: ");
        int column = verifyPos();
        column --;
        if (game[line][column] == 'X' || game[line][column] == 'O'){
            System.out.println("Position is already occupied, try some other");
            player1();
        } else{
            game[line][column] = 'X';
        }
    }

    void player2() {

        System.out.println("\nIT IS PLAYER 2's TURN");
        System.out.println("Enter line: ");
        int line = verifyPos();
        line --;
        System.out.println("Enter column: ");
        int column = verifyPos();
        column --;
        if (game[line][column] == 'X' || game[line][column] == 'O'){
            System.out.println("Position is already occupied, try some other");
            player2();
        } else{
            game[line][column] = 'O';
        }
    }

    void verifyPosLine() {

        int count_x = 0;
        int count_o = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if(game[i][j] == 'X'){
                    count_x++;
                }
                if(game[i][j] == 'O'){
                    count_o++;
                }
            }
            if (count_x == 3) {
                status_x = true;
                statusGame = false;
            }
            if (count_o == 3) {
                status_y= true;
                statusGame = false;
            }
            count_x = 0;
            count_o = 0;
        }
    }

    void verifyPosColumn() {

        int count_x = 0;
        int count_o = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if(game[j][i] == 'X'){
                    count_x++;
                }
                if(game[j][i] == 'O'){
                    count_o++;
                }
            }
            if (count_x == 3) {
                status_x = true;
                statusGame = false;
            }
            if (count_o == 3) {
                status_y= true;
                statusGame = false;
            }
            count_x = 0;
            count_o = 0;
        }
    }

    void verifyPosDiagonal() {

        int count_x = 0;
        int count_o = 0;
        for (int i = 0; i < size; i++){
            if(game[i][i] == 'X'){
                count_x++;
            }
            if(game[i][i] == 'O'){
                count_o++;
            }
        }
        if (count_x == 3) {
            status_x = true;
            statusGame = false;
        }
        if (count_o == 3) {
            status_y= true;
            statusGame = false;
        }
    }

    void verifyInverseDiagonal() {

        int count_x = 0;
        int count_o = 0;
        int limit = size - 1;
        for (int i = 0; i < size; i++){
            if(game[limit][i] == 'X'){
                count_x++;
            }
            if(game[limit][i] == 'O'){
                count_o++;
            }
            limit --;
        }
        if (count_x == 3) {
            status_x = true;
            statusGame = false;
        }
        if (count_o == 3) {
            status_y= true;
            statusGame = false;
        }
        if (count_o == 3 && count_x == 3) {
            status_x = false;
            status_y = false;
            status_z = true;
        }
    }
}