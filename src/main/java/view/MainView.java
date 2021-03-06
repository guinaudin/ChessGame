package view;

import controler.AbstractControler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.MoveList;
import model.Position;
import model.board.Board;
import model.piece.Bishop;
import model.piece.King;
import model.piece.Knight;
import model.piece.Pawn;
import model.piece.Piece;
import model.piece.Queen;
import model.piece.Rook;
import model.player.Player;
import observer.Observer;

public class MainView extends JFrame implements Observer, ActionListener {
    private final AbstractControler controler;
    private JPanel startPagePanel;
    private JLabel imageMainView;
    private JMenuItem newGame2PMenuItem;
    private JMenuItem newGame1PMenuItem;
    private JMenuItem quitMenuItem;
    private JMenu miscellaneousMenu;
    private JMenuItem websiteMenuItem;
    private JMenuItem rulesMenuItem;
    private URI url;
    private Desktop desktop = null;
    private JPanel chessBoardPanel;
    private JPanel gamePanel;
    private JButton[][] jButtonChessBoard;
    private static final String COLS = "ABCDEFGH";
    private Player whitePlayer;
    private Player blackPlayer;
    private Piece selectedPiece;
    private MoveList selectedPieceMoveList;
    private Boolean pieceDeselected;
    
    public MainView(AbstractControler controler) {
        super("Chess Game");
        this.controler = controler;
        
        selectedPieceMoveList = null;
        selectedPiece = null;
        pieceDeselected = false;
        
        this.buildFrame();
        this.buildMenuBar();
        
        this.setVisible(true);
    }   
    
    private void buildFrame() {
        //On donne une taille � notre fen�tre
        this.setSize(800,740);
        //On centre la fen�tre sur l'�cran
        this.setLocationRelativeTo(null);
        //On interdit la redimensionnement de la fen�tre
        this.setResizable(false); 
        //On dit � l'application de se fermer lors du clic sur la croix
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        startPagePanel = new JPanel(new BorderLayout());
        imageMainView = new JLabel(new ImageIcon(getClass().getResource("/images/ChessGame.jpg")));
        startPagePanel.add(imageMainView);
        this.setContentPane(startPagePanel);
    }
    
    private void buildMenuBar() {
        //creation de la menuBar
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        
        //creation de la premiere icone de la menuBar
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        
        //creation du premier element, un sous-menu
        newGame2PMenuItem = new JMenuItem("New Game 2P");
        newGame2PMenuItem.addActionListener(this);
        gameMenu.add(newGame2PMenuItem);
        
        //creation de la premiere icone de la menuBar
        newGame1PMenuItem = new JMenuItem("New Game 1P");
        newGame1PMenuItem.addActionListener(this);
        gameMenu.add(newGame1PMenuItem);
        
        //creation de la premiere icone de la menuBar
        quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener(this);
        gameMenu.add(quitMenuItem);

        //creation de la troisieme icone de la menuBar
        miscellaneousMenu = new JMenu("Miscellaneous");
        menuBar.add(miscellaneousMenu);
        
        //creation du 1er element
        websiteMenuItem = new JMenuItem("Website");
        websiteMenuItem.addActionListener(this);
        miscellaneousMenu.add(websiteMenuItem);
        
        //creation du 2nd element
        rulesMenuItem = new JMenuItem("Rules");
        rulesMenuItem.addActionListener(this);
        miscellaneousMenu.add(rulesMenuItem);
    }
    
    private void setNewContentPane(JPanel panel) {
        this.getContentPane().removeAll();
        this.getContentPane().add(panel);
        this.validate();
        this.repaint();
    }
    
