/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane;

import java.awt.GridLayout;
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
       
    
    private TabbedPaneManager() {
        _tabbedPane = new JTabbedPane();
        
        JComponent panel1 = makeTextPanel("Panel #1");
        _tabbedPane.addTab("Init", panel1); 
        
    }
    
    public void addTabbedPane(JFrame frame) {
        frame.add(_tabbedPane);
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