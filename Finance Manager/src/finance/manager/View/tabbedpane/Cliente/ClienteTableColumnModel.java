/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Cliente;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ClienteTableColumnModel extends DefaultTableModel{
    
    public ClienteTableColumnModel() {
        super();
        
        initColumns();
        
    }

    private void initColumns() {
        
        this.addColumn("ID");
        this.addColumn("Razao Social");
        this.addColumn("Nome Fantasia");
        this.setRowCount(100);
        
    }
}
