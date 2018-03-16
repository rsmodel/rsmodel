/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Cliente;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

/**
 *
 * @author User
 */
public class ClientePane extends JPanel {
    
    private JTable _table = null;
    private JScrollPane _sp_table = null;
    private JPanel _panel = null;
    public ClientePane() {
        super(new BorderLayout());
        
        createTable();
    }

    private void createTable() {
        _table = new JTable(new ClienteTableColumnModel());
        _sp_table = new JScrollPane(_table);
        _panel = createSecondPanel();
        JSplitPane sp = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                _sp_table,
                _panel);
        
        
        this.add(sp, BorderLayout.CENTER);
        
   }
    
    private JPanel createSecondPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        
        gbc.ipadx = 200;
        //gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        //gbc.gridwidth = 1;
        //gbc.gridheight = 1;
        panel.add(new JLabel("Fisíca/Jurídica"),gbc);
        JComboBox fj = new JComboBox();
        fj.addItem("F");
        fj.addItem("J");
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(fj,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("CPF/CNPJ"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(new TextField(),gbc);        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Inscrição Estadual"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Telefone"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Email"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Endereco"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Complemento"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("CEP"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Cidade"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(new JLabel("UF"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(new JLabel("Bairro"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 11;
        panel.add(new JLabel("Numero do Endereco"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 12;
        panel.add(new JLabel("Vendedor"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 13;
        panel.add(new JLabel("Transportador"),gbc);
        return panel;
    }
}
