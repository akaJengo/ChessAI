/**
 * Heuristics Berliner, Hans (1999), The System: A World Champion's Approach to
 * Chess, Gambit Publications, ISBN 1-901983-10-2 P 1.0 K 3.2 B 3.33 R 5.1 Q 8.8
 * King 4.0
 * 
 * 
 */
package ChessAI;

public class Heuristics {

    double wScore = 0.4;
    double bScore;


        for (int i = 0; i < totalPieces; i++) {
            wScore += 1;
            bScore += 1;
        }
        if (isBlack) {
            return wScore - bScore;
        } else {
            return bScore - wScore;
        }
    }
}