/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAI.pieces;

import ChessAI.Board;

/**
 * Bishop piece of chess can move diagonally.
 * 
 * 
 * @author Aidan Larock
 * @author Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #6402176
 * @assignment 4 - Group Project
 * 
 * @version 1.9
 */
public class Bishop extends Piece {
    char type = 'B';

    /**
     * This method sets a boolean to check if it is whites piece.
     * 
     * @param isWhite a boolean asking if the current move is white.
     */
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    /**
     * This method simply returns the type of piece currently on the board.
     * 
     * @return type of piece Bishop.
     */
    @Override
    public char getType() {
        return this.type;
    }

    /**
     * A simple get method to return the value of a piece.
     * 
     * @return value of piece, Bishop 3.33.
     */
    @Override
    public double getValue() {
        this.value = 3.33;
        return this.value;
    }

    /**
     * This method tests all diagonal spots from rook, stops at first enemy returns
     * 2D array of all moves.
     * 
     * @param x     value to calculate the diagonals from.
     * @param y     value to calculate the diagonals from.
     * @param board the current state of the board to calculate moves from.
     * @return A 2D boolean matrix containing spot where this piece can move to.
     */
    @Override
    public boolean[][] getMoves(int x, int y, Board board) {
        this.moves = new boolean[8][8];
        // Pos diag down
        for (int i = x + 1, j = y + 1; (i < moves.length) && (j < moves.length); i++, j++) {
            if (board.board[i][j] != null) {
                if (board.board[i][j].white != this.white) {
                    this.moves[i][j] = true;
                }
                break;
            } else {
                this.moves[i][j] = true;
            }
        }
        // Pos diag up
        for (int i = x + 1, j = y - 1; (i < moves.length) && (j >= 0); i++, j--) {
            if (board.board[i][j] != null) {
                if (board.board[i][j].white != this.white) {
                    this.moves[i][j] = true;
                }
                break;
            } else {
                this.moves[i][j] = true;
            }
        }
        // neg diag down
        for (int i = x - 1, j = y + 1; (i >= 0) && (j < moves.length); i--, j++) {
            if (board.board[i][j] != null) {
                if (board.board[i][j].white != this.white) {
                    this.moves[i][j] = true;
                }
                break;
            } else {
                this.moves[i][j] = true;
            }
        }
        // neg diag up
        for (int i = x - 1, j = y - 1; (i >= 0) && (j >= 0); i--, j--) {
            if (board.board[i][j] != null) {
                if (board.board[i][j].white != this.white) {
                    this.moves[i][j] = true;
                }
                break;
            } else {
                this.moves[i][j] = true;
            }
        }
        return this.moves;
    }
}