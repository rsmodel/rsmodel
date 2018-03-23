/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.Controller.menubar.arquivo;

import finance.manager.View.tabbedpane.Cliente.ClientePane;
import finance.manager.View.tabbedpane.Funcionario.FuncionarioPane;
import finance.manager.View.tabbedpane.TabbedPaneManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class PessoasMenuListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {     
        switch(e.getActionCommand()) {
            case "Cliente":
                TabbedPaneManager.getInstance().addPane("Cliente", new ClientePane());
                break;
            case "Funcionario":
                TabbedPaneManager.getInstance().addPane("Funcionario", new FuncionarioPane());
                break;
        }
    }
    
}