    /**methode privée ajoutant les boutants gerant des evenements*/
    private JPanel buildBoardPanel() {
        gamePanel = new JPanel(new BorderLayout());
        gamePanel.setBackground(Color.WHITE);
        
        jButtonChessBoard = new JButton[8][8];
        
        //creation d'un objet JPanel
        chessBoardPanel = new JPanel(new FlowLayout());
        //layout par defaut
        chessBoardPanel.setLayout(new GridLayout(10, 10));
        chessBoardPanel.setBackground(Color.WHITE); 
        
        //fill the chess board
        chessBoardPanel.add(new JLabel(""));
        // fill the top row
        for (int i = 0; i < 8; i++) {
            chessBoardPanel.add(
                    new JLabel(COLS.substring(i, i + 1),
                    SwingConstants.CENTER));
        }
        chessBoardPanel.add(new JLabel(""));
                        
        //creation des JButtons installer sur le panel en les rendant evenementiel
        for(int j = 0; j < 8; j++) {
            for(int i = 0; i < 8; i++) {
                switch(i) {
                    case 0:
                        chessBoardPanel.add(new JLabel("" + (j + 1),
                                SwingConstants.CENTER));
                    default:
                        jButtonChessBoard[i][j] = new JButton("");
                        jButtonChessBoard[i][j].setActionCommand("button" + i + j);
                        jButtonChessBoard[i][j].addActionListener(this);
                        jButtonChessBoard[i][j].setOpaque(true);
                        jButtonChessBoard[i][j].setBorderPainted(false);
                        if((i+j)%2 == 1)
                            jButtonChessBoard[i][j].setBackground(Color.LIGHT_GRAY);
                        
                        chessBoardPanel.add(jButtonChessBoard[i][j]);
                        
                        if(i == 7)
                            chessBoardPanel.add(new JLabel(""));
                }
            }
        }
        chessBoardPanel.add(new JLabel(""));
        
        gamePanel.add(chessBoardPanel);

        return gamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source;
        
        //on recupere la source du clic
        if(e.getSource() instanceof JMenuItem) {
            source = (JMenuItem)(e.getSource());
            
            if(source == newGame2PMenuItem) {
                this.setNewContentPane(this.buildBoardPanel());
                whitePlayer = new Player(Piece.Side.WHITE, true);
                blackPlayer = new Player(Piece.Side.BLACK, false);
                controler.startNewGame(whitePlayer, blackPlayer);
            }
            else if(source == newGame1PMenuItem)
            {
                // TO DO
                this.setNewContentPane(this.buildBoardPanel());
                controler.startNewGame(new Player(Piece.Side.WHITE, true));
            }
            //si l'utilisateur clic sur "rules"
            else if(source == websiteMenuItem) {
                //tant qu'il n'y a pas d'exception
                try {
                    //creation de l'url � partir du lien internet
                    url = new java.net.URI("http://www.jouerauxechecs.fr");

                    //si le bureau permet le chargement du lien
                    if(Desktop.isDesktopSupported())
                    {
                        //on recupere le desktop
                        desktop = Desktop.getDesktop();
                        //puis on charge le lien
                        desktop.browse(url);
                    }
                }
                catch (Exception ex) 
                {
                    System.out.println(ex.getMessage());
                }
            }
            //si l'utilisateur clic sur "rules"
            else if(source == rulesMenuItem)
            {
                InputStream pdf = getClass().getClassLoader().getResourceAsStream("pdf/ChessGameRules.pdf");
     
                try {
                    File pdfCree = new File("LockNRoll rules.pdf");
                    // Extraction du PDF qui se situe dans l'archive
                    FileOutputStream fos = new FileOutputStream(pdfCree);
                    while(pdf.available() > 0) {
                          fos.write(pdf.read());
                    }
                    fos.close();
                    // Ouverture du PDF
                    Desktop.getDesktop().open(pdfCree);
                }

                catch (IOException err) {
                    System.out.println("erreur : " + err);
                }
            }
            //si l'utilisateur clic sur "quitter"
            else if(source == quitMenuItem)
            {
                //on ferme la fenetre
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                //on quitte le programme
                System.exit(0);
            }
        }
        else if(e.getSource() instanceof JButton) {
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if(e.getActionCommand().equals("button" + i + j)) {
                        this.selectOrMovePiece(new Position(i, j));
                    }
                }
            }
        }
    }
    
    private void selectOrMovePiece(Position pos) {
        System.out.println("Position ("+pos.getX()+","+pos.getY()+")");
        
        //If you want to deselect a piece
        if(controler.selectBoardPiece(pos) != null) {
            if(selectedPiece != null) {
                if(selectedPiece.getPosition().equals(pos)) {
                    selectedPieceMoveList = null;
                    selectedPiece = null;
                    pieceDeselected = true;
                    this.cleanBoardSelection();
                }
            }
        
            if(pieceDeselected == false) {
                if(whitePlayer.getTurn()) {
                    System.out.println("color : " + controler.selectBoardPiece(pos).getSide());
                    if(whitePlayer.getSide() == controler.selectBoardPiece(pos).getSide()) {
                        this.selectBoardPiece(pos);
                    }
                }
                else {
                    System.out.println("color : " + controler.selectBoardPiece(pos).getSide());
                    if(blackPlayer.getSide() == controler.selectBoardPiece(pos).getSide()) {
                        this.selectBoardPiece(pos);
                    }
                }
            }
        }
        //make the move
        //TO DO
        pieceDeselected = false;
    }
    
    
    private void selectBoardPiece(Position pos) {
        System.out.println("Piece selected");
        
        selectedPiece = controler.selectBoardPiece(pos);
        
        //test piece
        if(selectedPiece instanceof Rook)
            System.out.println("Piece : Rook");
        else if(selectedPiece instanceof King)
            System.out.println("Piece : King");
        else if(selectedPiece instanceof Queen)
            System.out.println("Piece : Queen");
        else if(selectedPiece instanceof Bishop)
            System.out.println("Piece : Bishop");
        else if(selectedPiece instanceof Knight)
            System.out.println("Piece : Knight");
        else if(selectedPiece instanceof Pawn)
            System.out.println("Piece : Pawn");
                
        selectedPieceMoveList = controler.getSelectedPieceMoveList(selectedPiece);
        
        this.highlightBoard(selectedPieceMoveList);
    }
    
    private void highlightBoard(MoveList selectedPieceMoveList) {
        this.cleanBoardSelection();
        
        for(int i = 0; i < selectedPieceMoveList.size(); i++) {
            jButtonChessBoard[selectedPieceMoveList.getMove(i).getDestinationPosition().getX()][selectedPieceMoveList.getMove(i).getDestinationPosition().getY()].setBackground(Color.DARK_GRAY);
        }
    }
    
    private void cleanBoardSelection() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if((i+j)%2 == 1)
                    jButtonChessBoard[i][j].setBackground(Color.LIGHT_GRAY);
                else
                    jButtonChessBoard[i][j].setBackground(Color.WHITE);
            }
        }
    }
    
    @Override
    public void updatePieceBoard(Board board) {
        Piece[][] chessBoard = board.getBoard();
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                try {
                    if((i+j)%2 == 1)
                        jButtonChessBoard[i][j].setBackground(Color.LIGHT_GRAY);
                    else
                        jButtonChessBoard[i][j].setBackground(Color.white);
                    if(chessBoard[i][j] != null)
                        jButtonChessBoard[i][j].setIcon(new ImageIcon(this.getPieceImage(chessBoard[i][j])));
                } catch (IOException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private Image getPieceImage(Piece piece) throws IOException {
        Image img = null;
        
            if(piece instanceof Rook)
                img = ImageIO.read(getClass().getClassLoader().getResource("images/pieces/Rook_" + piece.getSide() + ".png"));
            else if(piece instanceof Knight)
                img = ImageIO.read(getClass().getClassLoader().getResource("images/pieces/Knight_" + piece.getSide() + ".png"));
            else if(piece instanceof Pawn)
                img = ImageIO.read(getClass().getClassLoader().getResource("images/pieces/Pawn_" + piece.getSide() + ".png"));
            else if(piece instanceof Bishop)
                img = ImageIO.read(getClass().getClassLoader().getResource("images/pieces/Bishop_" + piece.getSide() + ".png"));
            else if(piece instanceof Queen)
                img = ImageIO.read(getClass().getClassLoader().getResource("images/pieces/Queen_" + piece.getSide() + ".png"));
            else if(piece instanceof King)
                img = ImageIO.read(getClass().getClassLoader().getResource("images/pieces/King_" + piece.getSide() + ".png"));
        
        return img;
    }
}
