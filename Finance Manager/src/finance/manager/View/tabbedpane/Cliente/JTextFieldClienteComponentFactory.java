/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Cliente;

import finance.manager.View.ComponentFactory.AbstractComponentFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class JTextFieldClienteComponentFactory implements AbstractComponentFactory{
    
    
    public JTextFieldClienteComponentFactory(){
    }
    
    
    @Override
    public JComponent buildComponent() {
        JTextField tf = new JTextField();
        tf.setEditable(false);
        return tf;
    }
    
}
