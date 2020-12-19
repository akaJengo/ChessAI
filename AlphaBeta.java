/**
 * AlphaBeta
 */
package ChessAI;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The AlphaBeta AI system that is used to determine the next best move for a
 * specific piece
 * 
 * @author Aidan Larock
 * @author Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #6402176
 * @assignment 4 - Group Project
 * 
 * @version 4.7
 * @see Heuristics
 */

public class AlphaBeta {

    Node head; // Initial board noce
    Node best; // best board node

    Heuristics h;
    Board bestBstate;

    Queue<Board> q; // queue for all black moves
    Queue<Board> qW; // queue for all white moves

    /**
     * This method gets the best board state for the AI
     * 
     * @param Board b
     * @param int   maxDepth
     */
    public Board getBest(Board b, int maxDepth) {
        h = new Heuristics();
        q = new LinkedList<>();
        qW = new LinkedList<>();
        head = new Node(b, 0.0);
        Node save = head;
        int depth = 0;
        while (depth < maxDepth) {
            if (depth % 2 == 0) {
                allMoves(b, false);
            } else {
                allMoves(b, true);
            }
            boolean color = depth % 2 == 0;
            addToNode(head, color);
            q = new LinkedList<>();
            if (head.sibling != null) {
                head = head.sibling;
            } else {
                head = head.child;
                depth++;
            }
        }
        Node best;
        best = findBestOutput(save, 0, 0);

        while (best.parent.parent != null) {
            best = best.parent;
        }
        return best.board;
    }

    /**
     * This method adds all of the possible moves to a tree
     * 
     * @param Node    h
     * @param Boolean color
     */
    private void addToNode(Node h, boolean color) {
        Heuristics scoreFinder = new Heuristics();
        double score = scoreFinder.evaluate(h.board);
        score = Math.abs(score);
        if (color == true) {
            Board add = q.remove();
            Node newC = new Node(add, score);

            Node c = newC;
            h.child = c;

            while (!q.isEmpty()) {
                add = q.remove();
                newC = new Node(add, score);
                c.sibling = newC;
                c = c.sibling;
            }
        } else {
            Board add = qW.remove();
            Node newC = new Node(add, score);

            Node c = newC;
            h.child = c;
            c.parent = h;

            while (!qW.isEmpty()) {
                add = qW.remove();
                newC = new Node(add, score);
                c.sibling = newC;
                c.parent = h;
                c = c.sibling;
            }
        }
    }

    /**
     * This method gets all of the possible moves that can be made and adds them to
     * a list
     * 
     * @param Board   b
     * @param Boolean color
     */
    private void allMoves(Board b, boolean color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                doMove(b, i, j, color);
            }
        }
    }

    /**
     * This method copies the current board state to a temporary state to be moved
     * 
     * @param Board b
     * @param Board temp
     */
    private Board copy(Board b, Board temp) {
        temp = new Board();
        for (int i = 0; i < b.board.length; i++) {
            for (int j = 0; j < b.board[0].length; j++) {
                temp.board[i][j] = b.board[i][j];
            }
        }
        return temp;
    }

    /**
     * This method moves pieces on the board from and to specific values
     * 
     * @param Board   b
     * @param int     fromx
     * @param int     fromy
     * @param boolean color
     */
    private void doMove(Board b, int fromx, int fromy, boolean color) {
        Board newB = null;
        boolean[][] best = null;
        try {
            best = b.board[fromx][fromy].getMoves(fromx, fromy, b);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (best[i][j] == true) {
                        newB = copy(b, newB);
                        newB.board[i][j] = newB.board[fromx][fromy];
                        newB.board[fromx][fromy] = null;
                        if (newB.board[i][j].white == color) {
                            q.add(newB);
                        } else {
                            qW.add(newB);
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    /**
     * This method gets the best board state using the values of the board states
     * with pre-order traversal
     * 
     * @param Board b
     * @param int   maxDepth
     */
    private Node findBestOutput(Node save, double score, double bestScore) {
        if (save == null) {
            return best;
        }

        score = score + save.score;

        findBestOutput(save.child, score, bestScore);
        if (score > bestScore) {
            bestScore = score;
            best = save;
        }
        score = 0;
        findBestOutput(save.sibling, score, bestScore);
        return best;
    }

}