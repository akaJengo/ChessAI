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
public class Piece {
  public char type;
  public boolean white;
  public double value;
  int x;
  int y;

  public Piece(boolean isWhite) {
    this.white = isWhite;
    this.value = getValue();
  }

  public char getType() {
    return this.type;
  }

  public double getValue() {
    return value;
  }

  public void getMoves() {

  }
}
