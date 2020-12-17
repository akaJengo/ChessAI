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
public class Queen extends Piece {
    char type = 'Q';

    public Queen(boolean isWhite) {
        super(isWhite);

    }

    @Override
    public char getType() {
        return this.type;
    }

    @Override
    public double getValue() {
        this.value = 8.8;
        return this.value;
    }

    @Override
    public void getMoves(int x, int y) {

    }

}
