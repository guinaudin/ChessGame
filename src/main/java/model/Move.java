package model;

import model.piece.Piece;

public final class Move {
    private final Position originPosition;
    private final Position destinationPosition;
    private String replacement;
    private Piece.Side replacementSide;
    private Move next;
    private Piece captured;

    public Move(final Position originPosition, final Position destinationPosition) {
        this.destinationPosition = destinationPosition;
        this.originPosition = originPosition;
        next = null;
    } 
    
    public Position getOriginPosition() {
        return originPosition;
    }
    
    public Position getDestinationPosition() {
        return destinationPosition;
    }
}
