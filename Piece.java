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
public class Piece {
    public char type;
    public boolean white;
    public double value;
    int x;
    int y;
    
    public Piece(char type, boolean isWhite){
      this.type = type; 
      this.white = isWhite;
      this.value = getValue(type);
    }
    
    private double getValue(char type){
        double val = 0;
        switch (type) {
          case 'P':
            val = 1;
            break;
          case 'K':
            val = 3.2;
            break;
          case 'B':
            val = 3.33;
            break;
          case 'R':
            val = 5.1;
            break;
          case 'Q':
            val = 8.8;
            break;
        }
        return val;
    }
    
    public void getMoves(){
        
    }
}
