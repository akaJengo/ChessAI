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
public class Queen extends Piece {
    char type = 'Q';
    Bishop bishop;
    Rook rook;

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
    public boolean[][] getMoves(int x, int y, Board board) {
        boolean[][] bishopMoves = new boolean[8][8];
        boolean[][] rookMoves = new boolean[8][8];
        this.moves = new boolean[8][8];
        bishop.getMoves(x, y, board);
        rook.getMoves(x, y, board);
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
