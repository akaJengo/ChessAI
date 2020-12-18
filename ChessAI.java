/**
 * ChessAI
 */
package ChessAI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ChessAI {

    Gui g;
    MyPanel pan;
    char[][] places;
    Board board;
    Piece piece;
    Pawn pawn;
    
    public ChessAI() {
        places = new char[8][8];
        board = new Board();
        board.addPieces();
        reset();
        g = new Gui();
        g.next(places);
    }
   
    
    private void reset(){
        char[] spots = {'r','k','b','q','l','b','k','r'};
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
    Board b;
    Piece p;
    Gui board;

    int fromX;
    int toX;
    int fromY;
    int toY;
    
    int clicks = 0;

    char[][] places;
    private MouseListener l;
    Point2D mouse = new Point2D.Double(0, 0);
    
    MyPanel(Gui board) {    
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.board=board;
        addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) {
                    clicks++;
                    int x;
                    int y;
                    mouse = me.getPoint();
                    int width = board.panel.getWidth();
                    int height = board.panel.getHeight();
                    int space = width/8;
                    int spaceH = height/8;
                    if(clicks == 1){
                        fromX = xValue(space);
                        fromY = yValue(spaceH);
                        if(board.board.board[fromY][fromX]==null){
                            clicks = 0;
                        }
                        board.paintSpot();
                    }
                    if(clicks == 2){
                        toX = xValue(space);
                        toY = yValue(spaceH);
                        board.submit(board.board,fromY,fromX,toY,toX);
                        clicks = 0;
                    }
                }
        });
    }
    
    private int xValue(int space){
        int x = 0;
        if(mouse.getX()<space){
            x = 0;
        }
        else if(mouse.getX()<2*space){
            x = 1;
        }
        else if(mouse.getX()<3*space){
            x = 2;
        }
        else if(mouse.getX()<4*space){
            x = 3;
        }
        else if(mouse.getX()<5*space){
            x = 4;
        }
        else if(mouse.getX()<6*space){
            x = 5;
        }
        else if(mouse.getX()<7*space){
            x = 6;
        }
        else if(mouse.getX()<8*space){
            x = 7;
        }
        return x;
    }
    
    private int yValue(int space){
        int y = 0;
        if(mouse.getY()<space){
            y = 0;
        }
        else if(mouse.getY()<2*space){
            y = 1;
        }
        else if(mouse.getY()<3*space){
            y = 2;
        }
        else if(mouse.getY()<4*space){
            y = 3;
        }
        else if(mouse.getY()<5*space){
            y = 4;
        }
        else if(mouse.getY()<6*space){
            y = 5;
        }
        else if(mouse.getY()<7*space){
            y = 6;
        }
        else if(mouse.getY()<8*space){
            y = 7;
        }
        return y;
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
        
        int width = board.panel.getWidth();
        int height = board.panel.getHeight();

        int space = width/8;
        int spaceH = height/8;
        
        int[] xSpot = {0,space,space*2,space*3,space*4,space*5,space*6,space*7};
        int[] ySpot = {0,spaceH,spaceH*2,spaceH*3,spaceH*4,spaceH*5,spaceH*6,spaceH*7};

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
                    g.fillRect(xSpot[j], ySpot[i], space, spaceH);
            }
        }
        for(int y=0;y<board.places.length;y++){
            for(int x=0;x<this.board.places.length;x++){
                char peice = this.board.places[x][y];
                image = getPiece(peice);
                g.drawImage(image,xSpot[y]+16,ySpot[x]+16, null);
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
                    case 'L':
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
                    case 'K':
                        try {
                            image = ImageIO.read(getClass().getResource("images/knightB.png"));
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
                            image = ImageIO.read(getClass().getResource("images/knight.png"));
                        } catch (IOException ex) {}
                        break;
                    case 'l':
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