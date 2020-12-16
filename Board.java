/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package ChessAI;

/**
 *
 * @author Aidan Larock
 */
public class Board {
    Piece[][] board;
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
            board[1][i] = new Pawn(false);
            board[6][i] = new Pawn(true);
        }

    }
}
