package model;

import java.util.ArrayList;
import model.board.Board;
import model.piece.Piece;
import model.player.Player;
import observer.Observable;
import observer.Observer;

public abstract class AbstractModel implements Observable {
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();
    
    public abstract void startNewGame(Player whitePlayer);

    public abstract void startNewGame(Player whitePlayer, Player blackPlayer);
    
    public abstract void makeTurn();
    
    public abstract Piece selectBoardPiece(Position pos);
    
    public abstract MoveList getSelectedPieceMoveList(Piece selectedPiece);
    
    @Override
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }
    
    @Override
    public void removeObserver() {
        listObserver = new ArrayList<Observer>();
    }
    
    @Override
    public void notifyBoardObserver(Board board) {
        for(Observer obs : listObserver) {
             obs.updatePieceBoard(board);
        }
    }
}
