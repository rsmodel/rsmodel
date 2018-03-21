/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.Controller.Data;

import finance.manager.View.ComponentStorage;
import java.util.HashMap;
import javax.swing.JComponent;

/**
 *
 * @author User
 */
public interface LinkAction {
    public void doFirstToSecond(JComponent comp, String str);
    public void doSecontoToFirst(JComponent comp, String str);
}
