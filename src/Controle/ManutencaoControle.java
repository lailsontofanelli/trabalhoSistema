/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.ManutencaoDAO;
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
public class ManutencaoControle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String placaVeiculo;
    private double valor;
    private String data;
    private String descricao;
    
    static List<ManutencaoControle> manut = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof ManutencaoControle)) {
            return false;
        }
        ManutencaoControle other = (ManutencaoControle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controle.ManutencaoControle[ id=" + id + " ]";
    }
    
    public void cadastrarManutencao(ManutencaoControle M) throws SQLException, ClassNotFoundException, Exception {
        ManutencaoDAO.cadastrar(M);
    }
    
    public static Collection consultarManutencao(){
        manut = (List<ManutencaoControle>) ManutencaoDAO.consultar();
        return manut;
    }
    public static Collection consultarManutPlaca(String tip){
        manut = (List<ManutencaoControle>) ManutencaoDAO.consultarTipo(tip);
        return manut;
    }
    
    public static Collection consultarManutData(String date){
        manut = (List<ManutencaoControle>) ManutencaoDAO.consultarData(date);
        return manut;
    }

    
    public double retornaGastoMes(String data){
        
        String mes = data.substring(3, 5);
        ArrayList datas;// = new ArrayList();
        datas = new ArrayList(ManutencaoControle.consultarManutData(mes));
        
        double total = 0;
        for (int i=0; i<datas.size(); i++){
            ManutencaoControle m = (ManutencaoControle)datas.get(i);
            double val = m.getValor();
            total = total + val;
        }
        return total;
    }
}
