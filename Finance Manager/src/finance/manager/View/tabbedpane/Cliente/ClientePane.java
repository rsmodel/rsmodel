/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Cliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author User
 */
public class ClientePane extends JPanel implements ListSelectionListener {
    
    private JTable _table = null;
    private JScrollPane _sp_table = null;
    private JPanel _panel = null;
    private JComboBox<String> _fj = null;
    private JTextField _tf_cpf_cnpj = null;
    private JTextField _tf_ie = null;
    private JTextField _tf_fone = null;
    private JTextField _tf_email = null;
    private JTextField _tf_endereco = null;
    private JTextField _tf_complemento = null;
    private JTextField _tf_cep = null;
    private JTextField _tf_cidade = null;
    private JTextField _tf_uf = null;
    private JTextField _tf_bairro = null;
    private JTextField _tf_num_end = null;
    private JTextField _tf_vendedor = null;
    private JTextField _tf_transportador = null;
    
    public ClientePane() {
        super(new BorderLayout());
        
        createSplitPane();
        
    }

    private void createTable() {
        _table = new JTable(new ClienteTableColumnModel());
        _table.setColumnSelectionAllowed(false);
        _table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        _table.getSelectionModel().addListSelectionListener(this);
        _sp_table = new JScrollPane(_table);
        _sp_table.setMinimumSize(new Dimension(300,0));
        
   }
    
    private void createSecondPanel() {
        _panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        
        gbc.ipadx = 200;
        //gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        //gbc.gridwidth = 1;
        //gbc.gridheight = 1;
        _panel.add(new JLabel("Fisíca/Jurídica"),gbc);
        _fj = new JComboBox<>();
        _fj.addItem("F");
        _fj.addItem("J");        
        gbc.gridx = 1;
        gbc.gridy = 0;
        _panel.add(_fj,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        _panel.add(new JLabel("CPF/CNPJ"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        _panel.add(new TextField(),gbc);        
        gbc.gridx = 0;
        gbc.gridy = 2;
        _panel.add(new JLabel("Inscrição Estadual"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        _panel.add(new JLabel("Telefone"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        _panel.add(new JLabel("Email"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        _panel.add(new JLabel("Endereco"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        _panel.add(new JLabel("Complemento"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        _panel.add(new JLabel("CEP"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        _panel.add(new JLabel("Cidade"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 9;
        _panel.add(new JLabel("UF"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 10;
        _panel.add(new JLabel("Bairro"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 11;
        _panel.add(new JLabel("Numero do Endereco"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 12;
        _panel.add(new JLabel("Vendedor"),gbc);
        gbc.gridx = 0;
        gbc.gridy = 13;
        _panel.add(new JLabel("Transportador"),gbc);
        _panel.setMinimumSize(new Dimension(300,0));
        
    }

    private void createSplitPane() {
        createTable();
        createSecondPanel();
        JSplitPane sp = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                _sp_table,
                _panel);
        
        
        this.add(sp, BorderLayout.CENTER);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        System.out.print("Selected: ");
        System.out.println(_table.getValueAt(_table.getSelectedRow(), 0));
      }

}
