/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conetaBanco;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author bene
 */
public class ConectaMysql {
    private static  String url = "jdbc:mysql://localhost:3306/biblioteca";
   // private static  String url = "jdbc:mysql://localhost:3306/cadastro";
    private static  String user = "root";
    private static  String password = "jsbach";
    private static  Connection con;
    private static String  driver = "com.mysql.jdbc.Driver";
    
    public ConectaMysql(){
        con = null;
        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url,user,password);
            if(con != null){
                con.setAutoCommit(false);
          //  JOptionPane.showMessageDialog(null,"Conectado com sucesso!");
            }
        
        
        }catch(Exception e){
            e.printStackTrace();
              JOptionPane.showMessageDialog(null,"falha de conexão!");
        }
       
    }
     
        public Connection getConnection(){
         return con;   
        }
        public  void desconectar(){
            con = null;
            if( con ==null){
                JOptionPane.showMessageDialog(null,"conexão terminada..");
            }
        }
    
}
