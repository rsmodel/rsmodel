/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.Controller.menubar.arquivo;

import finance.manager.View.tabbedpane.DatabaseConnectionPane;
import finance.manager.View.tabbedpane.TabbedPaneManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class DatabaseFileMenuListener implements ActionListener {

    public DatabaseFileMenuListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!TabbedPaneManager.getInstance().panelExist("Banco de Dados"))
            TabbedPaneManager.getInstance().addPane("Banco de Dados", new DatabaseConnectionPane());
    }
    
}
