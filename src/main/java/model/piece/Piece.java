package model.piece;

import model.MoveList;
import model.Position;
import model.board.Board;

public abstract class Piece {
    protected int cost;
    protected Side side;
    protected Position position;
    
    public enum Side { 
        BLACK(-1), WHITE(1);

        private int side;

        private Side(int side) {
            this.side = side;
        }

        public int getInt() {
            return side;
        } 
    }
    
    public abstract void move();
    
    public abstract MoveList getMoveList(Board board);
    
    public Position getPosition() {
        return position;
    }
    
    public Side getSide() {
        return side;
    }
}
