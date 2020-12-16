/**
 * ChessAI
 */
public class ChessAI {

    AlphaBeta ab;
    Board b;

    public ChessAI() {
        Board score = ab.alphaBetaSearch(b);

    }

    public static void main(String[] args) {
        new Gui();
        new ChessAI();
    }
}