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
public class MenubarManager {
    
    private JMenuBar _menubar;    
    private static MenubarManager _instance = new MenubarManager();
    
    public static MenubarManager getInstance() {
        return _instance;
    }
    private MenubarManager() {
        _menubar = new JMenuBar();
        
        FileMenu.getInstance().addMenu(_menubar);
        
    }
 
    public void setMenuBar(JFrame frame) {
        frame.setJMenuBar(_menubar);
    }
    
}
