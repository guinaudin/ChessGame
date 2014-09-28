package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.board.Board;
import model.piece.Piece;

public class MoveList implements Iterable<Move> {
    private Board board;
    private boolean check;
    private final List<Move> moveList = new ArrayList<>();

    public MoveList(final Board verifyBoard) {
        this(verifyBoard, true);
    }

    public MoveList(final Board verifyBoard, final boolean checkCheck) {
        board = verifyBoard;
        check = checkCheck;
    }

    public void add(Move move) {
        moveList.add(move);
    }

    public boolean addCapture(Move move) {
        Piece piece = board.getPiece(move.getOriginPosition());
        
        if (board.isFree(move.getDestinationPosition(), piece.getSide())) {
            /*if (!causesCheck(move)) {
                add(move);
                return true;
            }
            return true; // false only for a "blocking" move*/
        }
        return false;
    }

    public final int size() {
        return moveList.size();
    }

    @Override
    public final Iterator<Move> iterator() {
        return moveList.iterator();
    }
}
