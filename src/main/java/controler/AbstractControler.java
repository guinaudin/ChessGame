package controler;

import model.AbstractModel;
import model.piece.Piece;
import model.player.Player;

public abstract class AbstractControler {
    protected AbstractModel abstractModel;
    
    public AbstractControler(AbstractModel abstractModel) {
        this.abstractModel = abstractModel;
    }
    
    public void startNewGame(Player whitePlayer) {
        abstractModel.startNewGame(whitePlayer);
    }
    
    public void startNewGame(Player whitePlayer, Player blackPlayer) {
        abstractModel.startNewGame(whitePlayer, blackPlayer);
    }
    
    public void makeTurn() {
         abstractModel.makeTurn();
    }
    
    public Piece selectBoardPiece(int posX, int posY) {
        return abstractModel.selectBoardPiece(posX, posY);
    }
}
