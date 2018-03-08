/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.database;

import finance.manager.model.DatabaseManager;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    

    private void createCenterPanel() {
        GridBagLayout gl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        
        gbc.ipadx = 16;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        _center.setLayout(gl);
        _center.add(new JLabel("Database"),gbc);        
        _database.addItem("SQLite");
        
        gbc.ipadx = 400;
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        _center.add(_database,gbc);
        
        gbc.ipadx = 16;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        _center.add(new JLabel("Database location"),gbc);
        _databaselocation.setText(_prop.getProperty("Database local"));
        _databaselocation.setColumns(512);
        
        gbc.ipadx = 400;
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        _center.add(_databaselocation,gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        _prop.setProperty("Database", (String)_database.getSelectedItem());
        _prop.setProperty("Database local", _databaselocation.getText());
        DatabaseManager.getInstance().saveProperties();
    }
}
