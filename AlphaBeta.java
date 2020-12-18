/**
 * AlphaBeta
 */
package ChessAI;

public class AlphaBeta {

    Heuristics h;
    Board b;

    AlphaBeta() {
        h = new Heuristics();
    }
    private Board copy(Board b){
        Board temp = new Board(); 
        for (int i = 0; i < b.board.length; i++) {
            for (int j = 0; j < b.board[0].length; j++) {
                temp.board[i][j] = b.board[i][j];
            }
        }
        return temp; 
    }

    private Board doMove(Board b, boolean[][] m, int fromx, int fromy) {
        Board temp = new Board();

        temp = copy(b); 
        
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
        temp = copy(b); 
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

    public int maxValue(Piece b, int alpha, int beta, int depth) {
        int val = Integer.MIN_VALUE;
        if (depth == 0) {
            return h.evaluate(b, true);
        }
        for (int i = 0; i < 0; i++) { // need to be for each child of the node, i.e for move in moves.
            val = Math.max(val, minValue(b, alpha, beta, depth - 1));
            if (val >= beta) {
                return val;
            }
            alpha = Math.max(alpha, val);
        }
        return val;
    }

    public int minValue(Piece b, int alpha, int beta, int depth) {
        int val = Integer.MAX_VALUE;
        if (depth == 0) {
            return h.evaluate(b, false);
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
            beta = Math.min(beta, val);
        }
        return val;
    }

    // if (isBlack) {
    // int val = Integer.MIN_VALUE;

    // for (int i = 0; i < 0; i++) { // need to be for each child of the node, i.e
    // for move in moves.
    // val = Math.max(val, alphaBetaMax(b, depth - 1, alpha, beta, false));
    // alpha = Math.max(alpha, val);

    // if (alpha >= beta) {
    // break;
    // }
    // }
    // return val;

    // } else {
    // int val = Integer.MAX_VALUE;

    // for (int i = 0; i < 0; i++) {
    // val = Math.min(val, alphaBetaMax(b, depth - 1, alpha, beta, true));
    // beta = Math.min(beta, val);

    // if (beta <= alpha) {
    // break;
    // }
    // }
    // return val;
    // }
    // }
}