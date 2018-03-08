/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.model;

import java.sql.Connection;

/**
 *
 * @author User
 */
public class DatabaseConfig {
    
    private Connection _conn; 
    private String _database;
    private String _local_database;

    public DatabaseConfig(Connection _conn, String _database, String _local_database) {
        this._conn = _conn;
        this._database = _database;
        this._local_database = _local_database;
    }    
    
    public Connection getConn() {
        return _conn;
    }

    public void setConn(Connection _conn) {
        this._conn = _conn;
    }

    public String getDatabase() {
        return _database;
    }

    public void setDatabase(String _database) {
        this._database = _database;
    }

    public String getLocal_database() {
        return _local_database;
    }

    public void setLocal_database(String _local_database) {
        this._local_database = _local_database;
    }
}
