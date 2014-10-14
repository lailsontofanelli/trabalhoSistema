/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.Conexao;
import Controle.Motorista;
import Controle.Veiculo;
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
 * @author guitonsic
 */
public class MotoristaDAO {

    static String status = "";
    Connection con = Conexao.conexao();
    static List<Motorista> motoristas = new ArrayList();
    
    public static void cadastrar(Motorista F) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.persist(F);
            tran.commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void excluir(Motorista C) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            //C = em.find(Pecas.class,);  
            C = em.merge(C);
            em.remove(C);
            em.flush();
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro ao excluir o cliente: " + se.getMessage());
        }
    }
    
    public static void alterar(Motorista F) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.merge(F);
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro ao alterar o cliente: " + se.getMessage());
        }
    }

    public static Collection consultarMotorista(){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Motorista e");
            motoristas = query.getResultList();
            return motoristas;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Motorista: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Motoristas: " + se.getMessage());
        }
        return motoristas;
    }
    public static Collection consultarMotoristaCpf(String cpf){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Motorista e where e.cpf='" + cpf +"'");
            motoristas = query.getResultList();
            return motoristas;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Motorista: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Motoristas: " + se.getMessage());
        }
        return motoristas;
    }
    public static Collection consultarMotoristaNome(String nome){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Motorista e where e.nome='" + nome + "'");
            motoristas = query.getResultList();
            return motoristas;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Motorista: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Motoristas: " + se.getMessage());
        }
        return motoristas;
    }
}
