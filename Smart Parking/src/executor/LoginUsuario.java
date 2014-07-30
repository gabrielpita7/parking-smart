/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package executor;

import interfacesUsuario.Administracao;
import interfacesUsuario.Estacionamento;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import bancoDeDados.ConexaoBanco;
import usoGeral.Constantes;
import model.ControleVagas;
import model.UsuarioEstacionamento;

/**
 *
 * @author Smart Parking
 * @version 1.0
 */
public class LoginUsuario extends javax.swing.JFrame {
    
    /**
     * Creates new form LoginUsuario
     */
    
    private ConexaoBanco conexaoBanco;
    private Statement statement;
    private ResultSet result;
    
    public LoginUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.buscarTotaisVagas();
    }
    
    /**
     * Valida o botão confirmar da tela de Login.
     * @return void
     */
    private void validarBotaoConfirmar (){
        
        try{
            if (Matricula.getText().equals(Constantes.codigoAdm) && Senha.getText().equals(Constantes.senhaAdm)){
                Constantes.adminAtivo = true;
                if (ControleVagas.verificaLotacaoEstacionamento()){}
                Administracao administacao = new Administracao();
                administacao.show();
                this.dispose();
            }
            else{
                Constantes.adminAtivo = false;
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao verificar Administrador. " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        if (!Constantes.adminAtivo){
            try {
                conexaoBanco = new ConexaoBanco();
                statement = conexaoBanco.conexao.createStatement();
                result = statement.executeQuery("select * from usuarios where CodigoAcesso_Usuario = " + Integer.parseInt(Matricula.getText()));

                if (result.next()){

                    Constantes.usuario = new UsuarioEstacionamento(result.getString("Nome_Usuario"), false, result.getLong("CodigoAcesso_Usuario"), false, result.getString("Senha_Usuario"));

                    if (Constantes.usuario.validarUsuario(Constantes.usuario, Integer.parseInt(Matricula.getText()), Senha.getText(), result.getString("CodigoVaga_Usuario"))){
                        Constantes.usuarioAtivo =  Constantes.usuario.getNome();
                        Constantes.idUsuario = result.getInt("ID_Usuario");

                        if (result.getString("Deficiente_Usuario").equals("S")){
                            Constantes.usuarioDeficiente = true;
                        }
                        else{
                            Constantes.usuarioDeficiente = false;
                        }

                        if (ControleVagas.verificaLotacaoEstacionamento()){
                            Estacionamento estacionamento = new Estacionamento();
                            estacionamento.show();
                            this.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Estacionamento lotado. \n Favor voltar mais tarde.", "Lotado!", JOptionPane.INFORMATION_MESSAGE);
                            ControleVagas controleVagas = new ControleVagas();
                            controleVagas.inserirNaFila(Constantes.usuario);
                            Matricula.setText("");
                            Senha.setText("");
                        }
                    }
                    else{
                        Matricula.setText("");
                        Senha.setText("");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Usuário não cadastrado!", "Login", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch (NumberFormatException | HeadlessException e){
                JOptionPane.showMessageDialog(null,"A matrícula recebe um numérico.", "Login", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void buscarTotaisVagas(){
        try {
            conexaoBanco = new ConexaoBanco();
            statement = conexaoBanco.conexao.createStatement();
            result = statement.executeQuery("SELECT * FROM Vagas");

            if (result.next()){
                Constantes.totalVagas = result.getInt("Total_Vagas");
                Constantes.totalVagasDeficientes = result.getInt("Total_Preferencial_Vagas");
                Constantes.vagasHorizontais = result.getInt("Largura_Vagas");
                Constantes.vagasVerticais = result.getInt("Altura_Vagas");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            try {
                if (statement.isClosed()){
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private boolean validarCampos (){
        if (Matricula.getText().toString().length() > 9){
            JOptionPane.showMessageDialog(null,"A matícula recebe até 9 caracteres!", "Login", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        if (Senha.getText().toString().length() > 6){
            JOptionPane.showMessageDialog(null,"A senha recebe até 6 caracteres!", "Login", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Matricula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Senha = new javax.swing.JPasswordField();
        Confirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        Matricula.setToolTipText("Digite seu código de matrícula/acesso.");

        jLabel1.setText("Login");

        jLabel3.setText("Senha");

        Senha.setToolTipText("Digite sua senha.");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Matricula, Senha});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmarMouseClicked
        if (this.validarCampos()){
            validarBotaoConfirmar();
        }
    }//GEN-LAST:event_ConfirmarMouseClicked

    private void ConfirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConfirmarKeyPressed
        if (evt.getKeyCode() == 10){
            if (this.validarCampos()){
                validarBotaoConfirmar();
            }
        }
    }//GEN-LAST:event_ConfirmarKeyPressed
    
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
            java.util.logging.Logger.getLogger(LoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirmar;
    private javax.swing.JTextField Matricula;
    private javax.swing.JPasswordField Senha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
