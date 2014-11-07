package model.piece;

import model.MoveList;
import model.Position;
import model.board.Board;

public class Pawn extends Piece {
    public Pawn(Position position, Side side) {
        this.position = position;
        this.side = side;
        this.cost = 1;
    }
    
    @Override
    public MoveList getMoveList(Board board) {
        MoveList moveList = new MoveList(board);
        
        Position positionOrigin = this.getPosition();
        
        return moveList;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
