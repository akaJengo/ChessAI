/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAI.pieces;

import ChessAI.Board;

/**
 * The rook piece in chess can move up columns, up rows and the vice versa is
 * true, down coloumns and down rows.
 * 
 * @author Aidan Larock
 * @author Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #6402176
 * @assignment 4 - Group Project
 * 
 * @version 2.6
 */
public class Rook extends Piece {
    char type = 'R';

    /**
     * This method sets a boolean to check if it is whites piece.
     * 
     * @param isWhite a boolean asking if the current move is white.
     */
    public Rook(boolean isWhite) {
        super(isWhite);

    }

    /**
     * This method simply returns the type of piece currently on the board.
     * 
     * @return type of piece Rook.
     */
    @Override
    public char getType() {
        return this.type;
    }

    /**
     * A simple get method to return the value of a piece.
     * 
     * @return value of piece, Rook 5.1.
     */
    @Override
    public double getValue() {
        this.value = 5.1;
        return this.value;
    }

    /**
     * This method tests all spots in row and coloumn major that the rook can move
     * to.
     * 
     * @param x position to calculate moves.
     * @param y posistion to calculate moves.
     * @board current board state.
     * @return a 2D boolean matrix containing possible rook moves.
     */
    @Override
    public boolean[][] getMoves(int x, int y, Board board) {
        this.moves = new boolean[8][8];
        for (int i = 1; i < moves.length; i++) {
            if (y + i < 8) {
                if (board.board[x][y + i] != null) {
                    if (board.board[x][y + i].white != this.white) {
                        this.moves[x][y + i] = true;
                    }
                    break;
                } else {
                    this.moves[x][y + i] = true;
                }
            }
        }
        for (int i = 1; i < moves.length; i++) {
            if (y - i >= 0) {
                if (board.board[x][Math.abs(y - i)] != null) {
                    if (board.board[x][Math.abs(y - i)].white != this.white) {
                        this.moves[x][Math.abs(y - i)] = true;
                    }
                    break;
                } else {
                    this.moves[x][y - i] = true;
                }
            }
        }
        for (int i = 1; i < moves.length; i++) {
            if (x + i < 8) {
                if (board.board[x + i][y] != null) {
                    if (board.board[x + i][y].white != this.white) {
                        this.moves[x + i][y] = true;
                    }
                    break;
                } else {
                    this.moves[x + i][y] = true;
                }
            }
        }
        for (int i = 1; i < moves.length; i++) {
            if (x - i >= 0) {
                if (board.board[Math.abs(x - i)][y] != null) {
                    if (board.board[Math.abs(x - i)][y].white != this.white) {
                        this.moves[Math.abs(x - i)][y] = true;
                    }
                    break;
                } else {
                    this.moves[Math.abs(x - i)][y] = true;
                }
            }
        }
        return this.moves;
    }
}