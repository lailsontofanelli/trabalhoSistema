/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChavePrimaria;
 
import java.io.Serializable;
 
public class CodigoPecaPK implements Serializable {
 
    private String codigoPeca;
    //private String engineSerialNumber;
 
    public CodigoPecaPK(){
        // Your class must have a no-arq constructor
    }
 
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CodigoPecaPK){
            CodigoPecaPK carPk = (CodigoPecaPK) obj;
 
            if(!carPk.getCodigoPeca().equals(codigoPeca)){
                return false;
            }
            
            return true;
        }
 
        return false;
    }
 
    @Override
    public int hashCode() {
        return codigoPeca.hashCode() + codigoPeca.hashCode();
    }
 
    public String getCodigoPeca() {
        return codigoPeca;
    }
 
    public void setCodigoPeca(String codigoPeca) {
        this.codigoPeca = codigoPeca;
    }
 
}
