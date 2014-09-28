package model.piece;

public class Bishop extends Piece {
    public Bishop(Side side) {
        this.side = side;
        this.cost = 5;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
