/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;
import Controle.Conexao;
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

public class VeiculoDAO {

    static String status = "";
    Connection con = Conexao.conexao();
    static List<Veiculo> veiculos = new ArrayList();
    
    public static void cadastrar(Veiculo C) throws SQLException {
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

    public static void excluir(Veiculo C) throws SQLException {
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
    
    public static void alterar(Veiculo C) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.merge(C);
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro ao alterar o veiculo: " + se.getMessage());
        }
    }
    // AQUI COMEÇA A PARTE DE CONSULTAS ------------------------------------------------------------------------------------
    public static Collection consultar() {
        //List<Veiculo> veiculos;
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Veiculo e");
            veiculos = query.getResultList();
            return veiculos;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o veículo: " + se.getMessage());
        }
        return veiculos;
    }
    
    public static Collection consultarPlaca(String placa) {
        //List<Veiculo> veiculos;
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Veiculo e where e.placa='" + placa + "'");
            veiculos = query.getResultList();
            return veiculos;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar o veículo: " + se.getMessage());
        }
        return veiculos;
    }
    // FIM CONSULTAS ---------------------------------------------------------------------------------------------------
   
    
}
