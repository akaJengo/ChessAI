package ChessAI;

/**
 * This class evaluates a heuristic for the current board. The evaluation
 * functions calculate the sum of the piece value, which is distinguished by
 * colour. The returning score is dependant on the colour, if it's black to
 * move, the returning score is the evaluation of the black pieces deducted by
 * the evaluation of whites score, the inverse is also true(white to move,
 * whites score deducted by blacks score).
 * 
 * 
 * @author Aidan Larock
 * @author Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #6402176
 * @assignment 4 - Group Project
 * 
 * @version 1.2
 */
public class Heuristics {

    double wScore = 0.4;
    double bScore;

    /**
     * Calculates the respective colour score based on piece value. Then returns the
     * maximizing score for black.
     * 
     * @param b the current boardstate to evaluate.
     * @return the black score minus whites score.
     */
    public double evaluate(Board b) {
        for (int i = 0; i < b.board.length; i++) {
            for (int j = 0; j < b.board[0].length; j++) {
                if (b.board[i][j] != null) {
                    if (b.board[i][j].getColor()) {
                        wScore += b.board[i][j].getValue();
                    } else {
                        bScore += b.board[i][j].getValue();
                    }
                }
            }
        }
        return bScore - wScore;
    }
}
