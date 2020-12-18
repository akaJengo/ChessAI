/**
 *
 * @author Aidan Larock
 */
package ChessAI;

import ChessAI.pieces.*;

public class Board {
    public Piece[][] board;
    Piece piece;

    public Board() {
        board = new Piece[8][8];
    }

    public void addPieces() {
        Queen queenb = new Queen(false);
        Queen queenw = new Queen(true);
        board[0][3] = queenb;
        board[7][3] = queenw;

        King kingb = new King(false);
        King kingw = new King(true);
        board[0][4] = kingb;
        board[7][4] = kingw;

        board[0][5] = new Bishop(false);
        board[7][5] = new Bishop(true);
        board[0][2] = new Bishop(false);
        board[7][2] = new Bishop(true);

        board[0][6] = new Knight(false);
        board[7][6] = new Knight(true);
        board[0][1] = new Knight(false);
        board[7][1] = new Knight(true);

        board[0][7] = new Rook(false);
        board[7][7] = new Rook(true);
        board[0][0] = new Rook(false);
        board[7][0] = new Rook(true);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(false,true);
            board[6][i] = new Pawn(true,true);
        }
    }
    public void resetBoard(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j] = null;
            }
        }
        addPieces();
    }
}