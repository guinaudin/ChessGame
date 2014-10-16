package model.piece;

import model.Move;
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
        int x = positionOrigin.getX();
        int y = positionOrigin.getY();
        
        Position tempPosition = new Position(x-1, y);
        while(board.isFree(tempPosition, side)) {
            moveList.AddAllowedMove(new Move(positionOrigin, tempPosition));
            
            x--;
            tempPosition = new Position(x, positionOrigin.getY());
        }
        
        x = positionOrigin.getX() + 1;
        tempPosition = new Position(x, positionOrigin.getY());
        while(board.isFree(tempPosition, side)) {
            moveList.AddAllowedMove(new Move(positionOrigin, tempPosition));
            
            x++;
            tempPosition = new Position(x, positionOrigin.getY());
        }
        
        y = positionOrigin.getY() - 1;
        tempPosition = new Position(positionOrigin.getX(), y);
        while(board.isFree(tempPosition, side)) {
            moveList.AddAllowedMove(new Move(positionOrigin, tempPosition));
            
            y--;
            tempPosition = new Position(positionOrigin.getX(), y);
        }
        
        y = positionOrigin.getY() + 1;
        tempPosition = new Position(positionOrigin.getX(), y);
        while(board.isFree(tempPosition, side)) {
            moveList.AddAllowedMove(new Move(positionOrigin, tempPosition));
            
            y++;
            tempPosition = new Position(positionOrigin.getX(), y);
        }
        
        x = positionOrigin.getX() - 1;
        y = positionOrigin.getY() - 1;
        tempPosition = new Position(x, y);
        while(board.isFree(tempPosition, side)) {
            moveList.AddAllowedMove(new Move(positionOrigin, tempPosition));
            
            x--;
            y--;
            tempPosition = new Position(x, y);
        }
        
        x = positionOrigin.getX() - 1;
        y = positionOrigin.getY() + 1;
        tempPosition = new Position(x, y);
        while(board.isFree(tempPosition, side)) {
            moveList.AddAllowedMove(new Move(positionOrigin, tempPosition));
            
            x--;
            y++;
            tempPosition = new Position(x, y);
        }
        
        x = positionOrigin.getX() + 1;
        y = positionOrigin.getY() - 1;
        tempPosition = new Position(x, y);
        while(board.isFree(tempPosition, side)) {
            moveList.AddAllowedMove(new Move(positionOrigin, tempPosition));
            
            x++;
            y--;
            tempPosition = new Position(x, y);
        }
        
        x = positionOrigin.getX() + 1;
        y = positionOrigin.getY() + 1;
        tempPosition = new Position(x, y);
        while(board.isFree(tempPosition, side)) {
            moveList.AddAllowedMove(new Move(positionOrigin, tempPosition));
            
            x++;
            y++;
            tempPosition = new Position(x, y);
        }
        
        return moveList;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
