/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.model.data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class FuncionarioData {
    private HashMap<String,String> _data = null;
    
    public FuncionarioData() {        
        this._data = new HashMap<>();
    }
    
    public String getData(String data) {
        return _data.get(data);
    }
    public void loadData(ResultSet rs, ResultSetMetaData rsmd){
        try {
            for(int i = 0; i < rsmd.getColumnCount(); ) {
                ++i;
                _data.put(rsmd.getColumnLabel(i), rs.getString(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendedorData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
