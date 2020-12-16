/**
 * AlphaBeta
 */
public class AlphaBeta {

    Heuristics h;
    Board b;

    AlphaBeta() {
        h = new Heuristics();
    }

    public Board alphaBetaSearch(Board b) {
        int val = maxValue(b, Integer.MIN_VALUE, Integer.MAX_VALUE);
        b.val = val;
        return b;
    }

    public int maxValue(Board b, int alpha, int beta) {
        int val = Integer.MIN_VALUE;

        for (int i = 0; i < 0; i++) { // need to be for each child of the node, i.e for move in moves.
            val = Math.max(val, minValue(b, alpha, beta));
            if (val >= beta) {
                return val;
            }
            alpha = Math.max(alpha, val);
        }
        return val;
    }

    public int minValue(Board b, int alpha, int beta) {
        int val = Integer.MAX_VALUE;

        for (int i = 0; i < 0; i++) {
            val = Math.min(val, maxValue(b, alpha, beta));

            if (val <= alpha) {
                return val;
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