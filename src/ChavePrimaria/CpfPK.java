/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChavePrimaria;
 
import java.io.Serializable;
 
public class CpfPK implements Serializable {
 
    private String cpf;
    //private String engineSerialNumber;
 
    public CpfPK(){
        // Your class must have a no-arq constructor
    }
 
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CpfPK){
            CpfPK carPk = (CpfPK) obj;
 
            if(!carPk.getCpf().equals(cpf)){
                return false;
            }
            
            return true;
        }
 
        return false;
    }
 
    @Override
    public int hashCode() {
        return cpf.hashCode() + cpf.hashCode();
    }
 
    public String getCpf() {
        return cpf;
    }
 
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
 
}
