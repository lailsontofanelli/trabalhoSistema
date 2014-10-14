/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import ChavePrimaria.CpfPK;
import Modelo.EscalonamentoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author Lailson-pc
 */
@Entity
@Table(name="escalonamentoMotorista")
@IdClass (value=CpfPK.class)
public class EscalonamentoMotorista implements Serializable {
    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cpf;

    public Long getId() {
        return cpf;
    }

    public void setId(Long id) {
        this.cpf = id;
    }*/
    @Id
    private String cpf;
    private String periodo1 = "0";
    private String periodo2 = "0";

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPeriodo1() {
        return periodo1;
    }

    public void setPeriodo1(String periodo1) {
        this.periodo1 = periodo1;
    }

    public String getPeriodo2() {
        return periodo2;
    }

    public void setPeriodo2(String periodo2) {
        this.periodo2 = periodo2;
    }
    
    static List<Motorista> listaMotorista = new ArrayList();
    static List<ServicoEscolarControle> listaEscolar = new ArrayList();
    static List<Turismo> listaTurismo = new ArrayList();
    static List<EscalonamentoMotorista> listaEscalona = new ArrayList();
    static List<EscalonamentoMotorista> pesquisa = new ArrayList();
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscalonamentoMotorista)) {
            return false;
        }
        EscalonamentoMotorista other = (EscalonamentoMotorista) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controle.EscalonamentoMotorista[ id=" + cpf + " ]";
    }
    
    
    public boolean dataMaior(String data1, String data2) throws ParseException{
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        
        
        Date dataP = d.parse(data1);
        Date dataV = d.parse(data2);
        
        
        if(dataP.getTime() > dataV.getTime()){
            return true;
            //System.out.println("é maior");
        }
        return false;
    }

    public Collection escalonaMotorista(String servico, String periodo, String novaPartida, String novaVolta) throws ParseException{
        listaMotorista = new ArrayList(Motorista.consultarMotorista()); // lista dos motoristas
        listaEscolar = new ArrayList(ServicoEscolarControle.consultarServico()); // lista dos serviços escolares
        //listaTurismo = new ArrayList(Turismo.consultarViagem()); // listas dos serviços de turismo
        listaEscalona = new ArrayList(EscalonamentoDAO.consultar()); // lista dos serviços escolares, lista dos periodos
        
        
        String msg = "";
        
        /// TIPO DO SERVICO == TURISMO ================================================================
        
        if(servico == "Turismo"){
            for(int i=0; i<listaMotorista.size(); i++){
                Motorista motorista = (Motorista)listaMotorista.get(i);
                int j = 0;
                while(j < listaEscalona.size()){
                    EscalonamentoMotorista escalonamento = (EscalonamentoMotorista)listaEscalona.get(i);
                    if (motorista.getCpf() == escalonamento.getCpf()){
                        j = listaEscalona.size();
                        listaMotorista.remove(i);
                    }else{
                        j = j + 1;
                    }
                }
            }
            if(listaMotorista.isEmpty()){
                msg = "Não existem motoristas disponiveis, estão no transporte escolar.";
                return listaMotorista;
            }
            for(int i=0; i<listaMotorista.size(); i++){ // ver se tem algum motorista sem viagens marcadas
                Motorista motorista = (Motorista)listaMotorista.get(i);
                int j = 0;
                while (j < listaTurismo.size()){
                    Turismo turismo = (Turismo)listaTurismo.get(i);
                    if(motorista.getCpf() == turismo.getMotorista()){
                        j = listaMotorista.size();
                        listaMotorista.remove(i);
                    }else{
                        j = j + 1;
                    }
                }
            }if(listaMotorista.isEmpty()){ // todos os motoristas tem viagens marcadas
                // ver se para a data solicitada da viagem, não tem outra viagem na data
                // se nao tiver uma viagem na data que solicitou, retorna motorista
                for(int i=0; i < listaTurismo.size(); i++){
                    Motorista motorista = new Motorista();
                    Turismo turismo = (Turismo)listaTurismo.get(i);
                    String velhaVolta = Integer.toString(turismo.getDataVolta());
                    
                    if(dataMaior(novaPartida, velhaVolta)){
                        motorista.setCpf(turismo.getMotorista());
                        boolean pode = true;
                            for(int j=0; j<listaMotorista.size(); j++){
                                Motorista mot = (Motorista)listaMotorista.get(j);
                                if(motorista.getCpf() == mot.getCpf()){
                                    pode = false;
                                }
                            }if(pode == true){
                                listaMotorista.add(motorista);
                            }
                    }else{ // novaPartida < velhaVolta
                        String velhaPartida = Integer.toString(turismo.getDataPart());
                        if(dataMaior(velhaPartida, novaVolta)){
                            motorista.setCpf(turismo.getMotorista());
                            boolean pode = true;
                            for(int j=0; j<listaMotorista.size(); j++){
                                Motorista mot = (Motorista)listaMotorista.get(j);
                                if(motorista.getCpf() == mot.getCpf()){
                                    pode = false;
                                }
                            }if(pode == true){
                                listaMotorista.add(motorista);
                            }
                        }else{
                            for (int h=0; h < listaMotorista.size(); h++){
                                Motorista motoristaNovo = (Motorista)listaMotorista.get(h);
                                if(motoristaNovo.getCpf() == motorista.getCpf()){
                                    listaMotorista.remove(h);
                                }
                            }
                        }
                    }
                }return listaMotorista;// se esta lista esta vazia, informando que na data escolhida nao tem
                // motorista disponivel.
            }else{ // existe motorista sem viagens marcadas
                return listaMotorista;
                // estou dando prioridade pra adicionar no serviço o motorista que nao estiver trabalhando
            }
         
        ////// TIPO DO SERVIÇO == ESCOLAR =====================================================================
            
        }else{//if(servico == "Escolar"){
            for (int i=0; i<listaMotorista.size(); i++){
                Motorista motorista = (Motorista)listaMotorista.get(i);
                int j = 0;
                while(j < listaEscalona.size()){
                    EscalonamentoMotorista escalona = (EscalonamentoMotorista)listaEscalona.get(i);
                    if(motorista.getCpf() == escalona.getCpf()){
                        if(escalona.getPeriodo1() == "0"){
                            //System.out.println("nao vou remover pq ele pode trabalhar em qq periodo");
                        }else{ // escalona.getPeriodo1() != 0
                            if(escalona.periodo2 == "0"){
                                if(escalona.getPeriodo1() == periodo){
                                    listaEscalona.remove(j);
                                    msg = "Neste período não tem motoristas disponíveis";
                                }
                            }else{
                                listaEscalona.remove(j);
                                msg = "Não há motoristas disponiveis";
                            }
                        }
                    }
                }
            }
            return listaMotorista;
//            if (!listaEscalona.isEmpty()){
//                for (int i=0; i<listaEscalona.size(); i++){
//                    EscalonamentoMotorista escalona = (EscalonamentoMotorista)listaEscalona.get(i);
//                    int j = 0;
//                    while(j < listaTurismo.size()){
//                        Turismo turismo = (Turismo)listaTurismo.get(i);
//                        if(escalona.cpf == turismo.getMotorista()){
//                            listaEscalona.remove(i);
//                        }
//                        j = j + 1;
//                    }
//                }if(listaEscalona.isEmpty()){
//                    // lista esta vazia ==> nao tem motoristas disponiveis 
//                    return listaEscalona;
//                }
//            }
        }
        //return null;
    }
    
    public void cadastrarEscalonamento(EscalonamentoMotorista E) throws SQLException, ClassNotFoundException {
        EscalonamentoDAO.cadastrar(E);
    }

    public void excluirEscalonamento(EscalonamentoMotorista E) throws SQLException, ClassNotFoundException {
        EscalonamentoDAO.excluir(E);
    }
    
    public void alterarEscalonamento(EscalonamentoMotorista E) throws SQLException, ClassNotFoundException {
        EscalonamentoDAO.alterar(E);
    }

    public static Collection consultarEscalonamento(){
        pesquisa = (List<EscalonamentoMotorista>) EscalonamentoDAO.consultar();
        return pesquisa;
    }
    
}
