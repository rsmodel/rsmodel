/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Funcionario;

import finance.manager.model.GlobalDataCliente;
import finance.manager.model.GlobalDataFuncionario;
import finance.manager.model.data.ClienteData;
import finance.manager.model.data.FuncionarioData;
import java.util.Enumeration;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo
 */
public class FuncionarioTableColumnModel extends DefaultTableModel{
    
    public FuncionarioTableColumnModel() {
        super();
        initColumns();
    }
    
    @Override
    public boolean isCellEditable(int row, int column){  
          return false;  
    }
    
    private void initColumns() {
        this.addColumn("ID");
        this.addColumn("NOME");
        this.setRowCount(GlobalDataFuncionario.getInstance().getClienteNum());
        Enumeration<FuncionarioData> cliente = GlobalDataFuncionario.getInstance().getClienteEnumeration();
        int i = 0;
        while(cliente.hasMoreElements()){
            FuncionarioData cd = cliente.nextElement();
            this.setValueAt(cd.getData("ID"), i, 0);
            this.setValueAt(cd.getData("NOME"), i++, 1);
        }
    }
    
}
