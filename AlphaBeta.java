/**
 * AlphaBeta
 */
public class AlphaBeta {

    Heuristics h;

    AlphaBeta() {
        h = new Heuristics();
    }

    public int alphaBetaMax(Board b, int depth, int alpha, int beta, boolean isBlack) {
        if (depth == 0) {
            return h.evaluate(b, isBlack);
        }
        if (isBlack) {
            int val = Integer.MIN_VALUE;

            for (int i = 0; i < 0; i++) { // need to be for each child of the node, i.e for move in moves.
                val = Math.max(val, alphaBetaMax(b, depth - 1, alpha, beta, false));
                alpha = Math.max(alpha, val);

                if (alpha >= beta) {
                    break;
                }
            }
            return val;

        } else {
            int val = Integer.MAX_VALUE;

            for (int i = 0; i < 0; i++) {
                val = Math.min(val, alphaBetaMax(b, depth - 1, alpha, beta, true));
                beta = Math.min(beta, val);

                if (beta <= alpha) {
                    break;
                }
            }
            return val;
        }
    }
}