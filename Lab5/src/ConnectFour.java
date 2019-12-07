import java.lang.*;
import java.util.*;

public class ConnectFour {
    // printBoard method is used to print out the play board, in reversed order, from bottom up, element by element.
    public static void printBoard (char[][] boardArray){
        for (int i = boardArray.length - 1; i >= 0; i--){
            for (int j = 0; j < boardArray[i].length; j++){
                System.out.print(boardArray[i][j] + " ");
            }
            System.out.println();
        }
    }
    // initializeBoard method is used to initialize all element in the paly board to '-'.
    public static void initializeBoard (char[][] boardArray){
        for (int i = 0; i < boardArray.length; i++){
            for (int j = 0; j < boardArray[i].length; j++){
                boardArray[i][j] = '-';
            }
        }
    }
    // insertChip method is used to insert token to player-specified position, if the position is empty to be filled.
    // at the end, the method will return the position of row which the current token was inserted.
    public static int insertChip (char[][] boardArray, int posiCol, char token){
        int currentRow = 0;
        for (int i = 0; i < boardArray.length; i++){
            if (boardArray[i][posiCol] == '-'){
                boardArray[i][posiCol] = token;
                currentRow = i;
                break;
            }
        }
        return currentRow;
    }
    // checkIfWinner method is used to check, after each insert of token, if there is any winner of the game, with
    // four consecutive tokens, in a given row or column from the current insert position on the board.
    public static boolean checkIfWinner (char[][] boardArray, int posiCol, int posiRow, char token){
        int tokenCounter = 0;
        boolean result = false;

        for (int i = posiRow; i >= 0; i--){                             // line 41 - 53:
            if (boardArray[i][posiCol] == token){                       // check the given column, from current position downward...
                tokenCounter++;                                         // if it has four consecutive tokens,
                if (tokenCounter == 4){                                 // if so, turn the game stopper,
                    result = true;                                      // if not, keep playing.
                }
            }
            else {
                break;
            }

        }
        tokenCounter = 0;

        for (int i = posiCol; i >= 0; i--){                             // line 55 - 67:
            if (boardArray[posiRow][i] == token) {                      // check the given row, from current position to the left...
                tokenCounter++;                                         // if it has four consecutive tokens,
                if (tokenCounter == 4){                                 // if so, turn the game stopper,
                    result = true;                                      // if not, keep playing.
                }
            }
            else {
                break;
            }

        }
        tokenCounter = 0;

        for (int i = posiCol; i < boardArray[posiRow].length; i++){     // line 69 - 81:
            if (boardArray[posiRow][i] == token){                       // check the given row, from current position to the right...
                tokenCounter++;                                         // if it has four consecutive tokens,
                if (tokenCounter == 4){                                 // if so, turn the game stopper,
                    result = true;                                      // if not, keep playing.
                }
            }
            else {
                break;
            }

        }
        tokenCounter = 0;

        return result;                                                  // return the result to tell if winner or not.
    }
    public static void main (String[] args){

        Scanner input = new Scanner(System.in);                                                 // utilize scanner.
        boolean winner = true;                                                                  // set game stopper.
        final char[] playerTokens = {'x', 'o'};                                                 // array with two tokens.
        char token = ' ';                                                                       // char to represent one of the two tokens.
        int playerChoice, totalSpace = 0, spaceCounter = 0;                                     // int variables.


        System.out.println("What would you like the height of the board to be?");               // line 88 - 91:
        int numRows = input.nextInt();                                                          // ask for dimension of
        System.out.println("What would you like the length of the board to be?");               // playboard as input.
        int numCols = input.nextInt();

        char[][] board = new char[numRows][numCols];                                            // set 2D array with input dimensions.
        initializeBoard(board);                                                                 // initialize board to all '-'.
        printBoard(board);                                                                      // print out initial board.

        System.out.println("Player 1: " + playerTokens[0]);                                     // player 1 token x.
        System.out.println("Player 2: " + playerTokens[1]);                                     // player 2 token o.

        while (winner) {                                                                        // game stopper.

            for (int player = 0; totalSpace < numRows * numCols; player = 1 - player){          // within all space on playboard,
                                                                                                // switch b/t player 1 and 2.
                if (player == 0){
                    System.out.println("Player 1: Which column would you like to choose?");     // player 1's turn, use token x.
                    token = playerTokens[0];
                }
                else if (player == 1){                                                          // player 2' turn, use token o.
                    System.out.println("Player 2: Which column would you like to choose?");
                    token = playerTokens[1];
                }

                totalSpace++;                                                                   // keep track of empty space on board.
                playerChoice = input.nextInt();                                                 // ask player for position inserting the key.
                int currentRowPosi = insertChip(board, playerChoice, token);                    // insert key at position given by player.
                printBoard(board);                                                              // print out current play board.
                winner = checkIfWinner(board, playerChoice, currentRowPosi, token);             // check if any win, lose or draw.

                if (winner){                                                                    // check to see who wins.
                    if (token == playerTokens[0]){
                        System.out.println("Player 1 won the game!");
                    }
                    else if (token == playerTokens[1]){
                        System.out.println("Player 2 won the game!");
                    }
                    winner = false;                                                             // once there is winner, stop the game.
                    break;
                }
                else if (!winner){                                                              // if no winner, keep playing the game.
                    winner = true;
                }

                for (int i = 0; i < board.length; i++){                                         // line 133 - 145:
                    for (int j = 0; j < board[i].length; j++){                                  // keep track of open space on board,
                        if (board[i][j] != '-'){                                                // if still place left, keep playing.
                            spaceCounter++;                                                     // if all places filled, and not winner,
                        }                                                                       // then it is a draw. reset the space counter.
                    }
                }
                if (spaceCounter == (numCols * numRows)){
                    winner = false;
                    System.out.println("Draw. Nobody wins.");
                    break;
                }
                spaceCounter = 0;
            }
        }
    }
}














