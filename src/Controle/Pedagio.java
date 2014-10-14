/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.PedagioDAO;
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
 * @author Guilherme
 */
@Entity
public class Pedagio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cidade;
    
    private String estado;
    
    private double valor;
    
    private int numero;

    static List<Pedagio> pedagios = new ArrayList();
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void cadastrarPedagio(Pedagio P) throws SQLException, ClassNotFoundException, Exception {
        PedagioDAO.cadastrar(P);
    }

    public void excluirPedagio(Pedagio P) throws SQLException, ClassNotFoundException {
        PedagioDAO.excluir(P);
    }

    public void alterarPedagio(Pedagio P) throws SQLException, ClassNotFoundException {
        PedagioDAO.alterar(P);
    }

    public static Collection consultarPedagio() {
        pedagios = (List<Pedagio>) PedagioDAO.consultarPedagio();
        return pedagios;
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
        if (!(object instanceof Pedagio)) {
            return false;
        }
        Pedagio other = (Pedagio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controle.Pedagio[ id=" + id + " ]";
    }
    
}
