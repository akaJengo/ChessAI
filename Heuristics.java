/**
 * Heuristics Berliner, Hans (1999), The System: A World Champion's Approach to
 * Chess, Gambit Publications, ISBN 1-901983-10-2 P 1.0 K 3.2 B 3.33 R 5.1 Q 8.8
 * King 4.0
 * 
 * 
 */
package ChessAI;

public class Heuristics {

    int wScore, bScore;

    public int evaluate(Piece b, boolean isBlack) {
        wScore = 0;
        bScore = 0;
        int totalPieces = 100;

        for (int i = 0; i < totalPieces; i++) {
            wScore += 1;
            bScore += 1;
        }
        if (isBlack) {
            return bScore - wScore;
        } else {
            return wScore - bScore;
        }
    }
}