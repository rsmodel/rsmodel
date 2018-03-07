/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.menubar;

import finance.manager.Controller.menubar.arquivo.DatabaseFileMenuListener;
import finance.manager.Controller.menubar.arquivo.PessoasMenuListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author User
 */
public class PessoasMenu {
    JMenu _menu = new JMenu("Pessoas");
    private static PessoasMenu _instance = new PessoasMenu();
    
    public static PessoasMenu getInstance() {
        return _instance;
    }
    
    private PessoasMenu() {
        JMenuItem _item = new JMenuItem("Cliente");
        _item.addActionListener(new PessoasMenuListener());
        _menu.add(_item);
        
        _item = new JMenuItem("Fornecedor");
        _item.addActionListener(new PessoasMenuListener());
        _menu.add(_item);
    }
    
    public void addMenu(JMenuBar menubar) {
        menubar.add(_menu);
    }
    
    public void removeMenu(JMenuBar menubar) {
        menubar.remove(_menu);
    }
}
