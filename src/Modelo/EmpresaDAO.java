/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Controle.ClienteTurismo;
import Controle.Conexao;
import Controle.Empresa;
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
 * @author Lailson
 */
public class EmpresaDAO {
    
    static String status = "";
    Connection con = Conexao.conexao();
    static List<Empresa> empresa = new ArrayList();
    
    public static void cadastrar(Empresa E) throws SQLException {
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
    

    public static void alterar(Empresa E) throws SQLException {
        try {
            EntityManagerFactory fac = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager em = fac.createEntityManager();
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.merge(E);
            tran.commit();
            em.close();
        } catch (Exception se) {
            throw new SQLException("Erro ao alterar a empresa: " + se.getMessage());
        }
    }
    
    public static Collection consultar(){
       try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TLTransportesPU");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery("SELECT e FROM Empresa e");
            empresa = query.getResultList();
            return empresa;
        } catch (Exception se) {
            String status = ("Erro ao pesquisar a Empresa: " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Funcionarios: " + se.getMessage());
        }
        return empresa;
    }
    
}
