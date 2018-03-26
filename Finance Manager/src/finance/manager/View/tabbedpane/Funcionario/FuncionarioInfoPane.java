/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Funcionario;

import finance.manager.View.ComponentOrganizerGridBag;
import finance.manager.View.ComponentStorage;
import finance.manager.View.tabbedpane.Cliente.JTextFieldClienteComponentFactory;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.xml.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Rodrigo
 */
public class FuncionarioInfoPane extends JPanel{
    
    private ComponentStorage _cs = null;
    
    public FuncionarioInfoPane() {
        super(new GridBagLayout());
        init();
    }

    private void init() {
        GridBagConstraints gbc = new GridBagConstraints();
        JTextFieldClienteComponentFactory cliente_factory = new JTextFieldClienteComponentFactory();
        ComponentOrganizerGridBag cog = new ComponentOrganizerGridBag(this, gbc);
        cog.setAnchor(GridBagConstraints.PAGE_START);
        cog.setFill(GridBagConstraints.HORIZONTAL);
        cog.setPad(200, 0);
        
        SAXParser sax;
    }
    
}
