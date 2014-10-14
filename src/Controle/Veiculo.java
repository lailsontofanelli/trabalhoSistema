/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import ChavePrimaria.PlacaPK;
import Modelo.VeiculoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.*;
import javax.persistence.Temporal;


/**
 *
 * @author guitonsic
 */
@Entity
@IdClass (value=PlacaPK.class)
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    @Id
    private String placa;
    private int capacidade;
    private int ano;
    private String modelo;
    private String cor;
    private String tipo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDisp;
    private double kilometragem;
    static List<Veiculo> veiculos = new ArrayList();

    public double getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(double kilometragem) {
        this.kilometragem = kilometragem;
    }
    
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getDataDisp() {
        return dataDisp;
    }

    public void setDataDisp(Date dataDisp) {
        this.dataDisp = dataDisp;
    }

    public static List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public static void setVeiculos(List<Veiculo> veiculos) {
        Veiculo.veiculos = veiculos;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void cadastrarVeiculo(Veiculo V) throws SQLException, ClassNotFoundException {
        VeiculoDAO.cadastrar(V);
    }
    
    public void excluirVeiculo(Veiculo V) throws SQLException, ClassNotFoundException {
        VeiculoDAO.excluir(V);
    }
    
    public void alterarVeiculo(Veiculo V) throws SQLException, ClassNotFoundException {
        VeiculoDAO.alterar(V);
    }
    
    public static Collection consultarVeiculo(){
        veiculos = (List<Veiculo>) VeiculoDAO.consultar();
        return veiculos;
    }
    
    public static Collection consultarVeiculoPlaca(String placa) {
        veiculos = (List<Veiculo>) VeiculoDAO.consultarPlaca(placa);
        return veiculos;
    }
    
    //public void atualizarVeiculo(Veiculo V) throws SQLException, ClassNotFoundException {
    //    VeiculoDAO.atualizar(V);
    //}
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Veiculo[ id=" + placa + " ]";
    }

}
