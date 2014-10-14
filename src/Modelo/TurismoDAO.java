/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.Conexao;
import Controle.Turismo;
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
import javax.swing.JOptionPane;

/**
 *
 * @author harada
 */
public class TurismoDAO {

    static String status = "";
    
    Connection con = Conexao.conexao();
    static List<Turismo> viagem = new ArrayList();
    
    public static void cadastrar(Turismo F) throws SQLException {
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

    
    public static void excluir(Turismo C) throws SQLException {
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
    
    public static void alterar(Turismo F) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.merge(F);
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro ao alterar a viagem: " + se.getMessage());
        }
    }

    public static Collection consultar(){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Turismo e");
            viagem = query.getResultList();
            return viagem;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar a Viagem: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Viagem: " + se.getMessage());
        }
        return viagem;
        
    }
    /*
    public static Collection consultar(String cpf){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Turismo e where e.cpf='" + cpf +"'");
            turismo = query.getResultList();
            return turismo;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o viagem: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Motoristas: " + se.getMessage());
        }
        return turismo;
    }
    */
    public static Collection consultarViagemCodigo(int Codigo){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Turismo e where e.Codigo='" + Codigo + "'");
            viagem = query.getResultList();
            return viagem;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar a viagem: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar a viagem: " + se.getMessage());
        }
        return viagem;
    }
    
        public static Collection consultarViagemDestino(String DestCidad){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Turismo e where e.DestCidad='" + DestCidad + "'");
            viagem = query.getResultList();
            return viagem;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar a viagem: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar a viagem: " + se.getMessage());
        }
        return viagem;
    }
    
        public static void atualizar(Turismo C) throws SQLException {
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
