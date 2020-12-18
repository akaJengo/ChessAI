
/**
 * AlphaBeta
 */
public class AlphaBeta {

    Heuristics h;
    Board bestBstate;
    int toX, toY;
    double val; 

    AlphaBeta() {
        h = new Heuristics();
    }

    private Board doMove(Board b, boolean[][] m, int fromx, int fromy) {
        Board temp = new Board();
        for (int i = 0; i < b.board.length; i++) {
            for (int j = 0; j < b.board[0].length; j++) {
                temp.board[i][j] = b.board[i][j];
            }
        }
        // boolean[][] j = mBoard.piece.moves;
        for (int i = 0; i < b.board.length; i++) {
            for (int j = 0; j < b.board[0].length; j++) {
                if (m[i][j]) {
                    temp.board[i][j] = temp.board[fromx][fromy];
                    temp.board[fromx][fromy] = null;
                    toX = i;
                    toY = j;
                    break;
                }
            }
        }
        return temp;
    }

    private Board undoMove(Board b, int fromx, int fromy, int toX, int toY) {
        Board temp = new Board();
        for (int i = 0; i < b.board.length; i++) {
            for (int j = 0; j < b.board[0].length; j++) {
                temp.board[i][j] = b.board[i][j];
            }
        }
        temp.board[fromx][fromy] = temp.board[toX][toY];
        temp.board[toX][toY] = null;
        toX = 0;
        toY = 0;
        return temp;
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
                    double t = maxValue(b, alpha, beta, depth - 1);
                    if (t > val) {
                        val = t; 
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