/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager;

import finance.manager.View.MainFrame;
import finance.manager.model.GlobalDataVendedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class FinanceManager {

    
   public static Connection con = null;
   public static Statement stm = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
/*        try {
            // TODO code application logic here

            Class.forName("org.firebirdsql.jdbc.FBDriver");
            con =
            DriverManager.getConnection(
               "jdbc:firebirdsql:localhost/3050:E:/SISTEMA.FDB",
               "sysdba",
               "masterkey");
            stm = con.createStatement();
            ResultSet res = stm.executeQuery("select * from PRODUTOS");
            while (res.next()) {
                System.out.println(res.getString("DESCRICAO"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinanceManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           Logger.getLogger(FinanceManager.class.getName()).log(Level.SEVERE, null, ex);
       }
  */      
        GlobalDataVendedor.getInstance();
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }
    
}
