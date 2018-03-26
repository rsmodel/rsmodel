/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Funcionario;

import java.util.Stack;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Rodrigo
 */
public class FuncionarioInfoPaneSaxHandler extends DefaultHandler {

    private final FuncionarioInfoPane _fip;
    private Stack<String> _stack = new Stack<>();
    
    
    public FuncionarioInfoPaneSaxHandler(FuncionarioInfoPane fip) {
        _fip = fip;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
            
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
        System.out.print("End Element ");
        System.out.print(localName);
        System.out.print(qName);
        System.out.println(uri);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("root")) return;
        if(qName.equalsIgnoreCase("variable")) {
            _stack.add(attributes.getValue("name"));            
        }
        if(qName.equalsIgnoreCase("JLabel")) {
            if(attributes.getValue("x") != null) {
                _fip.getCOG().setPos(Integer.parseInt(attributes.getValue("x")), Integer.parseInt(attributes.getValue("y")));                
            }
            _fip.getCS().addComponent(attributes.getValue("name"), new JLabel(attributes.getValue("text")));
            _fip.getCOG().addComponent(_fip.getCS().getJComponent(attributes.getValue("name")));
            return;
        }
        if(qName.equalsIgnoreCase("JTextField")) {
            if(attributes.getValue("x") != null) {
                _fip.getCOG().setPos(Integer.parseInt(attributes.getValue("x")), Integer.parseInt(attributes.getValue("y")));                
            }
            _fip.getCS().addComponent(attributes.getValue("name"), new JTextField());
            _fip.getCOG().addComponent(_fip.getCS().getJComponent(attributes.getValue("name")));
            return;
        }
        System.out.print("Start Element ");
        System.out.print(localName);
        System.out.print(qName);
        System.out.println(uri);
        for(int i=0; i< attributes.getLength();++i) {
            System.out.println(attributes.getURI(i));            
            System.out.println(attributes.getLocalName(i));
            System.out.println(attributes.getValue(i));            
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
