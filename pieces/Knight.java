/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAI.pieces;

import ChessAI.Board;
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
    public boolean[][] getMoves(int x, int y, Board board) {
        this.moves = new boolean[8][8];
        
        // U R
        if ((x - 1 >= 0) && (y + 2 < 8)) {
            if (board.board[x - 1][y + 2] == null||board.board[x - 1][y + 2].white!=this.white) {
                this.moves[x - 1][y + 2] = true;
            }
        }
        // R U
        if ((x - 2 >= 0) && (y + 1 < 8)) {
            if (board.board[x-2][y+1] == null||board.board[x-2][y+1].white!=this.white) {
                this.moves[x - 2][y + 1] = true;
            }
        }
        // R D
        if ((x + 2 < 8) && (y + 1 < 8)) {
            if (board.board[x + 2][y + 1] == null||board.board[x + 2][y + 1].white!=this.white) {
                this.moves[x + 2][y + 1] = true;
            }
        }
        // D R
        if ((x + 1 < 8) && (y + 2 < 8)) {
            if (board.board[x + 1][y + 2] == null||board.board[x + 1][y + 2].white!=this.white) {
                this.moves[x + 1][y + 2] = true;
            }
        }
        // D L
        if ((x + 1 < 8 ) && (y - 2 >= 0)) {
            if (board.board[x + 1][y - 2] == null||board.board[x + 1][y - 2].white!=this.white) {
                this.moves[x + 1][y - 2] = true;
            }
        }
        // L D
        if ((x + 2 < 8) && (y - 1 >= 0)) {
            if (board.board[x + 2][y - 1] == null||board.board[x + 2][y - 1].white!=this.white) {
                this.moves[x + 2][y - 1] = true;
            }
        }
        // L U
        if ((x - 2 >= 0) && (y - 1 >= 0)) {
            if (board.board[x - 2][y - 1] == null||board.board[x - 2][y - 1].white!=this.white) {
                this.moves[x - 2][y - 1] = true;
            }
        }
        // U L
        if ((x - 1 >= 0) && (y - 2 >= 0)) {
            if (board.board[x - 1][y - 2] == null||board.board[x - 1][y - 2].white!=this.white) {
                this.moves[x - 1][y - 2] = true;
            }
        }
        return this.moves;
    }
}
