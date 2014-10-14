/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controle.Conexao;
import Controle.GastoGeral;
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
public class GastoGeralDAO {
    
    static String status = "";
    Connection con = Conexao.conexao();
    static List<GastoGeral> gasto = new ArrayList();
    
    public static void cadastrar(GastoGeral G) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.persist(G);
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
            Query query = manager.createQuery("SELECT e FROM GastoGeral e");
            gasto = query.getResultList();
            return gasto;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar Gastos Gerais: " + se.getMessage());
        }
        return gasto;
    }
    
    public static Collection consultarTipo(String tip) {
        //List<Veiculo> veiculos;
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM GastoGeral e where e.tipo='" + tip + "'");
            gasto = query.getResultList();
            return gasto;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar Gastos Gerais:  " + se.getMessage());
        }
        return gasto;
    }
    public static Collection consultarData(String data) {
        //List<Veiculo> veiculos;
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM GastoGeral e where e.data like '___" + data + "_____'");
            gasto = query.getResultList();
            return gasto;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar Gastos Gerais:  " + se.getMessage());
        }
        return gasto;
    }
}
