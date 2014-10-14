/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

import Controle.Funcionario;
import Controle.Motorista;
import Validacoes.ValidaCPF;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lailson
 */
public class ConsFuncionario extends javax.swing.JFrame {

    ArrayList lista = new ArrayList();
    
    /**
     * Creates new form ConsFuncionario
     */
    public ConsFuncionario() {
        initComponents();
        atualizaLista("", "");
    }
    
    private Object getSelectedObject() {
         Object selecionado = null;
         int linhaSelecionada = tabela.getSelectedRow();
         if(linhaSelecionada >= 0){
             selecionado = lista.get(linhaSelecionada);
         }else{
             JOptionPane.showMessageDialog(this, "Selecione um elemento da tabela.");
         }
         return selecionado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        nome_fun = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        excluir = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cpf_fun = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        listacompleta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(115, 117, 118), 3, true));

        jLabel23.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel23.setText("Consultar Funcionários");

        jLabel24.setText("Busca por Nome:");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        alterar.setText("Alterar");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarjButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Busca por CPF:");

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        listacompleta.setText("Lista Completa");
        listacompleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listacompletaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome_fun))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cpf_fun, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listacompleta, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(alterar)
                .addGap(35, 35, 35)
                .addComponent(excluir)
                .addGap(35, 35, 35)
                .addComponent(cancelar)
                .addGap(272, 272, 272))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome_fun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cpf_fun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar)
                    .addComponent(listacompleta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(excluir)
                    .addComponent(alterar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarjButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarjButton2ActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String cpf = cpf_fun.getText();
        String nome = nome_fun.getText();
        if(cpf.length() > 0 && nome.length() > 0){
            JOptionPane.showMessageDialog(this, "Digite em apenas um dos campos de busca.");
            cpf_fun.setText("");
            nome_fun.setText("");
        }else if(cpf.length() < 1 && nome.length() < 1){
            JOptionPane.showMessageDialog(this, "Informe um dos campos de consulta.");
        }else{
            if (cpf.length() > 0){
                if (ValidaCPF.calculaCPF(cpf) == false){
                    JOptionPane.showMessageDialog(this, "CPF inválido.\nDigite um CPF válido formado por 11 números.");
                    cpf_fun.setText("");
                }else{
                    atualizaLista(cpf, "");
                    cpf_fun.setText("");
                    
                }
            }else{
                atualizaLista("", nome);
                nome_fun.setText("");
            }
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void listacompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listacompletaActionPerformed
        // TODO add your handling code here:
        atualizaLista("", "");
    }//GEN-LAST:event_listacompletaActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        // TODO add your handling code here:
        Object o = getSelectedObject();
        if (o != null){
            Funcionario p = (Funcionario)o;
            new CadastrarFuncionario(p, 1).setVisible(true);
        }
    }//GEN-LAST:event_alterarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        // TODO add your handling code here:
        Object o = getSelectedObject();
        if (o != null){
            Funcionario p = (Funcionario)o;
            try {
                p.excluirFuncionario(p);
            } catch (SQLException ex) {
                Logger.getLogger(ConsFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConsFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(rootPane, "Funcionário Excluído.");
        atualizaLista("", "");
    }//GEN-LAST:event_excluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cpf_fun;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JButton listacompleta;
    private javax.swing.JTextField nome_fun;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
    
    private void atualizaLista(String cpf, String nome) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //v = new Veiculo();
        String mensagem = "";
        if (cpf.length() > 0){
            lista = new ArrayList(Funcionario.consultarFuncionarioCpf(cpf));
            mensagem = "Não existem Clientes de Escolar com CPF "+ cpf +" cadastrados.";
        }else if(nome.length() > 0){
            lista = new ArrayList(Funcionario.consultarFuncionarioNome(nome));
            mensagem = "Não existem Clientes de Escolar com nome "+ nome +" cadastrados.";
        }else{
            lista = new ArrayList(Funcionario.consultarFuncionario());
            mensagem = "Não existem Clientes de Escolar cadastrados.";
        }
        String[] nomesColunas = {"Nome", "CPF", "RG", "Endereço", "Nº", "Cidade", "Estado", "Telefone", "Data Nascimento", "Cargo", "Salário"};
        Object[][] dadosVetor = new Object[lista.size()][nomesColunas.length];
        for (int i=0; i<lista.size(); i++){
            Funcionario fun = (Funcionario)lista.get(i);
            //dadosVetor[i][0] = fun.getId();
            dadosVetor[i][0] = fun.getNome();
            dadosVetor[i][1] = fun.getCpf();
            dadosVetor[i][2] = fun.getRg();
            dadosVetor[i][3] = fun.getEndereco();
            dadosVetor[i][4] = fun.getnEndereco();
            dadosVetor[i][5] = fun.getCidade();
            dadosVetor[i][6] = fun.getEstado();
            dadosVetor[i][7] = fun.getTelefone();
            dadosVetor[i][8] = fun.getNascimento();
            dadosVetor[i][9] = fun.getCargo();
            dadosVetor[i][10] = fun.getSalario();
        }
        DefaultTableModel modelo = new DefaultTableModel(dadosVetor,nomesColunas);
        tabela.setModel(modelo);
        if(lista.isEmpty()){
            JOptionPane.showMessageDialog(this, mensagem);
        }

    }
}