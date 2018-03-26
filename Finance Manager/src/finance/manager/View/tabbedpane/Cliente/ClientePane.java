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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
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
        JTextFieldClienteComponentFactory cliente_factory = new JTextFieldClienteComponentFactory();
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
        _cs.getJComboBox("fj").setEnabled(false);
        // CPF CNPJ
        cog.addComponentPos(new JLabel("CPF/CNPJ"),0,1);
        cog.addComponentPos(
                _cs.addComponent("cpf_cnpj", cliente_factory), 1, 1);
        // Inscrição Estadual
        cog.addComponentPos(new JLabel("Inscrição Estadual"),0,2);        
        cog.addComponentPos(
                _cs.addComponent("ie", cliente_factory), 1, 2);
        //Telefone
        cog.addComponentPos(new JLabel("Telefone"), 0, 3);        
        cog.addComponentPos(
                _cs.addComponent("fone", cliente_factory), 1, 3);
        /// --- EMAIL
        cog.addComponentPos(new JLabel("E-mail"), 0, 4);        
        cog.addComponentPos(
                _cs.addComponent("email", cliente_factory), 1, 4);
        // Endereço
        cog.addComponentPos(new JLabel("Endereco"), 0, 5);        
        cog.addComponentPos(
                _cs.addComponent("endereco", cliente_factory), 1, 5);
        // Complemento
        cog.addComponentPos(new JLabel("Complemento"), 0, 6);        
        cog.addComponentPos(
                _cs.addComponent("complemento", cliente_factory), 1, 6);
        // CEP
        cog.addComponentPos(new JLabel("CEP"), 0, 7);        
        cog.addComponentPos(
                _cs.addComponent("cep", cliente_factory), 1, 7);
        // Cidade
        cog.addComponentPos(new JLabel("Cidade"), 0, 8);        
        cog.addComponentPos(
                _cs.addComponent("cidade", cliente_factory), 1, 8);
        // UF
        cog.addComponentPos(new JLabel("UF"), 0, 9);        
        cog.addComponentPos(
                _cs.addComponent("uf", cliente_factory), 1, 3);
        // Bairro
        cog.addComponentPos(new JLabel("Bairro"), 0, 10);        
        cog.addComponentPos(
                _cs.addComponent("bairro", cliente_factory), 1, 10);
        // Numero de Endereço
        cog.addComponentPos(new JLabel("Numero do Endereco"), 0, 11);
        cog.addComponentPos(
                _cs.addComponent("num", cliente_factory), 1, 11);
        // Vendedor
        cog.addComponentPos(new JLabel("Vendedor"), 0, 12);        
        cog.addComponentPos(
                _cs.addComponent("vendedor", cliente_factory), 1, 12);
        // Transportador
        cog.addComponentPos(new JLabel("Transportador"), 0, 13);        
        cog.addComponentPos(
                _cs.addComponent("transportador", cliente_factory), 1, 13);
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
        
      }

}
