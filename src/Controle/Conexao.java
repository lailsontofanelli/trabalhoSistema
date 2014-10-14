/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {
    public static String usuario_logado;

    public static String getUsuario_logado() {
        return usuario_logado;
    }

    public static void setUsuario_logado(String usuario_logado) {
        Conexao.usuario_logado = usuario_logado;
    }
    
    public static Statement stm;
    public static ResultSet rs;
    
    private static final String driver = /*"org.mysql.Driver";*/ "com.mysql.jdbc.Driver";//identifica qual banco estou usando
    private static final String caminho = "jdbc:postgresql://localhost:5432/TLTransportesPU"; //"jdbc:mysql://localhost:3306/TLTransportesPU";//caminho do banco
    private static final String usuario = "postgres"; //root";//usuario do banco
    private static final String senha = "admin"; //"admin";//senha do usuario do banco
    public  static Connection conn = null;//objeto conn para efetuar a conexão com o banco
    
    public static Connection conexao(){//metodo responsabel por realisar a conexao com o banco
        try {
            System.setProperty("jdcb.Drivers", driver);//seta a propriedade do driver de conexao
            //Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(caminho,usuario,senha);//realisa a conexao com o banco
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro!\n Error:"+ex.getMessage());
       }
        return conn;
    }
    
    public void desconecta(){//metodo para fechar a conexão com o banco
       try {
           conn.close();
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao fechar!\n Error:"+ex.getMessage());
       }
    }
    
    public void executaSQL(String sql){//metodo para executar consutas no banco
                                       //o parametro serve para passar o que quer consultar do banco
       try {
           stm = conn.createStatement();
           rs = stm.executeQuery(sql);
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"ERRO ao executar!\n Error:"+ex.getMessage());
       }
        
    }        

           
}

