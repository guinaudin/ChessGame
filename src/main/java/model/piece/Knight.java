package model.piece;

import model.Move;
import model.MoveList;
import model.Position;
import model.board.Board;

public class Knight extends Piece {
    static final int NEAR = 1;
    static final int FAR = 2;
    
    public Knight(Position position, Side side) {
        this.position = position;
        this.side = side;
        this.cost = 3;
    }

    @Override
    public final MoveList getMoveList(Board board) {
        MoveList moveList = new MoveList(board);
        
        Position positionOrigin = this.getPosition();
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, NEAR, FAR)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, FAR, NEAR)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, -FAR, NEAR)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, -FAR, -NEAR)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, FAR, -NEAR)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, NEAR, -FAR)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, -NEAR, -FAR)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, -NEAR, FAR)));
        
        return moveList;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
