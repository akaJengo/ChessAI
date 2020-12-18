/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAI.pieces;

import ChessAI.Board;
import ChessAI.Rules;

/**
 * Piece
 * 
 * Superclass Piece contains variables and methods that help build the chess
 * engine including: finding all possible moves, getting value, getting type,
 * and getting the color of a specific piece.
 * 
 * @author Aidan Larock
 * @author Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #6402176
 * @assignment 4 - Group Project
 * 
 * @version 2.3
 */
public class Piece {

    Board board;
    public char type;
    public boolean white;
    public double value;
    public boolean start;
    public boolean[][] moves;
    int x;
    int y;

    /**
     * This method sets a boolean to check if it is whites piece.
     * 
     * @param isWhite a boolean asking if the current move is white.
     */
    public Piece(boolean isWhite) {
        this.white = isWhite;
        this.value = getValue();
    }

    /**
     * This get method returns true if it is white to move.
     * 
     * @return color of piece
     */
    public boolean getColor() {
        return this.white;
    }

    /**
     * This method simply returns the type of piece currently on the board.
     * 
     * @return type of piece 'Q' = queen 'P' = pawn 'L' = king etc..
     */
    public char getType() {
        return this.type;
    }

    /**
     * A simple get method to return the value of a piece.
     * 
     * @return value of piece.
     */
    public double getValue() {
        return value;
    }

    /**
     * This method calculates moves for a current type based on its current
     * posistion on the board, and returns a 2D boolean matrix specifying if the
     * current move is possible.
     * 
     * @param x current x posistion.
     * @param y current y posistion.
     * @board the current board state to evaluate from.
     * @return 2D boolean array of possible moves for a piece.
     */
    public boolean[][] getMoves(int x, int y, Board board) {
        return this.moves;
    }
}
