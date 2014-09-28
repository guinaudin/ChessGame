package model.piece;

public class Queen extends Piece {
    public Queen(Side side) {
        this.side = side;
        this.cost = 40;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
