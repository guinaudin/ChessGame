package model.piece;

import model.Move;
import model.MoveList;
import model.Position;
import model.board.Board;
import static model.piece.Knight.NEAR;

public class King extends Piece {
    public King(Position position, Side side) {
        this.position = position;
        this.side = side;
    }
    
    @Override
    public MoveList getMoveList(Board board) {
        MoveList moveList = new MoveList(board);
        
        Position positionOrigin = this.getPosition();
        
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, 0, 1)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, 1, 0)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, 1, 1)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, -1, 1)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, 1, -1)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, -1, -1)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, 0, -1)));
        moveList.AddAllowedMove(new Move(positionOrigin, new Position(positionOrigin, -1, 0)));
        
        return moveList;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
