/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesUsuario;

import bancoDeDados.ConexaoBanco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ControleVagas;
import usoGeral.Constantes;

/**
 *
 * @author Guilherme
 */
public class ManutencaoVagas extends javax.swing.JFrame {

    private ConexaoBanco conexaoBanco;
    private Statement statement;
    private ResultSet result;
    
    public ManutencaoVagas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.buscarDados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Confirmar = new javax.swing.JButton();
        Voltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Vagas_Horizontal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Vagas_Vertical = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Vagas_Preferenciais = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Vagas");

        Confirmar.setText("Confirmar");
        Confirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmarMouseClicked(evt);
            }
        });
        Confirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ConfirmarKeyPressed(evt);
            }
        });

        Voltar.setText("Voltar");
        Voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VoltarMouseClicked(evt);
            }
        });
        Voltar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VoltarKeyPressed(evt);
            }
        });

        jLabel1.setText("Número de Vagas - Horizontal");

        jLabel2.setText("Número de Vagas - Vertical");

        jLabel3.setText("Número de Vagas Preferenciais");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Vagas_Preferenciais)
                            .addComponent(Vagas_Vertical)
                            .addComponent(jLabel1)
                            .addComponent(Vagas_Horizontal))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Confirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Voltar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vagas_Horizontal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vagas_Vertical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vagas_Preferenciais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Confirmar)
                    .addComponent(Voltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VoltarKeyPressed
        if (evt.getKeyCode() == 10){
            this.retornarTela();
        }
    }//GEN-LAST:event_VoltarKeyPressed

    private void VoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoltarMouseClicked
        this.retornarTela();
    }//GEN-LAST:event_VoltarMouseClicked

    private void ConfirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConfirmarKeyPressed
        if (evt.getKeyCode() == 10){
            this.gravarDados();
        }
    }//GEN-LAST:event_ConfirmarKeyPressed

    private void ConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmarMouseClicked
        this.gravarDados();
    }//GEN-LAST:event_ConfirmarMouseClicked

    private void retornarTela(){
        Administracao administracao = new Administracao();
        administracao.show();
        this.dispose();
    } 
    
    private void buscarDados (){
        this.Vagas_Horizontal.setText(Integer.toString(Constantes.vagasHorizontais)); 
        this.Vagas_Vertical.setText(Integer.toString(Constantes.vagasVerticais));
        this.Vagas_Preferenciais.setText(Integer.toString(Constantes.vagasPreferenciais));
    }
    
    private void gravarDados (){
        
        String update, insert;
        int total, horizontal, vertical, preferencial;
        
        horizontal = Integer.parseInt(this.Vagas_Horizontal.getText());
        vertical = Integer.parseInt(this.Vagas_Vertical.getText());
        preferencial = Integer.parseInt(this.Vagas_Preferenciais.getText());
        total = horizontal * vertical;
        
        if (this.validarDados()){
            try {
                conexaoBanco = new ConexaoBanco();
                statement = conexaoBanco.conexao.createStatement();
                result = statement.executeQuery("select * from vagas where ID_Vagas = 1");

                if (result.next()){
                    update = "UPDATE vagas SET ";
                    update = update + "Total_Vagas = " + total + ", ";
                    update = update + "Largura_Vagas = " + horizontal + ", ";
                    update = update + "Altura_Vagas = " + vertical + ", ";
                    update = update + "Total_Preferencial_Vagas = " + preferencial;
                    update = update + " WHERE ID_Vagas = 1";
                    int updateStatement = statement.executeUpdate(update);
                    if (updateStatement > 0){
                        JOptionPane.showMessageDialog(null,"Vagas Alteradas com Sucesso!");
                        Constantes.vagasHorizontais = horizontal;
                        Constantes.vagasVerticais = vertical;
                        Constantes.vagasPreferenciais = preferencial;
                        
                        this.retornarTela();
                    }
                }
                else{
                    insert = "INSERT INTO estacionamento.vagas(ID_Vagas, Total_Vagas, Largura_Vagas, Altura_Vagas, Total_Preferencial_Vagas) VALUES (";
                    insert = insert + 1 + ", ";
                    insert = insert + total + ", ";
                    insert = insert + horizontal + ", ";
                    insert = insert + vertical + ", ";
                    insert = insert + preferencial + ")";
                    int updateStatement = statement.executeUpdate(insert);
                    if (updateStatement > 0){
                        JOptionPane.showMessageDialog(null,"Vagas Cadastradas com Sucesso!");
                        Constantes.vagasHorizontais = horizontal;
                        Constantes.vagasVerticais = vertical;
                        Constantes.vagasPreferenciais = preferencial;
                        
                        this.retornarTela();
                    }  
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ControleVagas.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro ao inserir/alterar usuario. \n" + ex.getMessage());
            }
            finally{
                try {
                    if (!statement.isClosed()){
                        statement.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControleVagas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private boolean validarDados(){
        boolean validar = true;
        
        try{
           long teste1 = Long.parseLong(Vagas_Horizontal.getText());
           long teste2 = Long.parseLong(Vagas_Vertical.getText());
           long teste3 = Long.parseLong(Vagas_Preferenciais.getText());
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Favor digitar uma numeração válida para os campos.");
            return false;
        }
        
        if ("".equals(Vagas_Horizontal.getText().trim()) || "".equals(Vagas_Vertical.getText().trim()) || "".equals(Vagas_Preferenciais.getText().trim()) ){
            JOptionPane.showMessageDialog(null,"Favor preencher todos os campos.");
            validar = false;
        }
        
        return validar;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirmar;
    private javax.swing.JTextField Vagas_Horizontal;
    private javax.swing.JTextField Vagas_Preferenciais;
    private javax.swing.JTextField Vagas_Vertical;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
