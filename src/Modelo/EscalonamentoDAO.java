/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controle.Conexao;
import Controle.EscalonamentoMotorista;
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
public class EscalonamentoDAO {
    
    
    static String status = "";
    Connection con = Conexao.conexao();
    static List<EscalonamentoMotorista> escalonamento = new ArrayList();

    public static void cadastrar(EscalonamentoMotorista E) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.persist(E);
            tran.commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void excluir(EscalonamentoMotorista E) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            //C = em.find(Pecas.class,);  
            E = em.merge(E);
            em.remove(E);
            em.flush();
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro: " + se.getMessage());
        }
    }
    
   public static void alterar(EscalonamentoMotorista E) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.merge(E);
            em.flush();
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro:" + se.getMessage());
        }
    }

    public static Collection consultar(){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM EscalonamentoMotorista e");
            escalonamento = query.getResultList();
            return escalonamento;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Funcionario: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Funcionarios: " + se.getMessage());
        }
        return escalonamento;
    }
    
}
