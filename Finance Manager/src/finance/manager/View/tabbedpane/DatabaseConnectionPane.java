/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author User
 */
public class DatabaseConnectionPane extends JPanel implements ActionListener{
    
    private Properties _prop = new Properties();
    private JPanel _center = new JPanel();
    private JComboBox _database = new JComboBox();
    private JTextField _databaselocation = new JTextField();
    private JButton _commit = new JButton("Commit");
    
    public DatabaseConnectionPane() {
        super( new BorderLayout());
        this.add(new JLabel("Banco de dados"),BorderLayout.PAGE_START);
        this.setName("Banco de dados");
        try {
            InputStream is = new FileInputStream("database.properties");
            _prop.load(is);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConnectionPane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        createCenterPanel();
        add(_center,BorderLayout.CENTER);
        add(_commit,BorderLayout.PAGE_END);
        _commit.addActionListener(this);
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

    private void createCenterPanel() {
        GridLayout gl = new GridLayout(2,2);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        _center.setLayout(gl);
        _center.add(new JLabel("Database"),gbc);        
        _database.addItem("SQLite");
        _center.add(_database,gbc);
        _center.add(new JLabel("Database location"),gbc);
        _databaselocation.setText(_prop.getProperty("Database local"));
        _center.add(_databaselocation,gbc);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        _prop.setProperty("Database", (String)_database.getSelectedItem());
        _prop.setProperty("Database local", _databaselocation.getText());
        saveProperties();
    }
}
