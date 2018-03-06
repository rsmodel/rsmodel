/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DatabaseConnectionPane extends JPanel{
    
    private Properties _prop = new Properties();
    
    public DatabaseConnectionPane() {
        super( new BorderLayout());
        this.add(new JLabel("Banco de dados"),BorderLayout.PAGE_START);
        
        _prop.setProperty("Database name", "main");        
        _prop.setProperty("Database", "SQLite");        
        _prop.setProperty("Database local", "db.db");
        
        saveProperties();
        
        InputStream is = getClass().getClassLoader().getResourceAsStream("database.properties");
        if(is == null) {
            System.out.println("file not found");
            return;
        }
        try {
            _prop.load(is);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConnectionPane.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    /**
     *
     */
    public void saveProperties() {
        try {
            _prop.store(new FileOutputStream("database.properties"), null);
            //InputStream is = getClass().getClassLoader().getResourceAsStream("database.config");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseConnectionPane.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConnectionPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
