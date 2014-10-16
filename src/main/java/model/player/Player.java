package model.player;

import model.piece.Piece.Side;

public class Player {
    private Side side;
    private boolean myTurn;
    
    public Player(Side side, boolean myTurn) {
        this.side = side;
        this.myTurn = myTurn;
    }
}
