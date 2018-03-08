/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Cliente;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import javafx.scene.control.ScrollBar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author User
 */
public class ClientePane extends JPanel {
    
    private JTable _table = null;
    private JScrollPane _sp_table = null;
    public ClientePane() {
        super(new BorderLayout());
        
        createTable();
    }

    private void createTable() {
        
        _table = new JTable(new ClienteTableColumnModel());
        _sp_table = new JScrollPane(_table);
        this.add(_sp_table, BorderLayout.CENTER);
   }
}
