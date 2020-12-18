/**
 * Heuristics Berliner, Hans (1999), The System: A World Champion's Approach to
 * Chess, Gambit Publications, ISBN 1-901983-10-2 P 1.0 K 3.2 B 3.33 R 5.1 Q 8.8
 * King 4.0
 * 
 * 
 */
public class Heuristics {

    double wScore = 0.4;
    double bScore;


    public double evaluate(Board b, boolean isBlack) {
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
        if (isBlack) {
            return wScore - bScore;
        } else {
            return bScore - wScore;
        }
    }
}