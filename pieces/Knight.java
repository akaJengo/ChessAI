/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAI.pieces;

import ChessAI.Board;

/**
 * Knight piece in chess can move in 'L' shapes around itself of length and
 * width: length - 2 and width - 1 or width - 1 and length - 2.
 * 
 * @author Aidan Larock
 * @author Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #6402176
 * @assignment 4 - Group Project
 * 
 * @version 3.5
 */
public class Knight extends Piece {
    char type = 'K';

    /**
     * This method sets a boolean to check if it is whites piece.
     * 
     * @param isWhite a boolean asking if the current move is white.
     */
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    /**
     * This method simply returns the type of piece currently on the board.
     * 
     * @return type of piece Knight.
     */
    @Override
    public char getType() {
        return this.type;
    }

    /**
     * A simple get method to return the value of a piece.
     * 
     * @return value of piece, Knight 3.2.
     */
    @Override
    public double getValue() {
        this.value = 3.2;
        return this.value;
    }

    /**
     * Gets all moves in "L" shape around piece returns possible moves.
     * 
     * @param x position to calculate moves.
     * @param y posistion to calculate moves.
     * @board current board state.
     * @return a 2D boolean matrix containing possible knight moves.
     */
    @Override
    public boolean[][] getMoves(int x, int y, Board board) {
        this.moves = new boolean[8][8];

        // U R
        if ((x - 1 >= 0) && (y + 2 < 8)) {
            if (board.board[x - 1][y + 2] == null || board.board[x - 1][y + 2].white != this.white) {
                this.moves[x - 1][y + 2] = true;
            }
        }
        // R U
        if ((x - 2 >= 0) && (y + 1 < 8)) {
            if (board.board[x - 2][y + 1] == null || board.board[x - 2][y + 1].white != this.white) {
                this.moves[x - 2][y + 1] = true;
            }
        }
        // R D
        if ((x + 2 < 8) && (y + 1 < 8)) {
            if (board.board[x + 2][y + 1] == null || board.board[x + 2][y + 1].white != this.white) {
                this.moves[x + 2][y + 1] = true;
            }
        }
        // D R
        if ((x + 1 < 8) && (y + 2 < 8)) {
            if (board.board[x + 1][y + 2] == null || board.board[x + 1][y + 2].white != this.white) {
                this.moves[x + 1][y + 2] = true;
            }
        }
        // D L
        if ((x + 1 < 8) && (y - 2 >= 0)) {
            if (board.board[x + 1][y - 2] == null || board.board[x + 1][y - 2].white != this.white) {
                this.moves[x + 1][y - 2] = true;
            }
        }
        // L D
        if ((x + 2 < 8) && (y - 1 >= 0)) {
            if (board.board[x + 2][y - 1] == null || board.board[x + 2][y - 1].white != this.white) {
                this.moves[x + 2][y - 1] = true;
            }
        }
        // L U
        if ((x - 2 >= 0) && (y - 1 >= 0)) {
            if (board.board[x - 2][y - 1] == null || board.board[x - 2][y - 1].white != this.white) {
                this.moves[x - 2][y - 1] = true;
            }
        }
        // U L
        if ((x - 1 >= 0) && (y - 2 >= 0)) {
            if (board.board[x - 1][y - 2] == null || board.board[x - 1][y - 2].white != this.white) {
                this.moves[x - 1][y - 2] = true;
            }
        }
        return this.moves;
    }
}
