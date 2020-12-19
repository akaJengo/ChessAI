package ChessAI;

/**
 *
 * @author        Aidan Larock 
 * @studentNumber #6186076
 * @assignment    1
 * @date          19/10/2020
 * 
 * Node
 * A class which contains information about the
 * Node object. Each node stores a 2D array called puzzle and has variables:
 * 
 * depth: The distance away the node is from the beginning node (aka number of parent nodes apart)
 * distance: Used in the A* heuristic search, this is the depth + calculated distance from the end goal (using Manhattan algorithm)
 * visited: Whether the node has been visited or not
 * 
 * parent: The Previous Node
 * child: The Next Node
 * sibling: Parent Nodes other child
 * 
 */
public class Node {
    
    Board board;

    int depth;
    double score;

    
    Node parent;
    Node child;
    Node sibling;
    
    Node(Board board,double score){ // Node must be passed a size of array
        
        this.board = board; // creates a new 2D array "Puzzle" of type int
        this.score = score;
        
    }
    
}
