/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.menubar;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 *
 * @author User
 */
public class MainMenubar {

    private JMenuBar _menubar;    
    private static MainMenubar _instance = new MainMenubar();
    
    public static MainMenubar getInstance() {
        return _instance;
    }
    private MainMenubar() {
        _menubar = new JMenuBar();
    }
 
    public void setMenuBar(JFrame frame) {
        frame.setJMenuBar(_menubar);
    }
    
}
