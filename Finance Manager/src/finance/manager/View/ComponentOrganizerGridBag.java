/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View;

import java.awt.Component;
import java.awt.GridBagConstraints;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class ComponentOrganizerGridBag {
    private JPanel _panel = null;
    private GridBagConstraints _gbc = null;
    
    public ComponentOrganizerGridBag(JPanel panel,GridBagConstraints gbc) {
        _panel = panel;
        _gbc = gbc;
    }
    
    public void setAnchor(int anchor) {
        _gbc.anchor = anchor;
    }
    
    public void setFill(int fill) {
        _gbc.fill = fill;
    }
    
    public void setPad(int padx, int pady) {
        _gbc.ipadx = padx;
        _gbc.ipady = pady;
    }
    
    public void setGridWidth(int w,int h) {
        _gbc.gridwidth = w;
        _gbc.gridheight = h;
    }
    
    public void setPos(int x, int y) {
        _gbc.gridx = x;
        _gbc.gridy = y;
    }
    
    public void addComponentPos(Component comp, int x, int y) {
        setPos(x, y);
        addComponent(comp);
    }
    
    public void addComponent(Component comp) {
        _panel.add(comp, _gbc);
    }

}
