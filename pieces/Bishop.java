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
public class Bishop extends Piece {
    char type = 'B';

    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public char getType() {
        return this.type;
    }

    @Override
    public double getValue() {
        this.value = 3.33;
        return this.value;
    }

    @Override
    public boolean[][] getMoves(int x, int y, Board board) {
        this.moves = new boolean[8][8];
        // Pos diag down
        for (int i = x + 1, j = y + 1; (i < moves.length) && (j < moves.length); i++, j++) {
            if (board.board[i][j] != null) {
                if(board.board[i][j].white!=this.white){
                    this.moves[i][j] = true;
                }
                break;
            } else {
                this.moves[i][j] = true;
            }
        }
        // Pos diag up
        for (int i = x + 1, j = y - 1; (i < moves.length) && (j >= 0); i++, j--) {
            if (board.board[i][j] != null) {
                if(board.board[i][j].white!=this.white){
                    this.moves[i][j] = true;
                }
                break;
            } else {
                this.moves[i][j] = true;
            }
        }
        // neg diag down
        for (int i = x - 1, j = y + 1; (i >= 0) && (j < moves.length); i--, j++) {
            if (board.board[i][j] != null) {
                if(board.board[i][j].white!=this.white){
                    this.moves[i][j] = true;
                }
                break;
            } else {
                this.moves[i][j] = true;
            }
        }
        // neg diag up
        for (int i = x - 1, j = y - 1; (i >= 0) && (j >= 0); i--, j--) {
            if (board.board[i][j] != null) {
                if(board.board[i][j].white!=this.white){
                    this.moves[i][j] = true;
                }
                break;
            } else {
                this.moves[i][j] = true;
            }
        }
        return this.moves;
    }
}
