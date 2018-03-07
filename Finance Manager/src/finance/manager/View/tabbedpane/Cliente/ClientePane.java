/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Cliente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author User
 */
public class ClientePane extends JPanel {
    
    private JTable _table = new JTable();
    
    public ClientePane() {
        super(new GridBagLayout());
        
        createTable();
    }

    private void createTable() {
         
   }
}
