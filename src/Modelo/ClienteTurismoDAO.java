/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

//import Modelo.Conexao;
import Controle.ClienteTurismo;
import Controle.Conexao;
import java.sql.Connection;
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

public class ClienteTurismoDAO {
    
    static String status = "";
    Connection con = Conexao.conexao();
    static List<ClienteTurismo> turista = new ArrayList();
    
    
    public static void cadastrar(ClienteTurismo C) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.persist(C);
            tran.commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void excluir(ClienteTurismo C) throws SQLException {
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
    
    public static void alterar(ClienteTurismo C) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.merge(C);
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro ao excluir o cliente: " + se.getMessage());
        }
    }

    public static Collection consultarTurista(){
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM ClienteTurismo e");
            turista = query.getResultList();
            return turista;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Cliente: " + se.getMessage());
        }
        return turista;
    }
    public static Collection consultarTuristaCpf(String cpf){
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM ClienteTurismo e where e.cpf='" + cpf + "'");
            turista = query.getResultList();
            return turista;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Cliente: " + se.getMessage());
        }
        return turista;
    }
    public static Collection consultarTuristaNome(String nome){
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM ClienteTurismo e where e.nome='" + nome + "'");
            turista = query.getResultList();
            return turista;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o Cliente: " + se.getMessage());
        }
        return turista;
    }
        
    

    public static void atualizar(ClienteTurismo C) throws SQLException {
        try {
            try (Connection conexao = Conexao.conexao()) {
                Statement state = conexao.createStatement();
                //String sql = "update pessoa set nome='" + C.getNome() + "', rg=" + C.getRg() + ", cpf=" + C.getCpf() + ", idade=" + C.getIdade() + ", telefone=" + C.getTelefone() + ", endereco='" + C.getEndereco() + "', nEndereco=" + C.getnEndereco()+ ", cidade='" + C.getCidade() + "', uf='" + C.getUf() + ", servico='" + C.getServico() + "' where codCliente=" + C.getId()+ "";
                //state.execute(sql);
                state.close();
            }
        } catch (SQLException se) {
            throw new SQLException("Erro ao atualizar o cliente: " + se.getMessage());
        }
    }
}
