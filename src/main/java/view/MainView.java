package view;

import controler.AbstractControler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import model.piece.Piece;
import model.player.Player;

public class MainView extends JFrame implements ActionListener{
    private final AbstractControler controler;
    private JPanel startPagePanel;
    private JLabel imageMainView;
    private JMenuItem newGame2PMenuItem;
    private JMenuItem newGame1PMenuItem;
    private JMenuItem quitMenuItem;
    private JMenu miscellaneousMenu;
    private JMenuItem websiteMenuItem;
    private JMenuItem rulesMenuItem;
    private JPanel boardPanel;
    private URI url;
    private Desktop desktop = null;
    private JPanel chessBoardPanel;
    private JPanel gamePanel;
    private JButton[][] jButtonChessBoard;
    
    public MainView(AbstractControler controler) {
        super("Chess Game");
        this.controler = controler;
        
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
        chessBoardPanel.setLayout(new GridLayout(8, 8));
        chessBoardPanel.setBackground(Color.WHITE); 
                        
        //creation des JButtons installer sur le panel en les rendant evenementiel
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                jButtonChessBoard[i][j] = new JButton("");
                jButtonChessBoard[i][j].setActionCommand("button" + i + j);
                jButtonChessBoard[i][j].setOpaque(true);
                jButtonChessBoard[i][j].setBorderPainted(false);
                if((i+j)%2 == 1)
                    jButtonChessBoard[i][j].setBackground(Color.gray);
                jButtonChessBoard[i][j].addActionListener(this);
          
                chessBoardPanel.add(jButtonChessBoard[i][j]);
            }
        }
        
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
                controler.startNewGame(new Player(Piece.Side.WHITE, true), new Player(Piece.Side.BLACK, false));
            }
            else if(source == newGame1PMenuItem)
            {
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
    }
}
