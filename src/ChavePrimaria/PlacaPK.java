/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChavePrimaria;
 
import java.io.Serializable;
 
public class PlacaPK implements Serializable {
 
    private String placa;
    //private String engineSerialNumber;
 
    public PlacaPK(){
        // Your class must have a no-arq constructor
    }
 
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PlacaPK){
            PlacaPK carPk = (PlacaPK) obj;
 
            if(!carPk.getPlaca().equals(placa)){
                return false;
            }
            
            return true;
        }
 
        return false;
    }
 
    @Override
    public int hashCode() {
        return placa.hashCode() + placa.hashCode();
    }
 
    public String getPlaca() {
        return placa;
    }
 
    public void setPlaca(String placa) {
        this.placa = placa;
    }
 
}
