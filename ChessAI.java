/**
 * ChessAI
 */
package ChessAI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ChessAI {

    Gui g;
    MyPanel pan;
    char[][] places;
    
    public ChessAI() {
        places = new char[8][8];
        reset();
        g = new Gui();
        g.next(places);

    }
    
    private void reset(){
        char[] spots = {'r','k','b','q','k','b','k','r'};
        for(int i=0;i<places.length;i++){
            places[1][i] = 'P';
        }
        for(int i=0;i<2;i++){
            if(i==0){
                for(int j=0;j<places.length;j++){
                    places[0][j] = Character.toUpperCase(spots[j]);
                }
            }else if(i==1){
                for(int j=0;j<places.length;j++){
                    places[7][j] = spots[j];
                }
            }
        }
        for(int i=0;i<places.length;i++){
            places[6][i] = 'p';
        }
    }

    public static void main(String[] args) {
        ChessAI chess = new ChessAI();
    }
}

class MyPanel extends JPanel {
    Gui board;
    char[][] places;
    MyPanel(Gui board) {     
        //int [] ySpot = {}
        this.board=board;
    }
  
    /**
     * paintComponent: Called by test, dots, gui
     * paints the dots and lines specified by Main
     * Synchronized so other threads don't call paint 
     * when paintComponent is working on 1 solution.
     * 
     * pan.dot[] : Main specified dots to draw
     * pan.lines[] : Main specified lines to draw
     */
    @Override
    public void paintComponent(Graphics g) {
        int[] xSpot = {0,80,160,240,320,400,480,560};
        int[] ySpot = {0,70,140,210,280,350,420,490};
        BufferedImage image;
        
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        int j;
        for(int i=0;i<ySpot.length;i++){
            int temp=0;
            if(i % 2 == 0){
                temp = 1;
            }else{
                temp = 0;
            }
           for(j=temp;j<xSpot.length;j+=2){
                g.fillRect(xSpot[j], ySpot[i], 80, 70);
            }
        }
        for(int y=0;y<board.places.length;y++){
            for(int x=0;x<board.places.length;x++){
                char peice = board.places[x][y];
                image = getPiece(peice);
                 
                g.drawImage(image,xSpot[y]+16,ySpot[x]+12, null);
            }
        }
    }

    private BufferedImage getPiece(char peice) {
        BufferedImage image = null;
        switch (peice) {
                    case 'P':
                        try {
                            image = ImageIO.read(getClass().getResource("images/pawnB.png"));
                        } catch (IOException ex) {}
                        break;
                    case 'K':
                        try {
                            image = ImageIO.read(getClass().getResource("images/kingB.png"));
                        } catch (IOException ex) {}
                        break;
                    case 'B':
                        try {
                            image = ImageIO.read(getClass().getResource("images/bishopB.png"));
                        } catch (IOException ex) {}
                        break;
                    case 'R':
                        try {
                            image = ImageIO.read(getClass().getResource("images/rookB.png"));
                        } catch (IOException ex) {}
                        break;
                    case 'Q':
                        try {
                            image = ImageIO.read(getClass().getResource("images/queenB.png"));
                        } catch (IOException ex) {}
                        break;
                    case 'p':
                        try {
                            image = ImageIO.read(getClass().getResource("images/pawn.png"));
                        } catch (IOException ex) {}
                        break;
                    case 'k':
                        try {
                            image = ImageIO.read(getClass().getResource("images/king.png"));
                        } catch (IOException ex) {}
                        break;
                    case 'b':
                        try {
                            image = ImageIO.read(getClass().getResource("images/bishop.png"));
                        } catch (IOException ex) {}
                        break;
                    case 'r':
                        try {
                            image = ImageIO.read(getClass().getResource("images/rook.png"));
                        } catch (IOException ex) {}
                        break;
                    case 'q':
                        try {
                            image = ImageIO.read(getClass().getResource("images/queen.png"));
                        } catch (IOException ex) {}
                        break;
                } 
        return image;
    }
}