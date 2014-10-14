/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Visao.Inicial;
import Visao.Sistema;
import java.sql.SQLException;

/**
 *
 * @author guitonsic
 */
public class TLTransportes {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Pessoa P = new Pessoa();
        
        
       Inicial i = new Inicial();
       i.setVisible(true);
       i.setLocationRelativeTo(null);
        //PessoaDAO.consultar();
    }
    
}
