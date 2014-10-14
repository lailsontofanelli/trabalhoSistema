/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;


import ChavePrimaria.CodigoPecaPK;
import ChavePrimaria.CpfPK;
import Modelo.PecasDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author Guilherme
 */
@Entity
@IdClass (value=CodigoPecaPK.class)
public class Pecas implements Serializable {
    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/
    
    private String nomePeca;
    
    private String tipoPeca;
    
    @Id
    private String codigoPeca;
    
    private double valorPeca;
    
    private int quantidade;
    
    static List<Pecas> pecas = new ArrayList();

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public String getTipoPeca() {
        return tipoPeca;
    }

    public void setTipoPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public String getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(String codigoPeca) {
        this.codigoPeca = codigoPeca;
    }

    public double getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(double valorPeca) {
        this.valorPeca = valorPeca;
    }
    
    public void cadastrarPeca(Pecas P) throws SQLException, ClassNotFoundException, Exception {
        PecasDAO.cadastrar(P);
    }

    public void excluirPeca(Pecas P) throws SQLException, ClassNotFoundException {
        PecasDAO.excluir(P);
    }
    
    public void alterarPeca(Pecas P) throws SQLException, ClassNotFoundException {
        PecasDAO.alterar(P);
    }

    public void atualizarPeca(Pecas P) throws SQLException, ClassNotFoundException {
        PecasDAO.atualizar(P);
    }
    
    public static Collection consultarPeca(){
        pecas = (List<Pecas>) PecasDAO.consultar();
        return pecas;
    }
    
    public static Collection consultarPecaCodigo(String codigo){
        pecas = (List<Pecas>) PecasDAO.consultarCodigo(codigo);
        return pecas;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPeca != null ? codigoPeca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pecas)) {
            return false;
        }
        Pecas other = (Pecas) object;
        if ((this.codigoPeca == null && other.codigoPeca != null) || (this.codigoPeca != null && !this.codigoPeca.equals(other.codigoPeca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Pecas[ id=" + codigoPeca + " ]";
    }
    
}
