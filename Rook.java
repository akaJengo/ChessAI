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
public class Rook extends Piece {
    char type = 'R';
    boolean[][] moves;

    public Rook(boolean isWhite) {
        super(isWhite);
        moves = new boolean[8][8];
    }

    @Override
    public char getType() {
        return this.type;
    }

    @Override
    public double getValue() {
        this.value = 5.1;
        return this.value;
    }

    @Override
    public boolean[][] getMoves(int x, int y) {

    }
}
