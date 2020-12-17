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
    public boolean[][] getMoves(int x, int y) {
        this.moves = new boolean[8][8];

        // Rook moves
        for (int i = 0; i < moves.length; i++) {
            if (y + i <= 8) {
                this.moves[x][y + i] = true;
            }
            if (Math.abs(y - i) >= 0) {
                this.moves[x][Math.abs(y - i)] = true;
            }
            if (x + i <= 8) {
                this.moves[x + i][y] = true;
            }
            if (Math.abs(x - i) >= 0) {
                this.moves[Math.abs(x - i)][y] = true;
            }
        }
        // Bishop moves
        for (int i = x + 1, j = y + 1; (i <= moves.length) && (j <= moves.length); i++, j++) {
            this.moves[i][j] = true;
        }
        // Pos diag up
        for (int i = x + 1, j = y - 1; (i <= moves.length) && (j >= 0); i++, j--) {
            this.moves[i][j] = true;
        }
        // neg diag down
        for (int i = x - 1, j = y + 1; (i >= 0) && (j <= moves.length); i--, j++) {
            this.moves[i][j] = true;
        }
        // neg diag up
        for (int i = x - 1, j = y - 1; (i >= 0) && (j >= 0); i--, j--) {
            this.moves[i][j] = true;
        }
        return this.moves;
    }
}
