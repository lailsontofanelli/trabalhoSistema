/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controle.Conexao;
import Controle.PassEscolar;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Lailson-pc
 */
public class PassEscolarDAO {
    
    static String status = "";
    Connection con = Conexao.conexao();
    static List<PassEscolar> passageiros = new ArrayList();
    
    public static void cadastrar(PassEscolar P) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.persist(P);
            tran.commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Collection consultarPass(String id){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM PassEscolar e where e.idServico='" + id + "'");
            passageiros = query.getResultList();
            return passageiros;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Serviço: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o Serviço: " + se.getMessage());
        }
        return passageiros;
    }
    
    public static void excluir(PassEscolar P) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            //C = em.find(Pecas.class,);  
            P = em.merge(P);
            em.remove(P);
            em.flush();
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro ao excluir o Serviço: " + se.getMessage());
        }
    }
    
    public static void alterar(PassEscolar F) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.merge(F);
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro ao excluir o cliente: " + se.getMessage());
        }
    }
    
}   
