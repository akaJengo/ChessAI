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

    public Rook(boolean isWhite) {
        super(isWhite);

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
    public boolean[][] getMoves(int x, int y, Board board) {
        this.moves = new boolean[8][8];

        for (int i = 0; i < moves.length; i++) {
            if (y + i <= 8) {
                if (board.board[x][y + i] != null) {
                    break;
                } else {
                    this.moves[x][y + i] = true;
                }
            }
        }
        for (int i = 0; i < moves.length; i++) {
            if (Math.abs(y - i) >= 0) {
                if (board.board[x][Math.abs(y - i)] != null) {
                    break;
                } else {
                    this.moves[x][y + i] = true;
                }
            }
        }
        for (int i = 0; i < moves.length; i++) {
            if (x + i <= 8) {
                if (board.board[x + i][y] != null) {
                    break;
                } else {
                    this.moves[x + i][y] = true;
                }
            }
        }
        for (int i = 0; i < moves.length; i++) {
            if (Math.abs(x - i) >= 0) {
                if (board.board[Math.abs(x - i)][y] != null) {
                    break;
                } else {
                    this.moves[Math.abs(x - i)][y] = true;
                }
            }
        }
        return this.moves;
    }
}
