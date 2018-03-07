/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.Controller.menubar.arquivo;

import finance.manager.View.tabbedpane.Cliente.ClientePane;
import finance.manager.View.tabbedpane.TabbedPaneManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class PessoasMenuListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        System.out.println("finance.manager.Controller.menubar.arquivo.PessoasMenuListener.actionPerformed()");        
        switch(e.getActionCommand()) {
            case "Cliente":
                TabbedPaneManager.getInstance().addPane("Cliente", new ClientePane());
                break;
        }
    }
    
}
