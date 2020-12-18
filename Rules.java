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
    
    public int forewards(boolean isWhite){
        int y= 0;
        if(isWhite == true){
            y++;
        }
        if(isWhite == false){
            y--;
        }
        return y;
    }
    
    public boolean isValid(char unit){
        boolean valid = false;
        return valid;
    }
}
