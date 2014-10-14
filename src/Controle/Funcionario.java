/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import ChavePrimaria.CpfPK;
import Modelo.FuncionarioDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author guitonsic
 */
@Entity
@Table (name="funcionario")
@IdClass (value=CpfPK.class)

public class Funcionario implements Serializable {

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
    
    private String cargo;
    
    private double salario;
    
    static List<Funcionario> funcionarios = new ArrayList();

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    
    
    
    public void cadastrarFuncionario(Funcionario P) throws SQLException, ClassNotFoundException {
        FuncionarioDAO.cadastrar(P);
    }

    public void excluirFuncionario(Funcionario P) throws SQLException, ClassNotFoundException {
        FuncionarioDAO.excluir(P);
    }
    
    public void alterarFuncionario(Funcionario P) throws SQLException, ClassNotFoundException {
        FuncionarioDAO.alterar(P);
    }

    public static Collection consultarFuncionario(){
        funcionarios = (List<Funcionario>) FuncionarioDAO.consultarFuncionario();
        return funcionarios;
    }
    public static Collection consultarFuncionarioCpf(String cpf){
        funcionarios = (List<Funcionario>) FuncionarioDAO.consultarFuncionarioCpf(cpf);
        return funcionarios;
    }
    public static Collection consultarFuncionarioNome(String nome){
        funcionarios = (List<Funcionario>) FuncionarioDAO.consultarFuncionarioNome(nome);
        return funcionarios;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        return (this.cpf != null || other.cpf == null) && (this.cpf == null || this.cpf.equals(other.cpf));
    }

    @Override
    public String toString() {
        return "Modelo.Funcionario[ id=" + cpf + " ]";
    }

}
