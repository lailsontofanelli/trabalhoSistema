/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Validacoes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;

/**
 *
 * @author Lailson-pc
 */
public class ValidaData {
    
    public static boolean calculaData(String dateStr){          
        try{
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
            Calendar cal = new GregorianCalendar();  
  
                // gerando o calendar  
            cal.setTime(df.parse(dateStr));  
  
                // separando os dados da string para comparacao e validacao  
            String[] data = dateStr.split("/");  
            String dia = data[0];  
            String mes = data[1];  
            String ano = data[2];  
  
                // testando se hah discrepancia entre a data que foi  
                // inserida no caledar e a data que foi passada como  
                // string. se houver diferenca, a data passada era  
                // invalida  
            if ( (new Integer(dia)).intValue() != (new  
                Integer(cal.get(Calendar.DAY_OF_MONTH))).intValue() ) {  
                System.out.println("dia nao casou");   
                return(false);  
            } else if ( (new Integer(mes)).intValue() != (new  
                Integer(cal.get(Calendar.MONTH)+1)).intValue() ) {  
                System.out.println("mes nao casou  ");
                return(false);  
            } else if ( (new Integer(ano)).intValue() != (new  
                Integer(cal.get(Calendar.YEAR))).intValue() ) {  
                System.out.println("ano nao casou");  
                return(false);  
            }  
  
            return(true);
        }catch(ParseException e){
            //JOptionPane.showMessageDialog(null, "Data incorreta.\nDigite uma data do  'dd/mm/aaaa'.");
        }catch(NumberFormatException e){
            
        }
        return false;
    }  
}
