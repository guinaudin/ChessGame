package model.piece;

import model.MoveList;
import model.Position;
import model.board.Board;

public class Queen extends Piece {
    public Queen(Side side) {
        this.side = side;
        this.cost = 9;
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
