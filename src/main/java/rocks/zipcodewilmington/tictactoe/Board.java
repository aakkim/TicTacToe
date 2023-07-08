package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {

    Character[][] board; //first[] is rows, second[] is column
    String winner = "";

    public Board(Character[][] matrix) {
        this.board = matrix; //every board needs character array, so we are setting what was passed to board

    }

    public Boolean isInFavorOfX() { //every board is 3x3 so our index will be 0,1,2

        //Check Vertical
        for(int i=0; i<3; i++) {                                      // {X, X, O}
                                                                      // {X, X, X}
                                                                      // {X, O, O}
            for(int j=0; j<3; j++) {

                if(j==2) {
                    return true;
                }
                if(this.board[j][i]=='X' && this.board[j+1][i]=='X') {

                    continue; //just tells the loop to continue
                } else {
                    break; // break if the next row does not equal 'X'
                }
            }
        }

        //Check Horizontal
        for(int i=0; i<3; i++) {                       // {X, X, O}
                                                       // {X, X, X}
                                                       // {X, O, O}

            for(int j=0; j<3; j++) {

                if(j==2) {
                    return true;
                }
                if(this.board[i][j]=='X' && this.board[i][j+1]=='X') {

                    continue; //just tells the loop to continue
                } else {
                    break; // break if the next row does not equal 'X'
                }
            }
        }

        //Check Diagonally
        if((this.board[0][0]=='X' && this.board[1][1]=='X' && this.board[2][2]=='X') ||
                (this.board[2][0]=='X' && this.board[1][1]=='X' && this.board[0][2]=='X')) {
            return true;
        }

        return false;
    }

    public Boolean isInFavorOfO() {
        //Check Vertical
        for(int i=0; i<3; i++) {                                      // {X, X, O}
                                                                      // {X, X, X}
                                                                      // {X, O, O}
            for(int j=0; j<3; j++) {

                if(j==2) {
                    return true;
                }
                if(this.board[j][i]=='O' && this.board[j+1][i]=='O') {

                    continue; //just tells the loop to continue
                } else {
                    break; // break if the next row does not equal 'O'
                }
            }
        }

        //Check Horizontal
        for(int i=0; i<3; i++) {

            for(int j=0; j<3; j++) {

                if(j==2) {
                    return true;
                }
                if(this.board[i][j]=='O' && this.board[i][j+1]=='O') {

                    continue; //just tells the loop to continue
                } else {
                    break; // break if the next row does not equal 'O'
                }
            }
        }

        //Check Diagonally
        if((this.board[0][0]=='O' && this.board[1][1]=='O' && this.board[2][2]=='O') ||
                (this.board[2][0]=='O' && this.board[1][1]=='O' && this.board[0][2]=='O')) {
            return true;
        }

        return false;

    }

    public Boolean isTie() {
        if((isInFavorOfO()==true && isInFavorOfX()==true) || (isInFavorOfO()==false && isInFavorOfX()==false)) {
            return true;
        }
        return false;
    }

    public String getWinner() {
        if(isInFavorOfO()==true && isInFavorOfX()==false) {
            winner += "O";
        } else if(isInFavorOfX()==true && isInFavorOfO()==false) {
            winner += "X";
        }
        return winner;
    }

}
