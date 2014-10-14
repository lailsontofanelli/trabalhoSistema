/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.GastoGeralDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JOptionPane;

/**
 *
 * @author Lailson-pc
 */
@Entity
public class GastoGeral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String data;
    private double valor;
    private String tipo;
    
    static List<GastoGeral> gasto = new ArrayList();
    //static List<GastoGeral> datas = new ArrayList();
    //ArrayList datas = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastoGeral)) {
            return false;
        }
        GastoGeral other = (GastoGeral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controle.GastoGeral[ id=" + id + " ]";
    }
    
    
    
    
    public void cadastrarGastoGeral(GastoGeral G) throws SQLException, ClassNotFoundException, Exception {
        GastoGeralDAO.cadastrar(G);
    }
    
    public static Collection consultarGastoGeral(){
        gasto = (List<GastoGeral>) GastoGeralDAO.consultar();
        return gasto;
    }
    public static Collection consultarGastoTipo(String tip){
        gasto = (List<GastoGeral>) GastoGeralDAO.consultarTipo(tip);
        return gasto;
    }
    
    public static Collection consultarGastoData(String data){
        gasto = (List<GastoGeral>) GastoGeralDAO.consultarData(data);
        return gasto;
    }
    
    public double retornaGastoMes(String data){
        
        String mes = data.substring(3, 5);
        ArrayList datas;// = new ArrayList();
        datas = new ArrayList(GastoGeral.consultarGastoData(mes));
        
        double total = 0;
        for (int i=0; i<datas.size(); i++){
            GastoGeral g = (GastoGeral)datas.get(i);
            double val = g.getValor();
            total = total + val;
        }
        return total;
    }
}
