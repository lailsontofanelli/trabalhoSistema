/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.Conexao;
import Controle.Funcionario;
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
public class FuncionarioDAO {
    
    static String status = "";
    Connection con = Conexao.conexao();
    static List<Funcionario> funcionarios = new ArrayList();

    public static void cadastrar(Funcionario F) throws SQLException {
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

    public static void excluir(Funcionario C) throws SQLException {
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
    
    public static void alterar(Funcionario F) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.merge(F);
            List<Funcionario> pe;
            Query qe = em.createQuery("from Veiculo where nome='" + F.getNome() + "'");
            pe = qe.getResultList();
            for (Funcionario p : pe) {
                System.out.println("ID Veiculo: " + p.getCpf());
            }
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro ao excluir o cliente: " + se.getMessage());
        }
    }

    public static Collection consultarFuncionario(){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Funcionario e");
            funcionarios = query.getResultList();
            return funcionarios;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Funcionario: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Funcionarios: " + se.getMessage());
        }
        return funcionarios;
    }
    public static Collection consultarFuncionarioCpf(String cpf){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Funcionario e where e.cpf='" + cpf + "'");
            funcionarios = query.getResultList();
            return funcionarios;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Funcionario: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Funcionarios: " + se.getMessage());
        }
        return funcionarios;
    }
    public static Collection consultarFuncionarioNome(String nome){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Funcionario e where e.nome='" + nome + "'");
            funcionarios = query.getResultList();
            return funcionarios;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Funcionario: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Funcionarios: " + se.getMessage());
        }
        return funcionarios;
    }
}
