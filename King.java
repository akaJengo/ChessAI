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

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public boolean[][] getMoves(int x, int y, Board board) {
        this.moves = new boolean[8][8];

        if ((x + 1 <= 8) && (y - 1 >= 0)) {
            if (board.board[x + 1][y - 1] == null||board.board[x + 1][y - 1].white!=this.white) {
                this.moves[x + 1][y - 1] = true;
            }
        }
        if ((x + 1) <= 8) {
            if (board.board[x + 1][y] == null||board.board[x + 1][y].white!=this.white) {
                this.moves[x + 1][y] = true;
            }
        }
        if ((x + 1 <= 8) && (y + 1 <= 8)) {
            if (board.board[x + 1][y + 1] == null||board.board[x + 1][y + 1].white!=this.white) {
                this.moves[x + 1][y + 1] = true;
            }
        }
        if ((y + 1) <= 8) {
            if (board.board[x][y + 1] == null||board.board[x][y + 1].white!=this.white) {
                this.moves[x][y + 1] = true;
            }
        }
        if ((x - 1 >= 0) && (y + 1 <= 8)) {
            if (board.board[x - 1][y + 1] == null||board.board[x - 1][y + 1].white!=this.white) {
                this.moves[x - 1][y + 1] = true;
            }
        }
        if ((x - 1) >= 0) {
            if (board.board[x - 1][y] == null||board.board[x + 1][y].white!=this.white) {
                this.moves[x - 1][y] = true;
            }
        }
        if ((x - 1 >= 0) && (y - 1 >= 0)) {
            if (board.board[x - 1][y - 1] == null||board.board[x - 1][y - 1].white!=this.white) {
                this.moves[x - 1][y - 1] = true;
            }
        }
        if ((y - 1) >= 0) {
            if (board.board[x][y - 1] == null||board.board[x][y - 1].white!=this.white) {
                this.moves[x][y - 1] = true;
            }
        }
        return this.moves;
    }
}
