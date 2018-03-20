/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.model;

import finance.manager.model.data.ClienteData;
import finance.manager.model.data.VendedorData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class GlobalDataVendedor {
    
    private static GlobalDataVendedor _instance = null;
    private Hashtable<Integer,VendedorData> _vendedores = null;
    
    public static GlobalDataVendedor getInstance() {
        if(_instance == null ) _instance = new GlobalDataVendedor();
        return _instance;
    }
    
    private GlobalDataVendedor() {
        loadData();
    }
    
    public Enumeration<VendedorData> getClienteEnumeration(){
        return _vendedores.elements();
    }
    
    public int getClienteNum() {
        return _vendedores.size();
    }
    
    public VendedorData getCliente(int id) {
        return _vendedores.get(id);
    }
    
    private void loadData() {
        _vendedores = new Hashtable<Integer, VendedorData>();
        try {
            Statement stmt = DatabaseManager.getInstance().getDatabaseConfig("main").getConn().createStatement();
            ResultSet rs = stmt.executeQuery("select * from Vendedor");
            ResultSetMetaData rsmd = rs.getMetaData();
            VendedorData vd;
            while(rs.next()) {
                vd = new VendedorData();
                vd.loadData(rs, rsmd);
                _vendedores.put(rs.getInt("ID"), vd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GlobalDataVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
