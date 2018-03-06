/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class TabbedPaneTabCloseButton implements ActionListener{

    private final String _tab;

    public TabbedPaneTabCloseButton(String tab) {
        _tab = tab;
    }
    
    public void actionPerformed(ActionEvent e) {
        TabbedPaneManager.getInstance().removePanel(_tab);
   }
    
}
