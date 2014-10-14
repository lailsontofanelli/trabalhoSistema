/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controle.Conexao;
import Controle.PagamentoTurismo;
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
public class PagamentoTurismoDAO {
    
    static String status = "";
    Connection con = Conexao.conexao();
    static List<PagamentoTurismo> paga = new ArrayList();
    
    public static void cadastrar(PagamentoTurismo P) throws SQLException {
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
    
    public static void pagamentoParcela(PagamentoTurismo P) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.merge(P);
            em.flush();
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro ao efetuar pagamento de parcela: " + se.getMessage());
        }
    }
    
    public static Collection consultar(){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM PagamentoTurismo e");
            paga = query.getResultList();
            return paga;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Pagamento: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Pagamentos: " + se.getMessage());
        }
        return paga;
    }
    public static Collection consultarPagEfetuado(String cpf, String data){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM PagamentoTurismo e where e.cpf='" + cpf +"' AND e.data like '___" + data + "'");
            paga = query.getResultList();
            return paga;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Pagamento: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Pagamentos: " + se.getMessage());
        }
        return paga;
    }
    public static Collection consultarData(String data){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM PagamentoTurismo e where e.data like '___" + data + "'");
            paga = query.getResultList();
            return paga;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Pagamento: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Pagamentos: " + se.getMessage());
        }
        return paga;
    }
}
