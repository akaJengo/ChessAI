/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 *
 * @author Aidan Larock
 */
public class Gui extends JFrame {
    MyPanel panel;
    Rules rules;
    Board board;
    
    char [][]places;
    
    private JButton btnReset;
    private JButton btnStart;
    private JButton btnStop;
    
    private JLabel S1;
    private JLabel S2;
    private JLabel S3;
    private JLabel S4;
    private JLabel S5;
    private JLabel S6;
    private JLabel S7;
    private JLabel S8;
    private JLabel SA;
    private JLabel SB;
    private JLabel SC;
    private JLabel SD;
    private JLabel SE;
    private JLabel SF;
    private JLabel SG;
    private JLabel SH;
    
    private JPanel pnlMain;
    private JPanel pnlBoard;


    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    
    private JPanel pnlLetters;
    private JPanel pnlSide;
    
    private JPanel pnlButtons;
    private JPanel pnlTop;
    private JTextField txtFrom;
    private JTextField txtTo;


    public Gui() {
        build();
        board = new Board();
        board.addPieces();
    }

    // <editor-fold defaultstate="collapsed" desc="GUI CODE">              
    private void build() {

        pnlMain = new JPanel();
        pnlLetters = new JPanel();
        pnlBoard = new JPanel();
        
        SA = new JLabel();
        SB = new JLabel();
        SC = new JLabel();
        SD = new JLabel();
        SE = new JLabel();
        SF = new JLabel();
        SG = new JLabel();
        SH = new JLabel();
        
        pnlSide = new JPanel();
        
        S1 = new JLabel();
        S2 = new JLabel();
        S3 = new JLabel();
        S4 = new JLabel();
        S5 = new JLabel();
        S6 = new JLabel();
        S7 = new JLabel();
        S8 = new JLabel();

        pnlTop = new JPanel();
        pnlButtons = new JPanel();
        btnStart = new JButton();
        btnStop = new JButton();
        btnReset = new JButton();
        jSeparator2 = new JSeparator();
        txtFrom = new JTextField();
        Action action = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(txtFrom.getText().equals("")||txtTo.getText().equals("")){
                    txtFrom.setText("");
                    txtTo.setText("");
                }else{
                    submit();
                }
            }
        };
        txtFrom.addActionListener( action );
        txtTo = new JTextField();
        txtTo.addActionListener( action );
        jSeparator3 = new JSeparator();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBackground(new Color(204, 204, 204));

        pnlBoard.setBackground(new Color(255, 255, 255));

        GroupLayout pnlBoardLayout = new GroupLayout(pnlBoard);
        pnlBoard.setLayout(new GridLayout(8, 8));
        pnlBoardLayout.setHorizontalGroup(
            pnlBoardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        pnlBoardLayout.setVerticalGroup(
            pnlBoardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );


        pnlSide.setLayout(new GridLayout(8,1));
        pnlSide.setBackground(new Color(255, 255, 255));

        S1.setText("8");
        pnlSide.add(S1);

        S2.setText("7");
        pnlSide.add(S2);

        S3.setText("6");
        pnlSide.add(S3);

        S4.setText("5");
        pnlSide.add(S4);

        S5.setText("4");
        pnlSide.add(S5);

        S6.setText("3");
        pnlSide.add(S6);

        S7.setText("2");
        pnlSide.add(S7);

        S8.setText("1");
        pnlSide.add(S8);
        
        pnlLetters.setLayout(new GridLayout(1,8));

        SA.setBackground(new Color(255, 255, 255));
        SA.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        SA.setHorizontalAlignment(CENTER);
        SA.setText("A");
        pnlLetters.add(SA);

        SB.setBackground(new Color(255, 255, 255));
        SB.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        SB.setHorizontalAlignment(CENTER);
        SB.setText("B");
        pnlLetters.add(SB);

        SC.setBackground(new Color(255, 255, 255));
        SC.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        SC.setHorizontalAlignment(CENTER);
        SC.setText("C");
        pnlLetters.add(SC);

        SD.setBackground(new Color(255, 255, 255));
        SD.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        SD.setHorizontalAlignment(CENTER);
        SD.setText("D");
        pnlLetters.add(SD);

        SE.setBackground(new Color(255, 255, 255));
        SE.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        SE.setHorizontalAlignment(CENTER);
        SE.setText("E");
        pnlLetters.add(SE);

        SF.setBackground(new Color(255, 255, 255));
        SF.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        SF.setHorizontalAlignment(CENTER);
        SF.setText("F");
        pnlLetters.add(SF);

        SG.setBackground(new Color(255, 255, 255));
        SG.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        SG.setHorizontalAlignment(CENTER);
        SG.setText("G");
        pnlLetters.add(SG);

        SH.setBackground(new Color(255, 255, 255));
        SH.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        SH.setHorizontalAlignment(CENTER);
        SH.setText("H");
        pnlLetters.add(SH);


        GroupLayout pnlMainLayout = new GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)

                    .addComponent(pnlLetters, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                    .addComponent(pnlBoard, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSide, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()

                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlBoard, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSide, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)

                .addComponent(pnlLetters, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlTop.setBackground(new Color(255, 255, 255));
        pnlMain.setBackground(new Color(255, 255, 255));
        pnlSide.setBackground(new Color(255, 255, 255));
        pnlLetters.setBackground(new Color(255, 255, 255));
        pnlButtons.setBackground(new Color(255, 255, 255));
        pnlBoard.setBackground(new Color(240, 240, 240));
        pnlBoard.setLayout(new GridLayout());
        
        panel=new MyPanel(this);
        pnlBoard.add(panel);
        
        btnStart.setText("Start");

        btnStop.setText("Stop");

        btnReset.setText("Reset");

        GroupLayout pnlButtonsLayout = new GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(pnlButtonsLayout.createSequentialGroup()
                        .addComponent(btnStart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(btnStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStart, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE))
        );

        txtFrom.setHorizontalAlignment(JTextField.CENTER);
        txtFrom.setText("");
        txtFrom.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        txtTo.setHorizontalAlignment(JTextField.CENTER);
        txtTo.setText("");
        txtTo.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));


        jSeparator3.setOrientation(SwingConstants.VERTICAL);

        GroupLayout pnlTopLayout = new GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pnlButtons, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFrom)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTo)
                .addContainerGap())
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopLayout.createSequentialGroup()
                .addComponent(pnlButtons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTo)
                    .addComponent(txtFrom, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pnlTop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setTitle("Chess Game");
        pack();
        setSize(694, 754);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/icon.png")));
        setVisible(true);
        
    }// </editor-fold>   
    
    public char[][] next(char[][]places){
        this.places = places;
        panel.repaint();
        return this.places;
    }
    
    private void submit() {
        String from = txtFrom.getText();
        char letter = from.charAt(0);
        int numFrom = -1*(Character.getNumericValue(from.charAt(1))-8);
        int valueFrom = getValue(letter);
        String to = txtTo.getText();
        letter = to.charAt(0);
        int num = -1*(Character.getNumericValue(to.charAt(1))-8);
        int value = getValue(letter);
        txtTo.setText("");
        txtFrom.setText("");
        this.places[num][value] = this.places [numFrom][valueFrom];
        this.places[numFrom][valueFrom] = ' ';
        updateSpots(board,numFrom,valueFrom,num,value);
        next(this.places);
    } 
    
    public void updateSpots(Board board, int fromx, int fromy, int tox, int toy){
        board.board[tox][toy] = board.board[fromx][fromy];
        board.board[fromx][fromy]=null;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                try{
                   System.out.print(board.board[i][j].getType()+" "); 
                }catch(Exception e){
                    System.out.print("  ");
                }
                
            }
            System.out.println("");
        }
    }
    
    public Board getBoard(){
        return this.board;
    }
    
    private int getValue(char letter){
        int val = 8;
        switch (letter) {
                    case 'a':
                        val = 0;
                        break;
                    case 'b':
                        val = 1;
                        break;
                    case 'c':
                        val = 2;
                        break;
                    case 'd':
                        val = 3;
                        break;
                    case 'e':
                        val = 4;
                        break;
                    case 'f':
                        val = 5;
                        break;
                    case 'g':
                        val = 6;
                        break;
                    case 'h':
                        val = 7;
                        break;
                } 
        return val;
    }

              
}
