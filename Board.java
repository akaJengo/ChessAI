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
public class Board {
    Piece[][] board;
    Piece piece;
    Queen queen;
    Pawn pawn;
    
    public Board(){
        board = new Piece[8][8];
    }
    
    public void addPieces(){
        Queen queenb = new Queen(false);
        Queen queenw = new Queen(true);
        board[0][3] = queenb;
        board[7][3] = queenb;
        
        King kingb = new King(false);
        King kingw = new King(true);
        board[0][4] = kingb;
        board[7][4] = kingw;
        
        Bishop bishopb = new Bishop(false);
        Bishop bishopw = new Bishop(true);
        board[0][5] = bishopb;
        board[7][5] = bishopw;
        board[0][2] = bishopb;
        board[7][2] = bishopw;
        
        Knight knightb = new Knight(false);
        Knight knightw = new Knight(true);
        board[0][6] = knightb;
        board[7][6] = knightw;
        board[0][1] = knightb;
        board[7][1] = knightw;
        
        Rook rookb = new Rook(false);
        Rook rookw = new Rook(true);
        board[0][7] = rookb;
        board[7][7] = rookw;
        board[0][0] = rookb;
        board[7][0] = rookw;
        
        Pawn pawnb = new Pawn(false);
        Pawn pawnw = new Pawn(true);
        for(int i=0;i<8;i++){
          board[1][i] = pawnb;
          board[6][i] = pawnw;
        }
        
        
    }
}
