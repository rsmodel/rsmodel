/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.model;

import finance.manager.model.data.FuncionarioData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class GlobalDataFuncionario {
    
    private static GlobalDataFuncionario _instance = null;
    private Hashtable<Integer,FuncionarioData> _funcionario = null;
    
    public static GlobalDataFuncionario getInstance() {
        if(_instance == null ) _instance = new GlobalDataFuncionario();
        return _instance;
    }
    
    private GlobalDataFuncionario() {
        loadData();
    }
    
    public Enumeration<FuncionarioData> getClienteEnumeration(){
        return _funcionario.elements();
    }
    
    public int getClienteNum() {
        return _funcionario.size();
    }
    
    public FuncionarioData getCliente(int id) {
        return _funcionario.get(id);
    }
    
    private void loadData() {
        _funcionario = new Hashtable<Integer, FuncionarioData>();
        try {
            Statement stmt = DatabaseManager.getInstance().getDatabaseConfig("main").getConn().createStatement();
            ResultSet rs = stmt.executeQuery("select * from Funcionario");
            ResultSetMetaData rsmd = rs.getMetaData();
            FuncionarioData vd;
            while(rs.next()) {
                vd = new FuncionarioData();
                vd.loadData(rs, rsmd);
                _funcionario.put(rs.getInt("ID"), vd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GlobalDataFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
