/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Cliente;

import javax.swing.event.TableColumnModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author User
 */
public class ClienteTableColumnModel extends DefaultTableModel{
    
    public ClienteTableColumnModel() {
        super();
        
        this.addColumn("ID");
        this.addColumn("Razao Social");
        this.addColumn("Nome Fantasia");
        this.setRowCount(100);
        
    }
}
