
package Utilitarios1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class Conexao {
   public Statement stm;

    
    public ResultSet rs;
   
   private String driver="com.mysql.jdbc.Driver";//responsavelo por identificar qual BD se trabalha
   private String caminho="jdbc:mysql://localhost/datashow";
   private String usuario="root";
   private String senha="";
   public Connection con;
   
public void conexao(){
    
       try {
           System.setProperty("jdbc.Drivers",driver);
           con=DriverManager.getConnection(caminho,usuario,senha);
          // JOptionPane.showMessageDialog(null,"Conectado com sucesso");
       } catch (SQLException ex) {
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro de conexão\n Erro:"+ex.getMessage());
       }
}

public void executaSQL(String sql){
       try {
           stm=con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            
            rs = stm.executeQuery(sql);
       } catch (SQLException ex) {
           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,"Erro no ExecutaSQL\n Erro:"+ex.getMessage());
       }
}




public void desconecta(){
    try {
          con.close();
          JOptionPane.showMessageDialog(null,"Desconectado com sucesso");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao fechar a conexão\n Erro:"+ex.getMessage());
       }
}
}
