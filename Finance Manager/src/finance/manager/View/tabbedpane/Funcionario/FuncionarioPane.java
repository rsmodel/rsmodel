/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Funcionario;

import finance.manager.View.tabbedpane.Cliente.ClienteTableColumnModel;
import finance.manager.model.GlobalDataCliente;
import finance.manager.model.data.ClienteData;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author User
 */
public class FuncionarioPane extends JPanel implements ListSelectionListener{
    
    private JSplitPane _sp_main = null;
    private JPanel _info_pane = null;
    private JTable _table = null;
    private JScrollPane _sp_table = null;
    public FuncionarioPane() {
        super(new BorderLayout());
        createSplitPane();
    }

    private void createSplitPane() {
        _sp_main = new JSplitPane();
        createTablePane();
        createInfoPane();
        _sp_main.setLeftComponent(_sp_table);
        add(_sp_main,BorderLayout.CENTER);
    }

    private void createTablePane() {
        _table = new JTable(new FuncionarioTableColumnModel());
        _table.setColumnSelectionAllowed(false);
        _table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        _table.getSelectionModel().addListSelectionListener(this);
        _table.setCellEditor(null);
        _sp_table = new JScrollPane(_table);
        _sp_table.setMinimumSize(new Dimension(300,0));
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        
    }

    private void createInfoPane() {
        _info_pane = new FuncionarioInfoPane();
    }
}
