/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.PassEscolarDAO;
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
public class PassEscolar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private String idServico;
    static List<PassEscolar> passageiros = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdServico() {
        return idServico;
    }

    public void setIdServico(String idServico) {
        this.idServico = idServico;
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
        if (!(object instanceof PassEscolar)) {
            return false;
        }
        PassEscolar other = (PassEscolar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controle.PassEscolar[ id=" + id + " ]";
    }
    
    
    // metodo cadastrar
    
    public void cadastrarPass(PassEscolar P) throws SQLException, ClassNotFoundException, Exception {
        PassEscolarDAO.cadastrar(P);
    }
    
    public static Collection consultarPassageiros(String id){
        passageiros = (List<PassEscolar>) PassEscolarDAO.consultarPass(id);
        return passageiros;
    }
    
    public void excluirPassageiro(PassEscolar S) throws SQLException, ClassNotFoundException {
        PassEscolarDAO.excluir(S);
    }
    
    public void alterarPass(PassEscolar S) throws SQLException, ClassNotFoundException {
        PassEscolarDAO.alterar(S);
    }
    
}
