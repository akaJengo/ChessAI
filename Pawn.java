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
    boolean start; 

    public Pawn(boolean isWhite, boolean start) {
        super(isWhite);
        this.isWhite = isWhite;
        this.start = start;
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
    public boolean[][] getMoves(int x, int y,Board board) {
        this.moves = new boolean[8][8];
        if(start == true){
            this.moves[x][y] = false;
            int z = forewards(isWhite);
            this.moves[x+forewards(isWhite)][y] = true;
            this.moves[x+2*forewards(isWhite)][y] = true;
        }else{
            this.moves[x][y] = false;
            this.moves[x+forewards(isWhite)][y] = true;
        }
        try{
            if(board.board[x+forewards(isWhite)][y+1]!=null){
                this.moves[x+forewards(isWhite)][y+1] = true;
            }
        }catch(Exception e){
            
        }
        try{
            if(board.board[x+forewards(isWhite)][y-1]!=null){
                this.moves[x+forewards(isWhite)][y-1] = true;
            }
        }catch(Exception e){
            
        }
        try{
            if(board.board[x+forewards(isWhite)][y]!=null){
                this.moves[x+forewards(isWhite)][y] = false;
            } 
        }catch(Exception e){
            System.out.println("Protion!!!");
        }

        this.start = false;
        return this.moves;
    }
    
    public int forewards(boolean isWhite){
        int y= 0;
        if(isWhite == true){
            y--;
        }
        if(isWhite == false){
            y++;
        }
        return y;
    }
    
    private void isStart(int x, boolean isWhite){
        this.start = true;
    }

}
