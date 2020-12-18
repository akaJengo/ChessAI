/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAI.pieces;

import ChessAI.Board;

/**
 * @author        Aidan Larock
 * @author        Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #
 * @assignment    4 - Group Project
 * 
 * @version 3.2
 * 
 * King
 * The king move in chess.
 * King can move 1 block radius around itself
 */
public class King extends Piece {
    char type = 'L';
    double value = 4.0;

    public King(boolean isWhite) {
        super(isWhite);
    }

    // returns L
    @Override
    public char getType() {
        return this.type;
    }

    // returns 4.0
    @Override
    public double getValue() {
        return this.value;
    }

    /* getMoves */
    /**   
    * tests all spots around king, returns all valid spots
    */
    @Override
    public boolean[][] getMoves(int x, int y, Board board) {
        this.moves = new boolean[8][8];
        int up;
        int side;
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                if(y+i>=0&&y+i<8){
                    if(x+i>=0&&x+i<8){
                        up = x+i;
                        side = y+j;
                        if(board.board[x + i][y + j] == null||board.board[x + i][y + j].white!=this.white){
                            this.moves[x + i][y + j] = true;
                        }
                    }
                }
            }
        }
        return this.moves;
    }
}
