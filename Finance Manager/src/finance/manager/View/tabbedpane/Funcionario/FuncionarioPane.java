/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.View.tabbedpane.Funcionario;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author User
 */
public class FuncionarioPane extends JPanel {
    
    private JSplitPane _sp_main = null;
    
    public FuncionarioPane() {
        super(new BorderLayout());
        createSplitPane();
    }

    private void createSplitPane() {
        _sp_main = new JSplitPane();
        add(_sp_main);
    }
}
