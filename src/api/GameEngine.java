package api;
import boards.TicTacToeBoard;
import game.Board;
import game.GameResult;
import game.Move;
import game.Player;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GameEngine {

    /*
    * APIs are endpoint that other deveopers can use to interact with your system
    * */

    public Board start() {
        return  new Board();
    }

    public void move(Board board, Player player, Move move) {

    }

    public GameResult isComplete(Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;

            // check all rows
            boolean rowComplete = true;
            String firstCharacter = "-";
            for (int i = 0; i < 3; i++) {
                rowComplete = true;
                // have to learn this syntax sometime
                firstCharacter = board1.getCell[i][0];
                for (int j = 0; j < 3; j ++ ) {
                    if (!board1.getCell[i][j].equals(firstCharacter)) {
                        rowComplete = false;
                        break;
                    }
                }
            }

            if (rowComplete) {
                return new GameResult(true, firstCharacter);
            }

            boolean colComplete = true;
            // check all columns
            for (int i = 0; i < 3; i ++) {
                colComplete = true;
                // have to learn this syntax sometime
                firstCharacter = board1.getCell[0][i];
                for (int j = 0; j < 3; j ++ ) {
                    if (!board1.getCell[j][i].equals(firstCharacter)) {
                        colComplete = false;
                        break;
                    }
                }
            }

            if (colComplete) {
                return new GameResult(true, firstCharacter);
            }

            // check diagonal complete
            boolean diagComplete = true;
            for (int i = 0; i< 3; i++) {
                diagComplete = true;
                firstCharacter = board1.getCell[0][0];

                if (!board1.getCell[i][i].equals(firstCharacter)) {
                    diagComplete = false;
                    break;
                }
            }

            if (diagComplete) {
                return new GameResult(true, firstCharacter);
            }

            // check rever diagonal
            boolean reverseDiaginal = true;
            for (int i = 0; i < 3; i++) {
                firstCharacter = board1.getCell[2][2];
                reverseDiaginal = true;
                if (!board1.getCell[i][2 - i].equals(firstCharacter)) {
                    reverseDiaginal = false;
                    break;
                }
            }

            // this variables are marked red
            // as java doesn't know the execution will have to enter the for loop
            if (reverseDiaginal) {
                return  new GameResult(true, firstCharacter);
            }

            int countOfFilledCells = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    if (board1.getCell[j][i] != null) {
                        countOfFilledCells++;
                    }
                }
            }

            if (countOfFilledCells == 9) {
                return  new GameResult(true, "-");
            } else {
                return  new GameResult(false, "-");
            }
        } else {
            return  new GameResult(true, "-");
        }
    }
}


