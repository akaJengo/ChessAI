package ChessAI;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class
 * 
 * @author Aidan Larock
 * @author Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #6402176
 * @assignment 4 - Group Project
 */
public class AlphaBeta {

    Node head; // Initial puzzle node
    Node best;

    Heuristics h;
    Board bestBstate;

    Queue<Board> q; // Queues and Array Lists for search algoritms
    Queue<Board> qW; // Queues and Array Lists for search algoritms

    /**
     * 
     * @param b
     * @param maxDepth
     * @return
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
     * 
     * @param h
     * @param color
     */
    private void addToNode(Node h, boolean color) {
        Heuristics scoreFinder = new Heuristics();
        double score = scoreFinder.evaluate(h.board);
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
     * 
     * @param b
     * @param color
     */
    private void allMoves(Board b, boolean color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                doMove(b, i, j, color);
            }
        }
    }

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
     * 
     * @param b
     * @param fromx
     * @param fromy
     * @param color
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
     * 
     * @param save
     * @param score
     * @param bestScore
     * @return
     */
    private Node findBestOutput(Node save, double score, double bestScore) {
        if (save == null) {
            return best;
        }

        score = score + save.score;

        findBestOutput(save.child, score, bestScore);
        if (Math.abs(score) > bestScore) {
            bestScore = Math.abs(score);
            best = save;
        }
        score = 0;
        findBestOutput(save.sibling, score, bestScore);
        return best;
    }
}