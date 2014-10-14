/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controle.ClienteTurismo;
import Controle.Conexao;
import Controle.Login;
import Controle.Veiculo;
//import Modelo.LoginBanco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class LoginDAO {
    
     static List<Login> login = new ArrayList();
    
    public static void cadastrar(Login L) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.persist(L);
            tran.commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Login> buscarLogin() throws SQLException {
        ArrayList<Login> LAUX = new ArrayList<Login>();
        try {
            Connection conexao = Conexao.conexao();
            Statement state = conexao.createStatement();
            String sql = "select * from LOGIN";
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                Login l = new Login();
                l.setLogin(rs.getString("login"));
                l.setSenha(rs.getString("senha"));
                LAUX.add(l);
            }

        } catch (SQLException se) {
            throw new SQLException("Erro ao localizar os dados: " + se.getMessage());
        }
        return LAUX;
    }
    
    public static Collection consultarLogin(String log, String senha){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Login e where e.login='" + log + "' AND e.senha='" + senha + "'");
            login = query.getResultList();
            return login;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Motorista: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao iniciar o sistema: " + se.getMessage());
        }
        return login;
    }
    
}
