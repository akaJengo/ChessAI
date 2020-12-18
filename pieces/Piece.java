/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAI.pieces;

import ChessAI.Board;
import ChessAI.Rules;

/**
 *
 * @author Aidan Larock
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

  public Piece(boolean isWhite) {
    this.white = isWhite;
    this.value = getValue();
  }

  public boolean getColor() {
    return this.white;
  }

  public char getType() {
    return this.type;
  }

  public double getValue() {
    return value;
  }

  public boolean[][] getMoves(int x, int y, Board board) {
      return this.moves;
  }
}