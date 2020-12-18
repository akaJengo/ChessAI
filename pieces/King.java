/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAI.pieces;

import ChessAI.Board;

/**
 * The king move in chess. King can move 1 block radius around itself.
 * 
 * @author Aidan Larock
 * @author Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #6402176
 * @assignment 4 - Group Project
 * 
 * @version 3.2
 */
public class King extends Piece {
    char type = 'L';
    double value = 4.0;

    /**
     * This method sets a boolean to check if it is whites piece.
     * 
     * @param isWhite a boolean asking if the current move is white.
     */
    public King(boolean isWhite) {
        super(isWhite);
    }

    /**
     * This method simply returns the type of piece currently on the board.
     * 
     * @return type of piece King.
     */
    @Override
    public char getType() {
        return this.type;
    }

    /**
     * A simple get method to return the value of a piece.
     * 
     * @return value of piece, King 4.0.
     */
    @Override
    public double getValue() {
        return this.value;
    }

    /**
     * Gets possible moves for king from current posistion x and y, on the board.
     * 
     * @param x position to calculate moves.
     * @param y posistion to calculate moves.
     * @board current board state.
     * @return a 2D boolean matrix containing possible kings moves.
     */
    @Override
    public boolean[][] getMoves(int x, int y, Board board) {
        this.moves = new boolean[8][8];
        int up;
        int side;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (y + i >= 0 && y + i < 8) {
                    if (x + i >= 0 && x + i < 8) {
                        up = x + i;
                        side = y + j;
                        if (board.board[x + i][y + j] == null || board.board[x + i][y + j].white != this.white) {
                            this.moves[x + i][y + j] = true;
                        }
                    }
                }
            }
        }
        return this.moves;
    }
}
