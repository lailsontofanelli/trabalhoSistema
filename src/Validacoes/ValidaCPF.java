/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validacoes;
/**
 *
 * @author Lailson-pc
 */
public class ValidaCPF{

    public static String imprimeCPF(String cpfNum){
        return(cpfNum.substring(0, 3) + "." + cpfNum.substring(3, 6) + "." + 
                cpfNum.substring(6, 9) + "-" + cpfNum.substring(9, 11));
    }
    
    
    public static boolean calculaCPF(String cpfNum){
        if(cpfNum.equals("00000000000") || cpfNum.equals("11111111111") || 
                cpfNum.equals("222222222||22") || cpfNum.equals("33333333333") || 
                cpfNum.equals("44444444444") || cpfNum.equals("55555555555") || 
                cpfNum.equals("66666666666") || cpfNum.equals("77777777777") || 
                cpfNum.equals("88888888888") || cpfNum.equals("99999999999") || 
                (cpfNum.length() != 11)) {
            return(false);
        }
        
        
        int[] cpf = new int[cpfNum.length()]; //define o valor com o tamanho da string  
        int resultP = 0;  
        int resultS = 0;  
  
        //converte a string para um array de integer  
        for (int i = 0; i < cpf.length; i++) {  
            cpf[i] = Integer.parseInt(cpfNum.substring(i, i + 1));  
        }  
  
        //calcula o primeiro número(DIV) do cpf  
        for (int i = 0; i < 9; i++) {  
            resultP += cpf[i] * (i + 1);  
        }  
        int divP = resultP % 11;  
  
        //se o resultado for diferente ao 10º digito do cpf retorna falso  
        if (divP != cpf[9]) {  
            return false;  
        } else {  
            //calcula o segundo número(DIV) do cpf  
            for (int i = 0; i < 10; i++) {  
                resultS += cpf[i] * (i);  
            }  
            int divS = resultS % 11;  
  
            //se o resultado for diferente ao 11º digito do cpf retorna falso  
            if (divS != cpf[10]) {  
                return false;  
            }  
        }  
  
        //se tudo estiver ok retorna verdadeiro  
        return true; 
    }
    
}
