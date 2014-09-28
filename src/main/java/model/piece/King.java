package model.piece;

public class King extends Piece {
    public King(Side side) {
        this.side = side;
        this.cost = 100;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
