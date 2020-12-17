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
public class Pawn extends Piece {
    char type = 'P';
    boolean isWhite;

    public Pawn(boolean isWhite) {
        super(isWhite);
        this.isWhite = isWhite;
    }

    @Override
    public char getType() {
        return this.type;
    }


    @Override
    public double getValue() {
        this.value = 1.0;
        return this.value;
    }

    @Override
    public void getMoves(int x, int y) {
        boolean start = isStart(x,this.isWhite);
    }
    
    private boolean isStart(int x, boolean isWhite){
        boolean start = false;
        if(x==1&&isWhite==true){
            start = true;
        }
        if(x==6&&isWhite==false){
            start = true;
        }
        return start;
    }

}
