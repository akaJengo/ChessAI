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

    @Override
    public boolean[][] getMoves(int x, int y) {
        this.moves = new boolean[8][8];
        // R U
        if ((x + 3 <= 8) && (y - 1 >= 0)) {
            this.moves[x + 3][y - 1] = true;
        }
        // R D
        if ((x + 3 <= 8) && (y + 1 <= 8)) {
            this.moves[x + 3][y + 1] = true;
        }
        // R D
        if ((x + 1 <= 8) && (y + 3 <= 8)) {
            this.moves[x + 1][y + 3] = true;
        }
        // D R
        if ((x + 1 <= 8) && (y + 3 <= 8)) {
            this.moves[x + 1][y + 3] = true;
        }
        // D L
        if ((x - 1 >= 0) && (y + 3 <= 8)) {
            this.moves[x - 1][y + 3] = true;
        }
        // L D
        if ((x - 3 >= 0) && (y + 1 <= 8)) {
            this.moves[x - 3][y + 1] = true;
        }
        // L U
        if ((x - 3 >= 0) && (y - 1 >= 0)) {
            this.moves[x - 3][y - 1] = true;
        }
        // U L
        if ((x - 1 >= 0) && (y - 3 >= 0)) {
            this.moves[x - 1][y - 3] = true;
        }
        return this.moves;
    }
}
