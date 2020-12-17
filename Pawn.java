/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAI;

/**
 *
 * @author Aidan Larock
 */
public class Pawn extends Piece {
    char type = 'P';

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public char getType() {
        return this.type;
    }


    public double getValue() {
        this.value = 1.0;
        return this.value;
    }

    public void move() {

    }

}
