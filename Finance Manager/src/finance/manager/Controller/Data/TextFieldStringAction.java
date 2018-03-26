/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.Controller.Data;

import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Rodrigo
 */
public class TextFieldStringAction implements LinkAction{

    @Override
    public void doFirstToSecond(JComponent comp, String str) {
        str.replaceAll(str, ((JTextField)comp).getText());
    }

    @Override
    public void doSecontoToFirst(JComponent comp, String str) {
        ((JTextField)comp).setText(str);
    }
    
}
