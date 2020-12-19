/**
 * AlphaBeta
 */
package ChessAI;


import java.util.LinkedList;
import java.util.Queue;

public class AlphaBeta {

    Node head;          // Initial puzzle node
    Node best;
    
    Heuristics h;
    Board bestBstate;
    
    Queue<Board> q;      // Queues and Array Lists for search algoritms
    Queue<Board> qW;      // Queues and Array Lists for search algoritms


    public AlphaBeta(Board b) {
        h = new Heuristics();
        q = new LinkedList<>();
        qW = new LinkedList<>();
        head = new Node(b,0.0);
        Node save = head;
        int depth = 0;
        while(depth<8){
            if(depth % 2 == 0){
                allMoves(b,false);
            }else{
                 allMoves(b,true);
            }
            boolean color = depth%2==0;
            addToNode(head,color);
            q = new LinkedList<>();
            if(head.sibling!=null){
                head = head.sibling;
            }else{
            head = head.child;
            depth++;
            }
        }
        Node best = new Node(null,0.0);
        best = findBestOutput(save,0,0,best);
        while(best.parent.parent!=null){
            best = best.parent;
        }
        
    }
    
    public Board getBest(){
        return best.board;
    }
    
    private void addToNode(Node h,boolean color){
        Heuristics scoreFinder = new Heuristics();
        double score = scoreFinder.evaluate(h.board);
        if(color == true){
        Board add = q.remove();
        Node newC = new Node(add, score);

        Node c = newC;
        h.child = c;

        while(!q.isEmpty()){
            add = q.remove();
            newC = new Node(add, score);
            c.sibling = newC;
            c = c.sibling;
        }
        }else{
            Board add = qW.remove();
            Node newC = new Node(add, score);
            
            Node c = newC;
            h.child = c;
            c.parent = h;

            while(!qW.isEmpty()){
                add = qW.remove();
                newC = new Node(add, score);
                c.sibling = newC;
                c.parent = h;
                c = c.sibling;
            } 
        }
    }
    
    private void allMoves(Board b,boolean color){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                doMove(b,i,j,color);
            }
        }
    }
    
    private Board copy(Board b, Board temp){
        temp = new Board();
        for (int i = 0; i < b.board.length; i++) {
            for (int j = 0; j < b.board[0].length; j++) {
                temp.board[i][j] = b.board[i][j];
            }
        }
        return temp; 
    }

    private void doMove(Board b, int fromx, int fromy, boolean color) {
        Board newB = null;
        boolean[][] best = null;
        try{
        best = b.board[fromx][fromy].getMoves(fromx, fromy, b);
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(best[i][j]==true){
                    newB = copy(b,newB);
                    newB.board[i][j] = newB.board[fromx][fromy];
                    newB.board[fromx][fromy] = null;
                    if(newB.board[i][j].white==color){
                        q.add(newB);
                    }else{
                        qW.add(newB);
                    }
                }
            }
        }
        }catch(Exception e){
            
        }
    }

    private Node findBestOutput(Node save,double score, double bestScore, Node best) {
        if (save == null){ 
            return best; 
        }

        score = score+save.score;
  
        findBestOutput(save.child, score,bestScore,best); 
        if(Math.abs(score)>bestScore){
            bestScore = Math.abs(score);
            best = save;
        }
        score = 0;
        findBestOutput(save.sibling, score,bestScore,best);
        return best;
    }


}