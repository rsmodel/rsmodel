/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View;

import finance.manager.View.ComponentFactory.AbstractComponentFactory;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class ComponentStorage {

    private HashMap<String, JComponent> _component = new HashMap<>();
    
    public ComponentStorage(){
    }
    
    public JComponent addComponent(String name, JComponent comp) {
        _component.put(name, comp);
        return comp;
    }
    
    public JComponent addComponent(String name, AbstractComponentFactory acf) {
        _component.put(name,acf.buildComponent());
        return _component.get(name);
    }
    
    public JTextField getJTextField(String name) {
        return (JTextField)_component.get(name);
    }
    
    public JComboBox<String> getJComboBox(String name) {
        return (JComboBox<String>) _component.get(name);
    }
    
    public JTable getJTable(String name) {
        return (JTable) _component.get(name);
    }

    public JComponent getJComponent(String name) {
        return _component.get(name);
    }
}
