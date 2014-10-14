/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import ChavePrimaria.CpfPK;
import Modelo.ClienteTurismoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author guitonsic
 */
@Entity
@Table(name="Cliente")
@IdClass (value=CpfPK.class)
public class ClienteTurismo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/
    
    private String nome;

    private int rg;

    @Id
    private String cpf;

    private String endereco;
    
    private int nEndereco;

    private String cidade;

    private String estado;

    private int telefone;

    private String nascimento;
    
    private String Servico;
    
    static List<ClienteTurismo> turista = new ArrayList();
    
    public String getNome() {
        return nome;
    }

    public String getServico() {
        return Servico;
    }

    public void setServico(String Servico) {
        this.Servico = Servico;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getnEndereco() {
        return nEndereco;
    }

    public void setnEndereco(int nEndereco) {
        this.nEndereco = nEndereco;
    }

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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    
    public void cadastrarCliente(ClienteTurismo P) throws SQLException, ClassNotFoundException, Exception {
        ClienteTurismoDAO.cadastrar(P);
    }

    public void excluirCliente(ClienteTurismo P) throws SQLException, ClassNotFoundException {
        ClienteTurismoDAO.excluir(P);
    }
    
    public void alterarCliente(ClienteTurismo P) throws SQLException, ClassNotFoundException {
        ClienteTurismoDAO.alterar(P);
    }

    public static Collection consultarTurista(){
        turista = (List<ClienteTurismo>) ClienteTurismoDAO.consultarTurista();
        return turista;
    }
    public static Collection consultarTuristaCpf(String cpf){
        turista = (List<ClienteTurismo>) ClienteTurismoDAO.consultarTuristaCpf(cpf);
        return turista;
    }
    public static Collection consultarTuristaNome(String nome){
        turista = (List<ClienteTurismo>) ClienteTurismoDAO.consultarTuristaNome(nome);
        return turista;
    }

    public void atualizarCliente(ClienteTurismo P) throws SQLException, ClassNotFoundException {
        ClienteTurismoDAO.atualizar(P);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteTurismo)) {
            return false;
        }
        ClienteTurismo other = (ClienteTurismo) object;
        return (this.cpf != null || other.cpf == null) && (this.cpf == null || this.cpf.equals(other.cpf));
    }

    @Override
    public String toString() {
        return "Modelo.Pessoa[ id=" + cpf + " ]";
    }

}
