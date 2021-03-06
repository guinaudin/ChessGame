package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.board.Board;
import model.piece.Piece;

public class MoveList implements Iterable<Move> {
    private Board board;
    private boolean check;
    private final List<Move> moveArray = new ArrayList<Move>();

    public MoveList(final Board verifyBoard) {
        this(verifyBoard, true);
    }

    public MoveList(final Board verifyBoard, final boolean checkCheck) {
        board = verifyBoard;
        check = checkCheck;
    }
   
    public void AddAllowedMove(Move move) {
        Piece piece = board.getPiece(move.getOriginPosition());
        
        if(board.isFree(move.getDestinationPosition(), piece.getSide())) {
            if(!this.causesCheck(move)) {
               moveArray.add(move);
               System.out.println("added");
            }
        }
    }
    
    public boolean causesCheck(Move move) {
        return false;
    }

    public final int size() {
        return moveArray.size();
    }
    
    public Move getMove(int i) {
        return moveArray.get(i);
    }

    @Override
    public final Iterator<Move> iterator() {
        return moveArray.iterator();
    }
}
