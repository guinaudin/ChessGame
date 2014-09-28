package view;

import controler.AbstractControler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainView extends JFrame implements ActionListener{
    private AbstractControler controler;
    
    public MainView(AbstractControler controler) {
        super("Chess Game");
        this.controler = controler;
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
