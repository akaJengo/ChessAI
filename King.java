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
public class King extends Piece {
    char type = 'L';
    double value = 4.0;

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public char getType() {
        return this.type;
    }

    public double getValue() {
        return this.value;
    }

    public void move() {

    }
}
