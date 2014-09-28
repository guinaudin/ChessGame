package model.piece;

public class Rook extends Piece {
    public Rook(Side side) {
        this.side = side;
        this.cost = 10;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
