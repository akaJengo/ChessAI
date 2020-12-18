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
 * @version 2.2
 * 
 * Queen
 * The Queen piece of chess can move like a 
 * rook and bishop combined 
 * @see Rook.java
 * @see Bishop.java
 */
public class Queen extends Piece {
    char type = 'Q';
    Bishop bishop;
    Rook rook;

    public Queen(boolean isWhite) {
        super(isWhite);
    }
    
    // return Q 
    @Override
    public char getType() {
        return this.type;
    }
    
    // return 8.8
    @Override
    public double getValue() {
        this.value = 8.8;
        return this.value;
    }
    
    /* getMove */
    /**   
    * uses bishop and rook to validate moves for queen
    */
    @Override
    public boolean[][] getMoves(int x, int y, Board board) {
        boolean[][] bishopMoves;
        boolean[][] rookMoves;
        bishop = new Bishop(this.white);
        rook = new Rook(this.white);
        this.moves = new boolean[8][8];
        bishopMoves = bishop.getMoves(x, y, board);
        rookMoves = rook.getMoves(x, y, board);
        this.moves = new boolean[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(bishopMoves[i][j]==true||rookMoves[i][j]==true){
                    this.moves[i][j] = true;
                }
            }
        }
        return this.moves; 
    }
}
