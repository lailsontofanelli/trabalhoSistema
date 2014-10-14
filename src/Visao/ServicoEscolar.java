/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

//import Controle.ClienteEscolar;
import Controle.ClienteEscolar;
import Controle.EscalonamentoMotorista;
import Controle.Motorista;
import Controle.PassEscolar;
import Controle.ServicoEscolarControle;
import Controle.Veiculo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lailson-pc
 */
public class ServicoEscolar extends javax.swing.JFrame {
    
    ArrayList listaVeiculo = new ArrayList();
    ArrayList listaMotorista = new ArrayList();
    ArrayList listaPas = new ArrayList();
    ArrayList listaPasExcluir = new ArrayList();
    //ArrayList listaVeioPas = new ArrayList();
    Long idAtual;
    
    ArrayList listaEscalona = new ArrayList();
    
    private ServicoEscolarControle s;
    private int controlador;

    /**
     * Creates new form ServicoEscolar
     */
    public ServicoEscolar() {
        initComponents();
        atualiza();
    }
    public ServicoEscolar(ServicoEscolarControle s, int controlador, ArrayList listaAlterar){
        initComponents();
        if (s != null){
            for(int i=0; i<listaAlterar.size(); i++){
                PassEscolar pas = (PassEscolar)listaAlterar.get(i);
                ClienteEscolar cli = new ClienteEscolar();
                cli.setCpf(pas.getCpf());
                cli.setNome(pas.getNome());
                this.listaPas.add(cli);
                //this.listaPasExcluir.add(cli);
            }
            this.idAtual = s.getId();
            //this.listaPas = listaAlterar;
            this.s = s;
            this.controlador = controlador;
            preencheEdits();
        }
    }
    public void preencheEdits(){
        atualiza();
        veiculo.setSelectedItem(s.getPlacaVeiculo());
        //mot = mot.substring(mot.length() - 11);
        for (int i=0; i < motorista.getItemCount(); i++){
            String mot = motorista.getItemAt(i).toString();// motorista.getSelectedItem().toString();
            if (mot != "SELECIONE"){
                String mot2 = mot.substring(mot.length() - 11);
                if(mot2 == null ? s.getCpfMotorista() == null : mot2.equals(s.getCpfMotorista())){
                    motorista.setSelectedItem(mot);
                }
            }
        }
        periodo.setSelectedItem(s.getPeriodo());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        veiculo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        motorista = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        periodo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(115, 117, 118), 3, true));

        jLabel19.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel19.setText("Cadastro de Transporte Escolar");

        veiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veiculoActionPerformed(evt);
            }
        });

        jLabel5.setText("Motorista:");

        jLabel6.setText("Veiculo utilizado:");

        motorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motoristaActionPerformed(evt);
            }
        });

        jLabel7.setText("Lista de Escolares:");

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarjButton2ActionPerformed(evt);
            }
        });

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        add.setText("Adicionar e Mostrar Lista");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel1.setText("* obrigatório");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel2.setText("* obrigatório");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel3.setText("* obrigatório");

        jLabel4.setText("Período:");

        periodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "Manhã", "Tarde", "Noite" }));
        periodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator3)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(add)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel3))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(58, 58, 58)
                                                    .addComponent(cancelar))
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(motorista, javax.swing.GroupLayout.Alignment.LEADING, 0, 228, Short.MAX_VALUE)
                                                    .addComponent(veiculo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(periodo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2)))))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(jLabel19)
                            .addGap(75, 75, 75)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(add)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar)
                    .addComponent(cancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        ServicoEscolar esc = new ServicoEscolar();
        
        if(veiculo.getSelectedItem() == "SELECIONE"){
            JOptionPane.showMessageDialog(esc, "Selecione um veiculo.");
            return;
        }
        listaVeiculo = new ArrayList(Veiculo.consultarVeiculoPlaca((String) veiculo.getSelectedItem()));
        Veiculo vei = (Veiculo)listaVeiculo.get(0);
        int capacidade = vei.getCapacidade();
        
        AddPassageiroEscolar addP = new AddPassageiroEscolar(listaPas, esc, "escolar", capacidade);
        addP.setLocationRelativeTo(null);
        addP.setVisible(true);
        
        
    }//GEN-LAST:event_addActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        // TODO add your handling code here:
        
        ///// QUANDO FOR ADICIONAR A ROTA E FOR OBRIGATÓRIO, APENAS COLOCAR MAIS UM IF NO PRÓXIMO IF 
        ///// DEPOIS DO WHILE E UM IF PRA VER SOMENTE A ROTA
        
        boolean verMot = false;
        boolean verVei = false;
        boolean verLista = false;
        boolean verPeriodo = false;
        try{
            while(verMot == false && verVei == false && verLista == false && verPeriodo == false){
                // colocando os valores da tela em variaveis
                String mot = motorista.getSelectedItem().toString();
                String vei = veiculo.getSelectedItem().toString();
                String per = periodo.getSelectedItem().toString();
                //String rota = campoRota.getText();

                if (mot == "SELECIONE" || vei == "SELECIONE" || per == "SELECIONE" || listaPas.isEmpty()){
                    if (vei == "SELECIONE"){
                        verVei = false;
                        JOptionPane.showMessageDialog(rootPane, "Escolha um Veículo.");
                        return;
                    }if (per == "SELECIONE"){
                        verLista = false;
                        JOptionPane.showMessageDialog(rootPane, "Escolha um periodo.");
                        return;
                    }if (mot == "SELECIONE"){
                        verMot = false;
                        JOptionPane.showMessageDialog(rootPane, "Escolha um Motorista.");
                        return;
                    }if (listaPas.isEmpty()){
                        verLista = false;
                        JOptionPane.showMessageDialog(rootPane, "A lista de escolares está vazia.");
                        return;
                    }
                    break;
                }else{
                    verLista = true;
                    verMot = true;
                    verVei = true;
                    verPeriodo = true;
                    mot = mot.substring(mot.length() - 11);
                    ServicoEscolarControle servEsc = new ServicoEscolarControle();
                    servEsc.setPlacaVeiculo(vei);
                    servEsc.setCpfMotorista(mot);
                    servEsc.setPeriodo(per);
                    servEsc.setId(idAtual);

                    //servEsc.cadastrarServico(servEsc);
                    
                    // fazer a busca do escalona motorista 
                    listaEscalona = new ArrayList(EscalonamentoMotorista.consultarEscalonamento());
                    
                    
                    
                    
                    if (controlador == 1){ // ALTERAR 
                        servEsc.alterarServico(servEsc);
                        
                        listaPasExcluir = new ArrayList(PassEscolar.consultarPassageiros(idAtual.toString()));
                        for (int i=0; i<listaPasExcluir.size(); i++){
                            PassEscolar p = (PassEscolar)listaPasExcluir.get(i);
                            p.excluirPassageiro(p);
                        }
                        
                        for (int i=0; i<listaPas.size(); i++){
                            PassEscolar pass = new PassEscolar();
                            ClienteEscolar cli = (ClienteEscolar)listaPas.get(i);
                            
                            pass.setCpf(cli.getCpf());
                            pass.setNome(cli.getNome());
                            pass.setIdServico(servEsc.getId().toString());
                            
                            pass.cadastrarPass(pass);
                        }
                        // ALTERAR ESCALONA MOTORISTA 
                        
                        // alterei o motorista 
                        if(s.getCpfMotorista() == null ? servEsc.getCpfMotorista() != null : !s.getCpfMotorista().equals(servEsc.getCpfMotorista())){
                            // fazer busca no escalonamento do novo motorista
                            int i = 0;
                            EscalonamentoMotorista esca = new EscalonamentoMotorista();
                            boolean tem = false;
                            while (i < listaEscalona.size()){//|| tem == false
                                EscalonamentoMotorista escalona = (EscalonamentoMotorista)listaEscalona.get(i);
                                if(servEsc.getCpfMotorista() == null ? escalona.getCpf() == null : servEsc.getCpfMotorista().equals(escalona.getCpf())){
                                    esca = escalona;
                                    tem = true;
                                }
                                i = i + 1;
                            }
                            if(tem == false){
                                // cadastrar um novo escalona
                                esca.setCpf(servEsc.getCpfMotorista());
                                esca.setPeriodo1(per);
                                esca.cadastrarEscalonamento(esca);
                            }else{
                                // alterar o escalona que ja tem 
                                if(s.getPeriodo() == null ? esca.getPeriodo1() == null : s.getPeriodo().equals(esca.getPeriodo1())){
                                    if(s.getPeriodo() == null ? servEsc.getPeriodo() != null : !s.getPeriodo().equals(servEsc.getPeriodo())){
                                        esca.setPeriodo1(servEsc.getPeriodo());
                                    }
                                }if(s.getPeriodo() == null ? esca.getPeriodo2() == null : s.getPeriodo().equals(esca.getPeriodo2())){
                                    if(s.getPeriodo() == null ? servEsc.getPeriodo() != null : !s.getPeriodo().equals(servEsc.getPeriodo())){
                                        esca.setPeriodo2(servEsc.getPeriodo());
                                    }
                                }
                                esca.alterarEscalonamento(esca);
                            }
                            
                        // alterei o periodo
                        }if(s.getPeriodo() != per){
                            // alterei o periodo
                            System.out.println("entrou");
                            // procurar o escalona com cpf igual
                            int i = 0;
                            EscalonamentoMotorista esca = new EscalonamentoMotorista();
                            while (i < listaEscalona.size()){//|| tem == false
                                EscalonamentoMotorista escalona = (EscalonamentoMotorista)listaEscalona.get(i);
                                if(servEsc.getCpfMotorista() == null ? escalona.getCpf() == null : servEsc.getCpfMotorista().equals(escalona.getCpf())){
                                    esca = escalona;
                                }
                                i = i + 1;
                            }
                            System.out.println(esca.getPeriodo1());
                            if(s.getPeriodo() == null ? esca.getPeriodo1() == null : s.getPeriodo().equals(esca.getPeriodo1())){
                                if(per == null ? s.getPeriodo() != null : !per.equals(s.getPeriodo())){
                                    esca.setPeriodo1(per);
                                }
                            System.out.println(esca.getPeriodo1());
                            }if(s.getPeriodo() == null ? esca.getPeriodo2() == null : s.getPeriodo().equals(esca.getPeriodo2())){
                                if(s.getPeriodo() == null ? per != null : !s.getPeriodo().equals(per)){
                                    esca.setPeriodo2(per);
                                }
                            }
//                            if(s.getPeriodo() == esca.getPeriodo1()){
//                                if(s.getPeriodo() != per){
//                                    esca.setPeriodo1(per);
//                                }
//                            }if(s.getPeriodo() == esca.getPeriodo2()){
//                                if(s.getPeriodo() != per){
//                                    esca.setPeriodo2(per);
//                                }
//                            }
                            esca.alterarEscalonamento(esca);
                        }

                        JOptionPane.showMessageDialog(this, "Serviço atualizado com sucesso.");
                    }else{ // CADASTRAR
                        servEsc.cadastrarServico(servEsc);
                        // cadastrar lista de passageiros no banco de dados
                        // PassEscolar pass = new PassEscolar();
                        for (int i=0; i<listaPas.size(); i++){
                            PassEscolar pass = new PassEscolar();
                            ClienteEscolar cli = (ClienteEscolar)listaPas.get(i);
                            pass.setCpf(cli.getCpf());
                            pass.setNome(cli.getNome());
                            pass.setIdServico(servEsc.getId().toString());
                            pass.cadastrarPass(pass);
                        }
                        // ALTERAR OU CADASTRAR ESCALONA MOTORISTA
                        boolean tem = false;
                        int i = 0;
                        while (i < listaEscalona.size()){ //|| tem == false
                            EscalonamentoMotorista escalona = (EscalonamentoMotorista)listaEscalona.get(i);
                            if(servEsc.getCpfMotorista() == null ? escalona.getCpf() == null : servEsc.getCpfMotorista().equals(escalona.getCpf())){
                                // alterar
                                escalona.setPeriodo2(per);
                                escalona.alterarEscalonamento(escalona);
                                tem = true;
                            }
                            i = i + 1;
                        }
                        if(tem == false){
                            // cadastrar um novo escalona
                            EscalonamentoMotorista esc = new EscalonamentoMotorista();
                            esc.setCpf(servEsc.getCpfMotorista());
                            esc.setPeriodo1(per); // só terá um periodo cadastrado, pois ele ainda nao estava no escalona
                            System.out.println("cadastrou");
                            esc.cadastrarEscalonamento(esc);
                        }
                        
                        
                        JOptionPane.showMessageDialog(this, "Serviço salvo com sucesso.");
                    }
                    dispose();
                }
            }
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicoEscolar.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(ServicoEscolar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salvarActionPerformed

    private void cancelarjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarjButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelarjButton2ActionPerformed

    private void motoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motoristaActionPerformed
        // TODO add your handling code here:
//        if(periodo.getSelectedItem() == "SELECIONE"){
//            JOptionPane.showMessageDialog(rootPane, "Informe um periodo.");
//            return;
//        }
    }//GEN-LAST:event_motoristaActionPerformed

    private void veiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_veiculoActionPerformed

    private void periodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodoActionPerformed
        // TODO add your handling code here:
        EscalonamentoMotorista escalona = new EscalonamentoMotorista();
        try {
            int tam = listaMotorista.size();
            motorista.removeAllItems();
            while(!listaMotorista.isEmpty()){
                //Motorista mot = (Motorista)listaMotorista.get(0);
                listaMotorista.remove(0);
            }
            
            listaMotorista = (ArrayList) escalona.escalonaMotorista("Escolar", (String) periodo.getSelectedItem(), "", "");
            
            atualizaCampoMotorista();
        } catch (ParseException ex) {
            Logger.getLogger(ServicoEscolar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_periodoActionPerformed

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
            java.util.logging.Logger.getLogger(ServicoEscolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicoEscolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicoEscolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicoEscolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServicoEscolar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox motorista;
    private javax.swing.JComboBox periodo;
    private javax.swing.JButton salvar;
    private javax.swing.JComboBox veiculo;
    // End of variables declaration//GEN-END:variables
    
    public void atualiza(){
        atualizaCampoVeiculo();
        atualizaCampoMotoristaSel();
        //atualizaTabela(null);
        
    }
    
    public void atualizaCampoMotoristaSel(){
        motorista.addItem("SELECIONE");
    }
    
    public void atualizaCampoVeiculo(){
        listaVeiculo = new ArrayList(Veiculo.consultarVeiculo());
        veiculo.addItem("SELECIONE");
        for (int i=0; i<listaVeiculo.size(); i++){
            Veiculo vei = (Veiculo)listaVeiculo.get(i);
            veiculo.addItem(vei.getPlaca());
        }
    }
    
    public void atualizaCampoMotorista(){
        //listaMotorista = new ArrayList(Motorista.consultarMotorista());
        motorista.addItem("SELECIONE");
        for (int i=0; i<listaMotorista.size(); i++){
            Motorista mot = (Motorista)listaMotorista.get(i);
            motorista.addItem(mot.getNome() + " - CPF: " + mot.getCpf());
        }
    }
    
    public void retornaLista(ArrayList listaPas){
        this.listaPas = listaPas;
        //atualizaTabela(this.listaPas);
        
    }
    /*public void atualizaTabela(ArrayList listaPas){
        System.out.println("tamanho lista servico");
        String[] nomesColunas = {"Nome", "CPF"};
        Object[][] dadosVetor = new Object[0][nomesColunas.length];
        
        if (listaPas != null && listaPas.size() > 0){
            
            System.out.println("entrou");
            dadosVetor = new Object[listaPas.size()][nomesColunas.length];
            for (int i=0; i<listaPas.size(); i++){
                ClienteEscolar cli = (ClienteEscolar)listaPas.get(i);
                dadosVetor[i][0] = cli.getNome();
                System.out.println(dadosVetor[i][0]);
                dadosVetor[i][1] = cli.getCpf();
                System.out.println(dadosVetor[i][1]);
            }
        }
        DefaultTableModel modelo = new DefaultTableModel(dadosVetor,nomesColunas);
        this.tabPass.setModel(modelo);
    }*/
}
