package ChessAI;

/**
 * @author Aidan Larock
 * @author Michael Wisniewski
 * @studentNumber #6186076
 * @studentNumber #6402176
 * @assignment 4 - Group Project
 * 
 * @version 5.2
 * @see AlphaBeta
 * 
 * Node
 * A class which contains information about the
 * Node object. Each node stores a Board object:
 * 
 * score: score of board state
 * 
 * parent: The Previous Node
 * child: The Next Node
 * sibling: Parent Nodes other child
 * 
 */
public class Node {
    
    Board board;

    double score;

    Node parent;
    Node child;
    Node sibling;
    
    Node(Board board,double score){ // Node must be passed a size of array
        
        this.board = board; // creates a new 2D array "Puzzle" of type int
        this.score = score;
        
    }
    
}
