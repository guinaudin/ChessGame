package model.piece;

public class Pawn extends Piece {
    public Pawn(Side side) {
        this.side = side;
        this.cost = 1;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
