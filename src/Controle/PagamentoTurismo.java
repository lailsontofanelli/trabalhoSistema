/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.PagamentoTurismoDAO;
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
public class PagamentoTurismo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private String idViagem;
    private double valor;
    private int parcelas;
    private int parcelasPaga;
    private String data;
    
    static List<PagamentoTurismo> pagamento = new ArrayList();

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

    public String getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(String idViagem) {
        this.idViagem = idViagem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public int getParcelasPaga() {
        return parcelasPaga;
    }

    public void setParcelasPaga(int parcelasPaga) {
        this.parcelasPaga = parcelasPaga;
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
        if (!(object instanceof PagamentoTurismo)) {
            return false;
        }
        PagamentoTurismo other = (PagamentoTurismo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controle.PagamentoTurismo[ id=" + id + " ]";
    }
    
    public void cadastrarPagamento(PagamentoTurismo P) throws SQLException, ClassNotFoundException {
        PagamentoTurismoDAO.cadastrar(P);
    }
    
    public void pagamentoParcela(PagamentoTurismo P) throws SQLException, ClassNotFoundException {
        PagamentoTurismoDAO.pagamentoParcela(P);
    }
    
    public static Collection consultarPagamento(){
        pagamento = (List<PagamentoTurismo>) PagamentoTurismoDAO.consultar();
        return pagamento;
    }
    
    public static Collection consultarPagamentoEfetuado(String cpf, String data){
        pagamento = (List<PagamentoTurismo>) PagamentoTurismoDAO.consultarPagEfetuado(cpf, data);
        return pagamento;
    }

    public static Collection consultarPagamentoData(String data){
        pagamento = (List<PagamentoTurismo>) PagamentoTurismoDAO.consultarData(data);
        return pagamento;
    }
}
