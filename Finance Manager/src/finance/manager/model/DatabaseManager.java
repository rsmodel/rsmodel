/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.model;

import finance.manager.View.tabbedpane.database.DatabaseConnectionPane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DatabaseManager {
    private static DatabaseManager _instance = null;
        
    public static DatabaseManager getInstance(){
        if(_instance == null) _instance = new DatabaseManager();
        return _instance;
    }
    private Properties _prop = new Properties();
    
    private DatabaseManager() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            InputStream is = new FileInputStream("database.properties");
            _prop.load(is);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConnectionPane.class.getName()).log(Level.SEVERE, null, ex);
        }
        addSqliteDatabase(_prop.getProperty("Database local"), _prop.getProperty("Database name"));
    }
    
    private HashMap<String,DatabaseConfig> _connections = new HashMap<String,DatabaseConfig>();
    
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
        if(conn != null) _connections.put(db, new DatabaseConfig(conn, "SQLite", database));
    }
    
    public void removeDatabase(String db) {
        try {
            _connections.get(db).getConn().close();
            _connections.remove(db);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public DatabaseConfig getDatabaseConfig(String db) {
        return _connections.get(db);
    }
    
    public void saveProperties() {
        try {
            _prop.setProperty("Database name", "main");
            _prop.setProperty("Database", _connections.get("main").getDatabase());
            _prop.setProperty("Database local", _connections.get("main").getLocal_database());
            _prop.store(new FileOutputStream("database.properties"), null);
            //InputStream is = getClass().getClassLoader().getResourceAsStream("database.config");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseConnectionPane.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConnectionPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
