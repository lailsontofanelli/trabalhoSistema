/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.CombustivelDAO;
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
public class CombustivelControle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double valor;
    private int litros;
    private String data;
    
    static List<CombustivelControle> comb = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        if (!(object instanceof CombustivelControle)) {
            return false;
        }
        CombustivelControle other = (CombustivelControle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controle.CombustivelControle[ id=" + id + " ]";
    }
    
    public void cadastrarCombustivel(CombustivelControle C) throws SQLException, ClassNotFoundException, Exception {
        CombustivelDAO.cadastrar(C);
    }
    
    public static Collection consultarComb(){
        comb = (List<CombustivelControle>) CombustivelDAO.consultar();
        return comb;
    }
    
    public static Collection consultarCombData(String date){
        comb = (List<CombustivelControle>) CombustivelDAO.consultarData(date);
        return comb;
    }
  
    public double retornaGastoMes(String data){
        
        String mes = data.substring(3, 5);//10);
        ArrayList datas;// = new ArrayList();
        datas = new ArrayList(CombustivelControle.consultarCombData(mes));
        
        double total = 0;
        for (int i=0; i<datas.size(); i++){
            CombustivelControle c = (CombustivelControle)datas.get(i);
            double val = c.getValor();
            total = total + val;
        }
        return total;
    }
        
//    public static void main(String[] args) {
//        CombustivelControle g = new CombustivelControle();
//        
//        String data = JOptionPane.showInputDialog("Digite uma data");
//        
//        g.retornaGastoMes(data);
//    }

}
