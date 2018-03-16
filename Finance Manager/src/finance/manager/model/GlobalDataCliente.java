/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.model;

import finance.manager.model.data.ClienteData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author User
 */
public class GlobalDataCliente {
    
    private static GlobalDataCliente _instance = null;
    private Hashtable<Integer,ClienteData> _clientes = null;
    
    public static GlobalDataCliente getInstance() {
        if(_instance == null ) _instance = new GlobalDataCliente();
        return _instance;
    }
    
    private GlobalDataCliente() {
        loadData();
    }
    
    public Enumeration<ClienteData> getClienteEnumeration(){
        return _clientes.elements();
    }
    
    public int getClienteNum() {
        return _clientes.size();
    }
    
    public ClienteData getCliente(int id) {
        return _clientes.get(id);
    }
    
    private void loadData() {
        _clientes = new Hashtable<Integer, ClienteData>();
        try {
            Statement stmt = DatabaseManager.getInstance().getDatabaseConfig("main").getConn().createStatement();
            ResultSet rs = stmt.executeQuery("select * from Cliente");
            while(rs.next()) {
                ClienteData cd = 
                        new ClienteData( 
                                rs.getInt("ID"), 
                                rs.getString("RAZAO_SOCIAL"),
                                rs.getString("NOME_FANTASIA"));
                cd.setF_j(rs.getString("F_J"));
                cd.setCPF_CNPJ(rs.getString("CPF_CNPJ"));
                cd.setInscrição_estadual(rs.getString("INSCR_EST"));
                cd.setFone(rs.getString("FONE"));
                cd.setEmail(rs.getString("EMAIL"));
                cd.setEndereco(rs.getString("ENDERECO"));
                cd.setComplemento(rs.getString("COMPLEMENTO"));
                cd.setCEP(rs.getString("CEP"));
                cd.setCidade(rs.getString("CIDADE"));
                cd.setUf(rs.getString("UF"));
                cd.setBairro(rs.getString("BAIRRO"));
                cd.setNum_endereco(rs.getString("NUM_ENDERECO"));
                cd.setVendedor(rs.getInt("ID_VENDEDOR"));
                cd.setTransportador(rs.getInt("ID_TRANSPORTADORA"));
                _clientes.put(cd.getId(), cd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GlobalDataCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
