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
public class Knight extends Piece {
    char type = 'K';

    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public char getType() {
        return this.type;
    }


    @Override
    public double getValue() {
        this.value = 3.2;
        return this.value;
    }

    public void move() {

    }
}
