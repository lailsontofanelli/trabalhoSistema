/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import static Controle.ClienteTurismo.turista;
import Modelo.ClienteTurismoDAO;
import Modelo.TurismoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Date.*;
import java.util.*;
import java.text.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
/*
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
*/

/**
 *
 * @author harada
 */
@Entity
@Table(name="Turismo")
public class Turismo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codigo;
   
    private String NomeViagem;
    private String DestCidad;
    private String Estado;
    private String Endereco;
    private String nEndereco;   
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DataPart; 
    
    private int HoraPart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DataVolta;
    
    private int HoraVolta;
    private int TempoVi;
    private int Distancia;   
    private int Rota;   
    private int TaxaEmp;    
    private double Valor;  
    private String RespViagem; 
    private String Veiculo;  
    private String Motorista;
    static List<ClienteTurismo> passageiros = new ArrayList();
    
    static List<Turismo> viagem = new ArrayList();
           
    public String getNomeViagem() {
        return NomeViagem;
    }

    public void setNomeViagem(String NomeViagem) {
        this.NomeViagem = NomeViagem;
    }
   
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getDestCidad() {
        return DestCidad;
    }

    public void setDestCidad(String DestCidad) {
        this.DestCidad = DestCidad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public String getEndereco() {
        return Endereco;
        
    }
    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }
    
    public String getnEndereco() {
        return nEndereco;
        
    }
    public void setnEndereco(String nEndereco) {
        this.nEndereco = nEndereco;
    }

    public Date getDataPart() {
        return DataPart;
    }

    public void setDataPart(Date DataPart) {
        this.DataPart = DataPart;
    }

    public int getHoraPart() {
        return HoraPart;
    }
    
    public void setHoraPart(int HoraPart){
        this.HoraPart = HoraPart;
    }
    
        public Date getDataVolta() {
        return DataVolta;
    }
    
    public void setDataVolta(Date DataVolta) {
        this.DataVolta = DataVolta;
    }
    
    public int getHoraVolta() {
        return HoraVolta;
    }
    
    public void setHoraVolta(int HoraVolta) {
        this.HoraVolta = HoraVolta;
    }
    
    public int getDistancia() {
        return Distancia;
    }

    public void setDistancia(int Distancia) {
        this.Distancia = Distancia;
    }
    
    public int getTempoVi() {
        return TempoVi;
    }

    public void setTempoVi(int TempoVi) {
        this.TempoVi = TempoVi;
    }
    
    public int getRota() {
        return Rota;
    }
    
    public void setRota(int Rota) {
        this.Rota = Rota;
    }
    
    public int getTaxaEmp() {
        return TaxaEmp;
    }
    
    public void setTaxaEmp(int TaxaEmp) {
        this.TaxaEmp = TaxaEmp;
    }
    
    public double getValor() {
        return Valor;
    }
    
    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public static List<ClienteTurismo> getPassageiros() {
        return passageiros;
    }

    public static void setPassageiros(List<ClienteTurismo> passageiros) {
        Turismo.passageiros = passageiros;
    }

    public static List<Turismo> getViagem() {
        return viagem;
    }

    public static void setViagem(List<Turismo> viagem) {
        Turismo.viagem = viagem;
    }

   
    public String getRespViagem() {
        return RespViagem;
    }
    
    public void setRespViagem(String RespViagem) {
        this.RespViagem = RespViagem;
    }
    
    public String getVeiculo() {
        return Veiculo;
    }
    
    public void setVeiculo(String veiculo) {
        this.Veiculo = veiculo;
    }
    
    public String getMotorista() {
        return Motorista;
    }
    
    public void setMotorista(String Motorista) {
        this.Motorista = Motorista;
    }
    
    public void cadastrarViagem(Turismo P) throws SQLException, ClassNotFoundException, Exception {
        TurismoDAO.cadastrar(P);
    }

    public void excluirViagem(Turismo P) throws SQLException, ClassNotFoundException {
        TurismoDAO.excluir(P);
    }
    
    public void alterarViagem(Turismo P) throws SQLException, ClassNotFoundException {
        TurismoDAO.alterar(P);
    }


   public static Collection consultarViagemCodigo(int Codigo){
        viagem = (List<Turismo>) TurismoDAO.consultarViagemCodigo(Codigo);
        return viagem;
    }
   
  public static Collection consultarViagemDestino(String DestCidad){
        viagem = (List<Turismo>) TurismoDAO.consultarViagemDestino(DestCidad);
        return viagem;
    }

    
    public void atualizarTurismo(Turismo P) throws SQLException, ClassNotFoundException {
        TurismoDAO.atualizar(P);
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turismo)) {
            return false;
        }
        return true;
        
    }
}
