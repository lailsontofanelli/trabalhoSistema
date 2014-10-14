/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;
import ChavePrimaria.CpfPK;
import Modelo.MotoristaDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

@Entity
@Table (name = "Motorista")
@IdClass (value=CpfPK.class)

public class Motorista implements Serializable {

    
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
    
    private double salario;
    
    private int numHabilitacao;
    
    private String tipoHabilitacao;
    
    static List<Motorista> motoristas = new ArrayList();

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getNumHabilitacao() {
        return numHabilitacao;
    }

    public void setNumHabilitacao(int numHabilitacao) {
        this.numHabilitacao = numHabilitacao;
    }
    
    public String getTipoHabilitacao() {
        return tipoHabilitacao;
    }

    public void setTipoHabilitacao(String tipoHabilitacao) {
        this.tipoHabilitacao = tipoHabilitacao;
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

    public void cadastrarMotorista(Motorista P) throws SQLException, ClassNotFoundException {
        MotoristaDAO.cadastrar(P);
    }

    public void excluirMotorista(Motorista P) throws SQLException, ClassNotFoundException {
        MotoristaDAO.excluir(P);
    }
    
    public void alterarMotorista(Motorista P) throws SQLException, ClassNotFoundException {
        MotoristaDAO.alterar(P);
    }
    
    public static Collection consultarMotorista(){
        motoristas = (List<Motorista>) MotoristaDAO.consultarMotorista();
        return motoristas;
    }
    public static Collection consultarMotoristaCpf(String cpf){
        motoristas = (List<Motorista>) MotoristaDAO.consultarMotoristaCpf(cpf);
        return motoristas;
    }
    public static Collection consultarMotoristaNome(String nome){
        motoristas = (List<Motorista>) MotoristaDAO.consultarMotoristaNome(nome);
        return motoristas;
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
        if (!(object instanceof Motorista)) {
            return false;
        }
        Motorista other = (Motorista) object;
        return (this.cpf != null || other.cpf == null) && (this.cpf == null || this.cpf.equals(other.cpf));
    }

    @Override
    public String toString() {
        return "Modelo.Motorista[ id=" + cpf + " ]";
    }
    
    
}
