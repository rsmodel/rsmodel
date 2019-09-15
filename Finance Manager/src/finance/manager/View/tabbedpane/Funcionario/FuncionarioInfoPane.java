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
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Rodrigo
 */
public class FuncionarioInfoPane extends JPanel{
    
    private ComponentStorage _cs = null;
    private ComponentOrganizerGridBag _cog = null;
    
    public FuncionarioInfoPane() {
        super(new GridBagLayout());
        init();
    }

    private void init() {
        GridBagConstraints gbc = new GridBagConstraints();
        JTextFieldClienteComponentFactory cliente_factory = new JTextFieldClienteComponentFactory();
        _cog = new ComponentOrganizerGridBag(this, gbc);
        _cog.setAnchor(GridBagConstraints.PAGE_START);
        _cog.setFill(GridBagConstraints.HORIZONTAL);
        _cog.setPad(200, 0);
        _cs = new ComponentStorage();
        SAXParserFactory factory = SAXParserFactory.newInstance();		
        SAXParser sax;
        try {
            sax = factory.newSAXParser();

            sax.parse(new File("./Panels/funcionarioInfoPanel.xml"), new FuncionarioInfoPaneSaxHandler(this)); // o "this" indica que a própria
	} catch (ParserConfigurationException | SAXException | IOException e) {
            StringBuffer msg = new StringBuffer();
            msg.append("Erro:\n");
            msg.append(e.getMessage() + "\n");
            msg.append(e.toString());
            System.out.println(msg);
        }
    }
    
    public ComponentStorage getCS() {
        return _cs;
    }
    
    public ComponentOrganizerGridBag getCOG() {
        return _cog;
    }
}
