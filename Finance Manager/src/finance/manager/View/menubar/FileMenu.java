/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.menubar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author User
 */
public class FileMenu {
    
    JMenu _menu = new JMenu("File");
    private static FileMenu _instance = new FileMenu();
    
    public static FileMenu getInstance() {
        return _instance;
    }
    
    
    private FileMenu() {
        _menu.add(new JMenuItem("Arquivo"));
    }
    
    public void addMenu(JMenuBar menubar) {
        menubar.add(_menu);
    }
    
    public void removeMenu(JMenuBar menubar) {
        menubar.remove(_menu);
    }
}
