/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Validacoes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lailson-pc
 */
public class ValidaPlaca {
    
    public static boolean calculaPlaca(String placa){
        
        Pattern pattern = Pattern.compile("[a-zA-Z]{3,3}-\\d{4,4}");
        Matcher matcher = pattern.matcher(placa);
 
        if( matcher.find() ){
            //System.out.println("Encontrou");
            return true;
        }else{
            //System.out.println("Não encontrou");
            return false;
        }
    }
    
}
