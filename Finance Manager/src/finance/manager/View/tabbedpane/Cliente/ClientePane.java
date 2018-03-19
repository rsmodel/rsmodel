/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Cliente;

import finance.manager.View.ComponentOrganizerGridBag;
import finance.manager.View.ComponentStorage;
import finance.manager.model.GlobalDataCliente;
import finance.manager.model.data.ClienteData;
import java.awt.BorderLayout;
import java.awt.Component;
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

    ComponentStorage _cs = new ComponentStorage();
    private JTable _table = null;
    private JSplitPane _sp_mainpane = null;
    private JScrollPane _sp_table = null;
    private JPanel _panel = null;
    
    private int _selected_line = 0;
    
    public ClientePane() {
        super(new BorderLayout());
        
        createSplitPane();
        
    }

    private void createTable() {
        _table = new JTable(new ClienteTableColumnModel());
        _table.setColumnSelectionAllowed(false);
        _table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        _table.getSelectionModel().addListSelectionListener(this);
        _table.setCellEditor(null);
        _sp_table = new JScrollPane(_table);
        _sp_table.setMinimumSize(new Dimension(300,0));
        
   }
    
    private void createSecondPanel() {
        _panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        ComponentOrganizerGridBag cog = new ComponentOrganizerGridBag(_panel, gbc);
        cog.setAnchor(GridBagConstraints.PAGE_START);
        cog.setFill(GridBagConstraints.HORIZONTAL);
        cog.setPad(200, 0);
        // Física / Júridica 
        cog.addComponentPos(new JLabel("Fisíca/Jurídica"), 0, 0);
        _cs.addComponent("fj", new JComboBox<String>());
        _cs.getJComboBox("fj").addItem("F");
        _cs.getJComboBox("fj").addItem("J");       
        cog.addComponentPos(_cs.getJComboBox("fj"),1,0);
        // CPF CNPJ
        cog.addComponentPos(new JLabel("CPF/CNPJ"),0,1);
        _cs.addComponent("cpf_cnpj", new JTextField());
        cog.addComponentPos(_cs.getJTextField("cpf_cnpj"), 1, 1);
        // Inscrição Estadual
        cog.addComponentPos(new JLabel("Inscrição Estadual"),0,2);
        _cs.addComponent("ie", new JTextField());
        cog.addComponentPos(_cs.getJTextField("ie"), 1, 2);
        //Telefone
        cog.addComponentPos(new JLabel("Telefone"), 0, 3);
        _cs.addComponent("fone", new JTextField());
        cog.addComponentPos(_cs.getJTextField("fone"), 1, 3);
        /// --- EMAIL
        cog.addComponentPos(new JLabel("E-mail"), 0, 4);
        _cs.addComponent("email", new JTextField());
        cog.addComponentPos(_cs.getJTextField("email"), 1, 4);
        // Endereço
        cog.addComponentPos(new JLabel("Endereco"), 0, 5);
        _cs.addComponent("endereco", new JTextField());
        cog.addComponentPos(_cs.getJTextField("endereco"), 1, 5);
        // Complemento
        cog.addComponentPos(new JLabel("Complemento"), 0, 6);
        _cs.addComponent("complemento", new JTextField());
        cog.addComponentPos(_cs.getJTextField("complemento"), 1, 6);
        // CEP
        cog.addComponentPos(new JLabel("CEP"), 0, 7);
        _cs.addComponent("cep", new JTextField());
        cog.addComponentPos(_cs.getJTextField("cep"), 1, 7);
        // Cidade
        cog.addComponentPos(new JLabel("Cidade"), 0, 8);
        _cs.addComponent("cidade", new JTextField());
        cog.addComponentPos(_cs.getJTextField("cidade"), 1, 8);
        // UF
        cog.addComponentPos(new JLabel("UF"), 0, 9);
        _cs.addComponent("uf", new JTextField());
        cog.addComponentPos(_cs.getJTextField("uf"), 1, 3);
        // Bairro
        cog.addComponentPos(new JLabel("Bairro"), 0, 10);
        _cs.addComponent("bairro", new JTextField());
        cog.addComponentPos(_cs.getJTextField("bairro"), 1, 10);
        // Numero de Endereço
        cog.addComponentPos(new JLabel("Numero do Endereco"), 0, 11);
        _cs.addComponent("num", new JTextField());
        cog.addComponentPos(_cs.getJTextField("num"), 1, 11);
        // Vendedor
        cog.addComponentPos(new JLabel("Vendedor"), 0, 12);
        _cs.addComponent("vendedor", new JTextField());
        cog.addComponentPos(_cs.getJTextField("vendedor"), 1, 12);
        // Transportador
        cog.addComponentPos(new JLabel("Transportador"), 0, 13);
        _cs.addComponent("transportador", new JTextField());
        cog.addComponentPos(_cs.getJTextField("transportador"), 1, 13);
        //fim
        _panel.setMinimumSize(new Dimension(300,0));
        
    }

    private void createSplitPane() {
        createTable();
        createSecondPanel();
        _sp_mainpane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                _sp_table,
                _panel);
        _panel.setVisible(false);
        this.add(_sp_mainpane, BorderLayout.CENTER);
        
        
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(_selected_line ==  ((Integer)_table.getValueAt(_table.getSelectedRow(), 0))) 
            return;
        _selected_line = ((Integer)_table.getValueAt(_table.getSelectedRow(), 0));
        if(!_panel.isVisible()) {
            _panel.setVisible(true);
            _sp_mainpane.setDividerLocation(0.25f);
        }
        ClienteData c = GlobalDataCliente.getInstance().getCliente(_selected_line);
        if(c.getF_j()== "F") 
            _cs.getJComboBox("fj").setSelectedIndex(0);
        else
            _cs.getJComboBox("fj").setSelectedIndex(1);
        _cs.getJTextField("cpf_cnpj").setText(c.getCPF_CNPJ());
        _cs.getJTextField("ie").setText(c.getInscrição_estadual());
        _cs.getJTextField("fone").setText(c.getFone());
        _cs.getJTextField("email").setText(c.getEmail());
        _cs.getJTextField("endereco").setText(c.getEndereco());
        _cs.getJTextField("complemento").setText(c.getComplemento());
        _cs.getJTextField("cep").setText(c.getCEP());
        _cs.getJTextField("cidade").setText(c.getCidade());
        _cs.getJTextField("uf").setText(c.getUf());
        _cs.getJTextField("bairro").setText(c.getBairro());
        _cs.getJTextField("num").setText(c.getNum_endereco());
        _cs.getJTextField("vendedor").setText(String.valueOf(c.getVendedor()));
        _cs.getJTextField("transportador").setText(String.valueOf(c.getTransportador()));
        
        System.out.print("Selected: ");
        System.out.println(_table.getValueAt(_table.getSelectedRow(), 0));
      }

}
