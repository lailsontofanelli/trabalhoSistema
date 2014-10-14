/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controle.Conexao;
import Controle.ManutencaoControle;
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

/**
 *
 * @author Lailson-pc
 */
public class ManutencaoDAO {
    
    static String status = "";
    Connection con = Conexao.conexao();
    static List<ManutencaoControle> manut = new ArrayList();
    
    public static void cadastrar(ManutencaoControle M) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.persist(M);
            tran.commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Collection consultar() {
        //List<Veiculo> veiculos;
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM ManutencaoControle e");
            manut = query.getResultList();
            return manut;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar Manutenções: " + se.getMessage());
        }
        return manut;
    }
    
    public static Collection consultarTipo(String placa) {
        //List<Veiculo> veiculos;
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM ManutencaoControle e where e.placaVeiculo='" + placa + "'");
            manut = query.getResultList();
            return manut;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar Gastos Gerais:  " + se.getMessage());
        }
        return manut;
    }
    
    public static Collection consultarData(String data) {
        //List<Veiculo> veiculos;
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM ManutencaoControle e where e.data like '___" + data + "_____'");
            manut = query.getResultList();
            return manut;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar Gastos Gerais:  " + se.getMessage());
        }
        return manut;
    }
    
}
