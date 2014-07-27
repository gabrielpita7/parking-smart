/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesUsuario;

import bancoDeDados.ConexaoBanco;
import executor.LoginUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import usoGeral.Constantes;

/**
 * @author Smart Parking
 * @version 1.0
 */
public class Administracao extends javax.swing.JFrame {

    private ConexaoBanco conexaoBanco;
    private Statement statement;
    private ResultSet result;
    
    public Administracao() {
        try{
            initComponents();
            this.setLocationRelativeTo(null);
            this.buscarTotais();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro no construtor Administracao. " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        VagasOcupadas = new javax.swing.JTextField();
        VagasRestantes = new javax.swing.JTextField();
        Voltar = new javax.swing.JButton();
        Historico = new javax.swing.JButton();
        CadastrarUsuario = new javax.swing.JButton();
        Preferencial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Vagas = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        PrefOcupadas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Administração");
        setResizable(false);

        jLabel1.setText("Total Estacionados");

        jLabel2.setText("Vagas Restantes");

        VagasOcupadas.setEditable(false);

        VagasRestantes.setEditable(false);

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

        Historico.setText("Histórico Vagas");
        Historico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HistoricoMouseClicked(evt);
            }
        });
        Historico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HistoricoKeyPressed(evt);
            }
        });

        CadastrarUsuario.setText("Usuários");
        CadastrarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CadastrarUsuarioMouseClicked(evt);
            }
        });
        CadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarUsuarioActionPerformed(evt);
            }
        });
        CadastrarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CadastrarUsuarioKeyPressed(evt);
            }
        });

        Preferencial.setEditable(false);

        jLabel3.setText("Total Preferenciais");

        Vagas.setText("Vagas");
        Vagas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VagasMouseClicked(evt);
            }
        });
        Vagas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VagasKeyPressed(evt);
            }
        });

        jLabel4.setText("Prefer. Ocupadas");

        PrefOcupadas.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Vagas, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CadastrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Historico, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VagasOcupadas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VagasRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3)
                            .addComponent(Preferencial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PrefOcupadas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {PrefOcupadas, Preferencial, VagasOcupadas, VagasRestantes, jLabel1, jLabel2, jLabel3, jLabel4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VagasOcupadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VagasRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrefOcupadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Preferencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Voltar)
                    .addComponent(Historico)
                    .addComponent(CadastrarUsuario)
                    .addComponent(Vagas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoltarMouseClicked
        this.retornarLogin();
    }//GEN-LAST:event_VoltarMouseClicked

    private void VoltarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VoltarKeyPressed
        if (evt.getKeyCode() == 10){
            this.retornarLogin();
        }
    }//GEN-LAST:event_VoltarKeyPressed

    private void HistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistoricoMouseClicked
        this.chamarHistorico();
    }//GEN-LAST:event_HistoricoMouseClicked

    private void HistoricoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HistoricoKeyPressed
        if (evt.getKeyCode() == 10){
            this.chamarHistorico();
        }
    }//GEN-LAST:event_HistoricoKeyPressed

    private void CadastrarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadastrarUsuarioMouseClicked
        this.chamarCadastroUsuario();
    }//GEN-LAST:event_CadastrarUsuarioMouseClicked

    private void CadastrarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CadastrarUsuarioKeyPressed
        if (evt.getKeyCode() == 10){
            this.chamarCadastroUsuario();
        }
    }//GEN-LAST:event_CadastrarUsuarioKeyPressed

    private void VagasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VagasKeyPressed
        if (evt.getKeyCode() == 10){
            this.chamarManutencaoVagas();
        }
    }//GEN-LAST:event_VagasKeyPressed

    private void VagasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VagasMouseClicked
        this.chamarManutencaoVagas();
    }//GEN-LAST:event_VagasMouseClicked

    private void CadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CadastrarUsuarioActionPerformed
    
    private void chamarHistorico (){
        Estacionamento estacionamento = new Estacionamento();
        estacionamento.show();
        this.dispose();   
    }
    
    private void retornarLogin (){
        LoginUsuario login = new LoginUsuario();
        login.show();
        this.dispose();
    }
    
    private void chamarCadastroUsuario (){
        BuscarUsuarios buscarUsuario = new BuscarUsuarios();
        buscarUsuario.show();
        this.dispose();  
    }
    
    private void chamarManutencaoVagas (){
        ManutencaoVagas manutencaoVagas = new ManutencaoVagas();
        manutencaoVagas.show();
        this.dispose();  
    }
    
    private void buscarTotais (){
        int totalEstacionados = 0;
        int totalPreferenciais = 0;
        
        try {
            conexaoBanco = new ConexaoBanco();
            statement = conexaoBanco.conexao.createStatement();
            result = statement.executeQuery("select * from usuarios where CodigoVaga_Usuario <> ' '");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Administracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (result.next()){
                totalEstacionados++;
                if (result.getString("Deficiente_Usuario").equals("S"))
                    totalPreferenciais++;
            }
            
            VagasOcupadas.setText(String.valueOf(totalEstacionados));
            VagasRestantes.setText(String.valueOf(Constantes.totalVagas - totalEstacionados));
            Preferencial.setText(String.valueOf(Constantes.totalVagasDeficientes));
            PrefOcupadas.setText(String.valueOf(totalPreferenciais));
            
        } catch (SQLException ex) {
            Logger.getLogger(Administracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Ocoreu um problema na verificação dos totais!" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                if (!statement.isClosed()){
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Administracao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastrarUsuario;
    private javax.swing.JButton Historico;
    private javax.swing.JTextField PrefOcupadas;
    private javax.swing.JTextField Preferencial;
    private javax.swing.JButton Vagas;
    private javax.swing.JTextField VagasOcupadas;
    private javax.swing.JTextField VagasRestantes;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
