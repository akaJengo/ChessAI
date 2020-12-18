/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAI.pieces;

import ChessAI.Board;
import ChessAI.Rules;

/**
 * @author        Aidan Larock
 * @author        Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #
 * @assignment    4 - Group Project
 * 
 * @version 2.3
 * 
 * Piece
 * 
 * Superclass Piece contains variables and methods that help build
 * the chess engine including: finding all possible moves, getting value, 
 * getting type, and getting the color of a specific piece
 */
public class Piece {
    
  Rules rule;
  Board board;
  public char type;
  public boolean white;
  public double value;
  public boolean start;
  public boolean[][] moves; 
  int x;
  int y;

    /* Piece */
    /**
    * this.white color of piece object
    * this.value value of piece object
    */
    public Piece(boolean isWhite) {
        this.white = isWhite;
        this.value = getValue();
    }

    /* GetColor */
    /**   
    * a white piece = true
    * returns color of piece
    */
    public boolean getColor() {
        return this.white;
    }

    /* getType */
    /**   
    * return type of piece 
    * 'Q' = queen 'P' = pawn 'L' = king etc..
    */
    public char getType() {
        return this.type;
    }

    /* getValue */
    /**   
    * returns valuation of piece
    */
    public double getValue() {
        return value;
    }

    /* getMoves */
    /**   
    * returns 2D boolean array of all possible moves
    */
    public boolean[][] getMoves(int x, int y, Board board) {
        return this.moves;
    }
}