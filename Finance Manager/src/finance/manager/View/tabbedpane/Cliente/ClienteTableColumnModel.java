/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Cliente;

import finance.manager.model.GlobalDataCliente;
import finance.manager.model.data.ClienteData;
import java.util.Enumeration;
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
    
    @Override
    public boolean isCellEditable(int row, int column){  
          return false;  
      }
    private void initColumns() {
        
        this.addColumn("ID");
        this.addColumn("Razao Social");
        this.addColumn("Nome Fantasia");
        this.setRowCount(GlobalDataCliente.getInstance().getClienteNum());
        Enumeration<ClienteData> cliente = GlobalDataCliente.getInstance().getClienteEnumeration();
        int i = 0;
        while(cliente.hasMoreElements()){
            ClienteData cd = cliente.nextElement();
            this.setValueAt(cd.getId(), i, 0);
            this.setValueAt(cd.getRazao_social(), i, 1);
            this.setValueAt(cd.getNome_fantasia(), i++, 2);
        }
        
    }
}
