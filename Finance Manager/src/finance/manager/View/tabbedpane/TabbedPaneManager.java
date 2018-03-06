/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author User
 */
public class TabbedPaneManager {

    private static TabbedPaneManager _instance = new TabbedPaneManager();
    
    public static TabbedPaneManager getInstance() {
        return _instance;
    }
    
    private JTabbedPane _tabbedPane = null;
    private HashMap<String, JComponent> _panels = new HashMap<String, JComponent>();   
    
    private TabbedPaneManager() {
        _tabbedPane = new JTabbedPane();
        
        addPane("init", (JPanel) makeTextPanel("Panel #1"));
    }
    
    public void addPane(String name, JPanel panel) {
        if(_panels.containsKey(name)) return;
        _panels.put(name, panel);
        _tabbedPane.addTab(name, panel);
        
    }
    
    public void addTabbedPane(JFrame frame) {
        frame.add(_tabbedPane);
    }
    public boolean hasPanel(String name) {
        return _panels.containsKey(name);
    }
    
    public void removePanel(String name) {
        _tabbedPane.remove(_panels.get(name));
        _panels.remove(name);
    }
    
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

}
