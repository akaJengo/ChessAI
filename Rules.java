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
public class Rules {
    
    public boolean pawn(boolean first,int x, int y, int x2, int y2){
        boolean valid = false;
        if(x==x2&&y==y2+1){
            return valid == true;
        }
        if(first=true&&x==x2&&y==y2+2){
            return valid == true;
        }
        return valid;
    }
    
    public boolean isValid(char unit){
        boolean valid = false;
        return valid;
    }
}
