/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.PagamentoEscolarDAO;
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
public class PagamentoEscolar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private double valor;
    private String data;
    
    static List<PagamentoEscolar> pagamento = new ArrayList();

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagamentoEscolar)) {
            return false;
        }
        PagamentoEscolar other = (PagamentoEscolar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controle.Pagamento[ id=" + id + " ]";
    }
    
    public void cadastrarPagamento(PagamentoEscolar P) throws SQLException, ClassNotFoundException {
        PagamentoEscolarDAO.cadastrar(P);
    }
    
    public static Collection consultarPagamento(){
        pagamento = (List<PagamentoEscolar>) PagamentoEscolarDAO.consultar();
        return pagamento;
    }
    
    public static Collection consultarPagamentoEfetuado(String cpf, String data){
        pagamento = (List<PagamentoEscolar>) PagamentoEscolarDAO.consultarPagEfetuado(cpf, data);
        return pagamento;
    }

    public static Collection consultarPagamentoData(String data){
        pagamento = (List<PagamentoEscolar>) PagamentoEscolarDAO.consultarData(data);
        return pagamento;
    }
}
