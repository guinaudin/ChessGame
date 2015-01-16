package model.piece;

import model.Move;
import model.MoveList;
import model.Position;
import model.board.Board;
import model.board.LineTypes;

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
        
        if(board.isFree(new Position(positionOrigin, 0, -1))) {
            moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, 0, -1)));
            if(positionOrigin.getY() == LineTypes.Line.SEVEN.getInt() && board.isFree(new Position(positionOrigin, 0, -2)))
                moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, 0, -2)));
        }
        
        if(board.isFree(new Position(positionOrigin, 1, -1), side) && !board.isFree(new Position(positionOrigin, 1, -1)))
            moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, 1, -1)));
        if(board.isFree(new Position(positionOrigin, -1, -1), side) && !board.isFree(new Position(positionOrigin, -1, -1)))
            moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, -1, -1)));
        
        return moveList;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
