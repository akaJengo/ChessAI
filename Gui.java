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
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import ChessAI.pieces.*;

/**
 * This class creates the graphical user interface of the chess board. This is
 * the input and output from the user to the board in use. Furthermore it uses
 * an alpha-beta searching algorithm to find blacks best move, and play it.
 * 
 * @author Aidan Larock
 * @author Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #6402176
 * @assignment 4 - Group Project
 * 
 * @version 3.3
 * @see AlphaBeta
 */
public class Gui extends JFrame {

    MyPanel panel;
    Board board;
    Piece piece;
    ChessAI main;
    int depth;
    boolean start = false;
    char[][] places;
    // <editor-fold defaultstate="collapsed" desc="gui variables">
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
    // </editor-fold>

    /**
     * Constructor to the main class.
     */
    public Gui() {
        depth = 0;
        build();
        board = new Board();
        board.addPieces();
    }

    // <editor-fold defaultstate="collapsed" desc="GUI CODE">
    /**
     * This method builds the input buttons from the user on the GUI.
     */
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
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtFrom.getText().equals("") || txtTo.getText().equals("")) {
                    txtFrom.setText("");
                    txtTo.setText("");
                } else {
                    // submit();
                }
            }
        };
        btnStart.addActionListener((ActionEvent e) -> {
            start();
        });
        btnStop.addActionListener((ActionEvent e) -> {
            start();
        });
        btnReset.addActionListener((ActionEvent e) -> {
            reset();
        });

        txtFrom.addActionListener(action);
        txtTo = new JTextField();
        txtTo.addActionListener(action);
        jSeparator3 = new JSeparator();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBackground(new Color(204, 204, 204));

        pnlBoard.setBackground(new Color(255, 255, 255));

        GroupLayout pnlBoardLayout = new GroupLayout(pnlBoard);
        pnlBoard.setLayout(new GridLayout(8, 8));
        pnlBoardLayout.setHorizontalGroup(
                pnlBoardLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 808, Short.MAX_VALUE));
        pnlBoardLayout.setVerticalGroup(
                pnlBoardLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 385, Short.MAX_VALUE));

        pnlSide.setLayout(new GridLayout(8, 1));
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

        pnlLetters.setLayout(new GridLayout(1, 8));

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
        pnlMainLayout.setHorizontalGroup(pnlMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pnlMainLayout.createSequentialGroup().addContainerGap()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)

                                .addComponent(pnlLetters, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)

                                .addComponent(pnlBoard, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(pnlSide,
                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        pnlMainLayout.setVerticalGroup(pnlMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pnlMainLayout.createSequentialGroup().addContainerGap()

                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(pnlBoard, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(pnlSide, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)

                        .addComponent(pnlLetters, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));

        pnlTop.setBackground(new Color(255, 255, 255));
        pnlMain.setBackground(new Color(255, 255, 255));
        pnlSide.setBackground(new Color(255, 255, 255));
        pnlLetters.setBackground(new Color(255, 255, 255));
        pnlButtons.setBackground(new Color(255, 255, 255));
        pnlBoard.setBackground(new Color(240, 240, 240));
        pnlBoard.setLayout(new GridLayout());

        panel = new MyPanel(this);
        pnlBoard.add(panel);

        btnStart.setText("Start");

        btnStop.setText("Stop");

        btnReset.setText("Reset");

        GroupLayout pnlButtonsLayout = new GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(pnlButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING,
                        pnlButtonsLayout.createSequentialGroup().addContainerGap()
                                .addGroup(pnlButtonsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator2)
                                        .addGroup(pnlButtonsLayout.createSequentialGroup()
                                                .addComponent(btnStart, GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnStop, GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnReset, GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap()));
        pnlButtonsLayout.setVerticalGroup(pnlButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(pnlButtonsLayout.createSequentialGroup().addContainerGap()
                        .addGroup(pnlButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addComponent(btnStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(btnStart, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)));

        txtFrom.setHorizontalAlignment(JTextField.CENTER);
        txtFrom.setText("");
        txtFrom.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        txtTo.setHorizontalAlignment(JTextField.CENTER);
        txtTo.setText("");
        txtTo.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        txtFrom.setVisible(false);
        txtTo.setVisible(false);

        jSeparator3.setOrientation(SwingConstants.VERTICAL);

        GroupLayout pnlTopLayout = new GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(pnlTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(pnlButtons, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTopLayout.createSequentialGroup().addContainerGap().addComponent(txtFrom)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtTo)
                        .addContainerGap()));
        pnlTopLayout
                .setVerticalGroup(pnlTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlTopLayout.createSequentialGroup()
                                .addComponent(pnlButtons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTo)
                                        .addComponent(txtFrom, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addComponent(jSeparator3))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(pnlTop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        setTitle("Chess Game");
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        btnReset.setEnabled(false);
        pack();
        setSize(694, 754);
        txtTo.setEnabled(false);
        txtFrom.setEnabled(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/icon.png")));
        setVisible(true);

    }// </editor-fold>

    /**
     * This method places the respective images of the pieces onto thr board.
     * 
     * @param places character sequence containing the pieces.
     * @return character sequence of the pieces.
     */
    public char[][] next(char[][] places) {
        this.places = places;
        panel.repaint();
        return this.places;
    }

    /**
     * 
     * @param board
     * @param numFrom
     * @param valueFrom
     * @param num
     * @param value
     */  
    public void submit(Board board,int numFrom, int valueFrom, int num,int value) {
        boolean playerMove = updateSpots(board,numFrom,valueFrom,num,value);
        if(playerMove){
            if(start == true){
                AlphaBeta AI = new AlphaBeta(); 
                Board ai = AI.getBest(board, depth);
                updateAI(board, ai);
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        this.places[i][j] = ' ';
                    }
                }
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        try{
                        char c = ai.board[i][j].getType();
                        boolean col = ai.board[i][j].white;
                        if(col==true){
                           c = Character.toLowerCase(c); 
                        }
                            this.places[i][j] = c;
                        }catch(Exception e){
                            this.places[i][j] = ' ';
                        }
                    }
                }
                next(this.places);
            }else{
                next(this.places);
            }
        }      
    } 
    // </editor-fold> 
    
    public void updateAI(Board board, Board ai){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board.board[i][j] = ai.board[i][j];
            }
        }
    }
    
    
    /**
     * This method updates the spots from an original posistion to a new posistion.
     * 
     * @param board the current board state to update.
     * @param fromx the original x posistion.
     * @param fromy the original y posistion.
     * @param tox   the new x posistion.
     * @param toy   the new y posistion.
     */
    
    public boolean updateSpots(Board board, int fromx, int fromy, int tox, int toy){
        boolean canMove = getAllMoves(board, fromx,fromy,tox,toy);
        if(canMove == true){
            board.board[tox][toy] = board.board[fromx][fromy];
            board.board[fromx][fromy]=null;
            char type = board.board[tox][toy].getType();
            if(type=='P'){
                if(tox==0){
                    Object[] possibilities = {"Queen", "Bishop", "Rook","Knight"};
                    String promoted = (String)JOptionPane.showInputDialog(null,"Promote Pawn","Customized Dialog",JOptionPane.PLAIN_MESSAGE,null,possibilities,"Queen");
                    if(promoted.equals("Queen")){
                        this.places[fromx][fromy] = 'q';
                        board.board[tox][toy] = new Queen(true);
                    }
                    if(promoted.equals("Bishop")){
                        this.places[fromx][fromy] = 'b';
                        board.board[tox][toy] = new Bishop(true);
                    }
                    if(promoted.equals("Rook")){
                        this.places[fromx][fromy] = 'r';
                        board.board[tox][toy] = new Rook(true);
                    }
                    if(promoted.equals("Knight")){
                        this.places[fromx][fromy] = 'k';
                        board.board[tox][toy] = new Knight(true);
                    }
                }
            }
            this.places[tox][toy] = this.places [fromx][fromy];
            this.places[fromx][fromy] = ' ';
            txtTo.setText("");
            txtFrom.setText("");
        }else{
            txtTo.setText("Move");
            txtFrom.setText("Invalid");
        }
        return canMove;
    }
    
    /**
     * Checks if a move is possible to do.
     * 
     * @param board the current board state to evaluate.
     * @param fromx the original x posistion.
     * @param fromy the original y posistion.
     * @param tox   the new x posistion.
     * @param toy   the new y posistion.
     */
    private boolean getAllMoves(Board board, int fromx, int fromy, int tox, int toy){
        boolean[][] moves;
        boolean canMove = false;
        // get moves from peices using
        piece = board.board[fromx][fromy];
        moves = piece.getMoves(fromx, fromy,board);
        if(moves[tox][toy] == true && piece.white==true){
            canMove = true;
        }
        if(start == false){
            canMove = true;
        }
        return canMove;
    }
    

    /**
     * A helper function to fetch the current board state.
     * 
     * @return the board state.
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * Initiliazes the pieces when the start button is pressed.
     */
    private void start() {
        if (start == true) {
            start = false;
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
            btnReset.setEnabled(true);
        } else {
            start = true;
            String aiDepth = JOptionPane.showInputDialog("enter a value for AI depth 1-2:");
            depth = Integer.parseInt(aiDepth);
            btnStart.setEnabled(false);
            btnReset.setEnabled(false);
            btnStop.setEnabled(true);
        }
    }

    /**
     * Resets the pieces on the board.
     */
    private void reset() {
        txtTo.setEnabled(false);
        txtFrom.setEnabled(false);
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        btnReset.setEnabled(false);
        this.board.resetBoard();
        char[] spots = { 'r', 'k', 'b', 'q', 'l', 'b', 'k', 'r' };
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                this.places[j][i] = ' ';
            }
        }
        for (int i = 0; i < this.places.length; i++) {
            this.places[1][i] = 'P';
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                for (int j = 0; j < this.places.length; j++) {
                    this.places[0][j] = Character.toUpperCase(spots[j]);
                }
            } else if (i == 1) {
                for (int j = 0; j < this.places.length; j++) {
                    this.places[7][j] = spots[j];
                }
            }
        }
        for (int i = 0; i < this.places.length; i++) {
            this.places[6][i] = 'p';
        }
        panel.repaint();
    }
}
