/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controle.Conexao;
import Controle.ServicoEscolarControle;
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
public class ServicoEscolarDAO {
    static String status = "";
    Connection con = Conexao.conexao();
    static List<ServicoEscolarControle> servico = new ArrayList();
    
    public static void cadastrar(ServicoEscolarControle S) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.persist(S);
            tran.commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Collection consultarEscolar(){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM ServicoEscolarControle e");
            servico = query.getResultList();
            return servico;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Servico: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Motoristas: " + se.getMessage());
        }
        return servico;
    }
    
    public static void excluir(ServicoEscolarControle S) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            //C = em.find(Pecas.class,);  
            S = em.merge(S);
            em.remove(S);
            em.flush();
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro ao excluir o Serviço: " + se.getMessage());
        }
    }
    
    public static void alterar(ServicoEscolarControle S) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.merge(S);
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro ao alterar o serviço: " + se.getMessage());
        }
    }
}
