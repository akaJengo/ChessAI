/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAI.pieces;

import ChessAI.Board;

/**
 * Pawn piece in Chess can be moved up 1 space, or 2 if it is the pieces first
 * move attacks to the diagonal, can only move forewards.
 * 
 * @author Aidan Larock
 * @author Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #6402176
 * @assignment 4 - Group Project
 * 
 * @version 3.3
 */
public class Pawn extends Piece {
    char type = 'P';
    boolean isWhite;
    boolean start;

    /**
     * This method sets a boolean to check if it is whites piece.
     * 
     * @param isWhite a boolean asking if the current move is white.
     * @param start   checks if it is the pawns first move.
     */
    public Pawn(boolean isWhite, boolean start) {
        super(isWhite);
        this.isWhite = isWhite;
        this.start = start;
    }

    /**
     * This method simply returns the type of piece currently on the board.
     * 
     * @return type of piece Pawn.
     */
    @Override
    public char getType() {
        return this.type;
    }

    /**
     * A simple get method to return the value of a piece.
     * 
     * @return value of piece, Pawn 1.0.
     */
    @Override
    public double getValue() {
        this.value = 1.0;
        return this.value;
    }

    /**
     * Evaluates possible pawn moves that can occur on the current board.
     * 
     * @param x position to calculate moves.
     * @param y posistion to calculate moves.
     * @board current board state.
     * @return a 2D boolean matrix containing possible pawn moves.
     */
    @Override
    public boolean[][] getMoves(int x, int y, Board board) {
        this.moves = new boolean[8][8];
        if (start == true) {
            if (board.board[x + forewards(isWhite)][y] == null) {
                this.moves[x][y] = false;
                this.moves[x + forewards(isWhite)][y] = true;
                if (board.board[x + 2 * forewards(isWhite)][y] == null) {
                    this.moves[x + 2 * forewards(isWhite)][y] = true;
                }
            }
        } else {
            this.moves[x][y] = false;
            if (board.board[x + forewards(isWhite)][y] == null) {
                this.moves[x + forewards(isWhite)][y] = true;
            }
        }
        try {
            if (board.board[x + forewards(isWhite)][y + 1] != null
                    && board.board[x + forewards(isWhite)][y + 1].white != this.white) {
                this.moves[x + forewards(isWhite)][y + 1] = true;
            }
        } catch (Exception e) {

        }
        try {
            if (board.board[x + forewards(isWhite)][y - 1] != null
                    && board.board[x + forewards(isWhite)][y - 1].white != this.white) {
                this.moves[x + forewards(isWhite)][y - 1] = true;
            }
        } catch (Exception e) {

        }
        try {
            if (board.board[x + forewards(isWhite)][y] != null) {
                this.moves[x + forewards(isWhite)][y] = false;
            }
        } catch (Exception e) {
        }

        this.start = false;
        this.moves[x][y] = false;
        return this.moves;
    }

    /**
     * A helper function to march the pawns forewards.
     * 
     * @param isWhite boolean if it is whites turn.
     * @return the forewards direction of pawn depending on color.
     */
    public int forewards(boolean isWhite) {
        int y = 0;
        if (isWhite == true) {
            y--;
        }
        if (isWhite == false) {
            y++;
        }
        return y;
    }

}