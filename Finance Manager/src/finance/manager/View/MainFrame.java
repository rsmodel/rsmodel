/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View;

import finance.manager.View.menubar.MainMenubar;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class MainFrame extends JFrame{

    private MainWindowListener _window_listener = new MainWindowListener();
    
    public MainFrame() {
        super("Finance Manager");
        
        this.addWindowListener(_window_listener);
        
        MainMenubar.getInstance().setMenuBar(this);
    }
    
    
    
}
