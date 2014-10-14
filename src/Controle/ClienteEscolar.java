/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;
import ChavePrimaria.CpfPK;
import Modelo.ClienteEscolarDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="Escolar")
@IdClass (value=CpfPK.class)
public class ClienteEscolar implements Serializable {
    
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
    
    private String servico;
     
    private double mensalidade;
    
    private String nomeEscola;
    
    private String nomeResponsavel;
    
    private String cpfResponsavel;
    
    static List<ClienteEscolar> escolares = new ArrayList();

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }
    
    public String getNome() {
        return nome;
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

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }
    
    public void cadastrarCliente(ClienteEscolar P) throws SQLException, ClassNotFoundException, Exception {
        ClienteEscolarDAO.cadastrar(P);
    }

    public void excluirCliente(ClienteEscolar P) throws SQLException, ClassNotFoundException {
        ClienteEscolarDAO.excluir(P);
    }
    
    public void alterarCliente(ClienteEscolar P) throws SQLException, ClassNotFoundException {
        ClienteEscolarDAO.alterar(P);
    }
    
    public static Collection consultarEscolar(){
        escolares = (List<ClienteEscolar>) ClienteEscolarDAO.consultarEscolar();
        return escolares;
    }
    public static Collection consultarEscolarCpf(String cpf){
        escolares = (List<ClienteEscolar>) ClienteEscolarDAO.consultarEscolarCpf(cpf);
        return escolares;
    }
    public static Collection consultarEscolarNome(String nome){
        escolares = (List<ClienteEscolar>) ClienteEscolarDAO.consultarEscolarNome(nome);
        return escolares;
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
        if (!(object instanceof ClienteEscolar)) {
            return false;
        }
        ClienteEscolar other = (ClienteEscolar) object;
        return (this.cpf != null || other.cpf == null) && (this.cpf == null || this.cpf.equals(other.cpf));
    }

    @Override
    public String toString() {
        return "Modelo.ClienteEscolar[ id=" + cpf + " ]";
    }
    
}
