import java.util.Arrays;

/**
 * AlphaBeta
 */
public class AlphaBeta {

    Heuristics h;
    Board bestBstate;
    int toX, toY;

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
        double val = maxValue(b, Double.MIN_VALUE, Double.MAX_VALUE, depth);
        return b;
    }

    private double maxValue(Board b, double alpha, double beta, int depth) {
        double val = Double.MIN_VALUE;
        if (depth == 0) {
            return h.evaluate(b, true);
        }
        for (int i = 0; i < b.board.length; i++) { // need to be for each child of the node, i.e for move in moves.
            for (int j = 0; j < b.board[0].length; j++) {
                b = doMove(b, b.board[i][j].getMoves(i, j, b), i, j);
                val = Math.max(val, minValue(b, alpha, beta, depth - 1));
                b = undoMove(b, i, j, toX, toY);
                if (val >= beta) {
                    return val;
                }
                alpha = Math.max(alpha, val);
            }
        }
        return val;
    }

    private double minValue(Board b, double alpha, double beta, int depth) {
        double val = Double.MAX_VALUE;
        if (depth == 0) {
            return h.evaluate(b, false);
        }
        for (int i = 0; i < b.board.length; i++) {
            for (int j = 0; j < b.board[0].length; j++) {
                b = doMove(b, b.board[i][j].getMoves(i, j, b), i, j);
                val = Math.min(val, maxValue(b, alpha, beta, depth - 1));
                b = undoMove(b, i, j, toX, toY);
                if (val <= alpha) {
                    return val;
                }
                beta = Math.min(beta, val);
            }
        }
        return val;
    }
}