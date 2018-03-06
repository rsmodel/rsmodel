/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager;

import finance.manager.View.MainFrame;
import finance.manager.model.DatabaseManager;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class FinanceManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DatabaseManager.getInstance().addSqliteDatabase("teste", "teste.db");
        
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }
    
}
