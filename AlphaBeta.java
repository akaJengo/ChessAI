/**
 * AlphaBeta
 */
package ChessAI;


import java.util.LinkedList;
import java.util.Queue;

public class AlphaBeta {

    Node head;          // Initial puzzle node
    
    Heuristics h;
    Board bestBstate;
    
    Queue<Board> q;      // Queues and Array Lists for search algoritms


    AlphaBeta(Board b) {
        h = new Heuristics();
        q = new LinkedList<>();
        allMoves(b);
    }
    
    private void allMoves(Board b){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                doMove(b,i,j);
            }
        }
    }
    
    private Board copy(Board b, Board temp){
        for (int i = 0; i < b.board.length; i++) {
            for (int j = 0; j < b.board[0].length; j++) {
                temp.board[i][j] = b.board[i][j];
            }
        }
        return temp; 
    }

    private void doMove(Board b, int fromx, int fromy) {
        Board newB = null;
        boolean[][] best = null;
        best = b.board[fromx][fromy].getMoves(fromx, fromy, newB);
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(best[i][j]==true){
                    newB = copy(b,newB);
                    newB.board[fromx][fromy] = newB.board[i][j];
                    newB.board[i][j] = null;
                    q.add(newB);
                }
            }
        }
    }
    
    private void doMoves(boolean[][] allMoves){
        
    }
    
    private boolean[][] bestMove(Board b,int x,int y){
        double bestScore = 0.0;
        boolean[][] best = null;
        best = b.board[x][y].getMoves(x, y, b);
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(best[i][j]==true){
                    Board tempB = new Board();
                    tempB = copy(b,tempB);
                    h = new Heuristics();
                    double score = h.evaluate(x,y,i,j,tempB);
                    if(score>bestScore){
                        bestScore = score;
                        b.board[x][y] = b.board[i][j];
                        b.board[i][j] = null;
                    }
                }
            }
        }
        return best;
    }


    public Board alphaBetaSearch(Board b, int depth) {
        for (int i = 0; i < b.board.length; i++) {
            double curr = maxValue(b, Double.MIN_VALUE, Double.MAX_VALUE, depth); 
        }
        return bestBstate; 
    }

    private double maxValue(Board b, double alpha, double beta, int depth) {
        val = Double.MIN_VALUE;
        if (depth == 0) {
            double r = h.evaluate(b, true);
            return r;
        }
        for (int i = 0; i < b.board.length; i++) { // need to be for each child of the node, i.e for move in moves.
            for (int j = 0; j < b.board[0].length; j++) {
                if (b.board[i][j] != null) {
                    b = doMove(b, b.board[i][j].getMoves(i, j, b), i, j);
                    double t = minValue(b, alpha, beta, depth - 1);
                    if (t < val) {
                        val = t; 
                        bestBstate = copy(b); 
                    }
                    b = undoMove(b, i, j, toX, toY);
                    if (val >= beta) {
                        //bestBstate = doMove(b, b.board[i][j].getMoves(i, j, b), i, j);
                        //undoMove(b, i, j, toX, toY);
                        return val;
                    }
                    if (alpha < val) {
                        alpha = val; 
                    }
                }
            }
        }
        return val;
    }

    private double minValue(Board b, double alpha, double beta, int depth) {
        val = Double.MAX_VALUE;
        if (depth == 0) {
            double r = h.evaluate(b, false);
            return r; 
        }
        for (int i = 0; i < b.board.length; i++) {
            for (int j = 0; j < b.board[0].length; j++) {
                if (b.board[i][j] != null) {
                    b = doMove(b, b.board[i][j].getMoves(i, j, b), i, j);
                    double g = maxValue(b, alpha, beta, depth - 1);
                    if (g > val) {
                        val = g; 
                        bestBstate = copy(b); 
                    }
                    b = undoMove(b, i, j, toX, toY);
                    if (val <= alpha) {
                        //bestBstate = doMove(b, b.board[i][j].getMoves(i, j, b), i, j);
                        //undoMove(b, i, j, toX, toY);
                        return val;
                    }
                    if (beta < val) {
                        beta = val; 
                    }
                }
            }
        }
        return val;
    }
}