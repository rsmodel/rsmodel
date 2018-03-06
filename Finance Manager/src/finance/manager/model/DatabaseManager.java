/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DatabaseManager {
    private static DatabaseManager _instance = new DatabaseManager();
        
    public static DatabaseManager getInstance(){
        return _instance;
    }
    
    private DatabaseManager() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private HashMap<String,Connection> _connections = new HashMap<String,Connection>();
    
    public void addSqliteDatabase(String database,String db) {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlite:" + db);
            
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        if(conn != null) _connections.put(db, conn);
    }
}
