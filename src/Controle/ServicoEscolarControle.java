/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.ServicoEscolarDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lailson-pc
 */
@Entity
public class ServicoEscolarControle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String placaVeiculo;
    private String cpfMotorista;
    private String periodo;
    private boolean banco = true;

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

    public String getCpfMotorista() {
        return cpfMotorista;
    }

    public void setCpfMotorista(String cpfMotorista) {
        this.cpfMotorista = cpfMotorista;
    }

    public boolean isBanco() {
        return banco;
    }

    public void setBanco(boolean banco) {
        this.banco = banco;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    static List<ServicoEscolarControle> servico = new ArrayList();
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicoEscolarControle)) {
            return false;
        }
        ServicoEscolarControle other = (ServicoEscolarControle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controle.ServicoEscolar[ id=" + id + " ]";
    }
    
    //// MÉTODOS DE INSERIR, ALTERAR, EXCLUIR, CONSULTAR
    
    public void cadastrarServico(ServicoEscolarControle S) throws SQLException, ClassNotFoundException, Exception {
        ServicoEscolarDAO.cadastrar(S);
    }

    public void excluirServicoEscolar(ServicoEscolarControle S) throws SQLException, ClassNotFoundException {
        ServicoEscolarDAO.excluir(S);
    }
    
    public void alterarServico(ServicoEscolarControle S) throws SQLException, ClassNotFoundException {
        ServicoEscolarDAO.alterar(S);
    }
    
    public static Collection consultarServico(){
        servico = (List<ServicoEscolarControle>) ServicoEscolarDAO.consultarEscolar();
        return servico;
    }
    
}
