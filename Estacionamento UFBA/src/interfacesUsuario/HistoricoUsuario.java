/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesUsuario;

import bancoDeDados.ConexaoBanco;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Caveira
 * @version 1.0
 */
public class HistoricoUsuario extends javax.swing.JFrame {

    private ConexaoBanco conexaoBanco;
    private Statement statement;
    private ResultSet result;
    
    /**
     * Creates new form HistoricoUsuario
     */
    public HistoricoUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.preencherGrid();
    }
    
    private void voltarAdministrativo () {
        Administracao administracao = new Administracao();
        administracao.show();
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        GridUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Histórico por Usuário");
        setResizable(false);

        GridUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "                 Nome do Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GridUsuarios.setColumnSelectionAllowed(true);
        GridUsuarios.getTableHeader().setReorderingAllowed(false);
        GridUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GridUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(GridUsuarios);
        GridUsuarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        GridUsuarios.getColumnModel().getColumn(0).setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GridUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GridUsuariosMouseClicked
        int linha = GridUsuarios.getSelectedRow();
        
        String nomeUsuario = GridUsuarios.getValueAt(linha, 0).toString();
        this.buscarHistoricoUsuario(nomeUsuario);
        this.voltarAdministrativo();
    }//GEN-LAST:event_GridUsuariosMouseClicked

     /**
     * Buscar histórico de usuário e gerar pdf.
     * @return void
     */
    private void buscarHistoricoUsuario(String nomeUsuario){
        Document documento = null;
        OutputStream arquivo = null;
        String nomeArquivo = "";
		
        try {
            //cria o documento tamanho A4, margens de 2,54cm
            documento = new Document(PageSize.A4, 72, 72, 72, 72);
			
            //cria a stream de saída
            nomeArquivo = "historico" + nomeUsuario + ".pdf";
            arquivo = new FileOutputStream(nomeArquivo);
			
            //associa a stream de saída ao 
            PdfWriter.getInstance(documento, arquivo);
			
            //abre o documento
            documento.open();

            //adiciona o texto ao PDF
            Paragraph p = new Paragraph("Usuario: " + nomeUsuario);
            documento.add(p);
            
            Image img = Image.getInstance("ufbalogo.png");
            img.setAlignment(Element.ALIGN_CENTER);
            documento.add(img);
            p.setSpacingAfter(150);
            p = new Paragraph("Estacionamento - Universidade Federal da Bahia");
            p.setAlignment(Element.ALIGN_CENTER);
            documento.add(p);
            p = new Paragraph("\n");
            documento.add(p);
            p = new Paragraph("\n");
            documento.add(p);
          
            conexaoBanco = new ConexaoBanco();
            statement = conexaoBanco.conexao.createStatement();
            result = statement.executeQuery("SELECT * FROM Historico WHERE nomeUsuario_historico = '" + nomeUsuario + "'");
            
            PdfPTable table = new PdfPTable(3);
            PdfPCell header = new PdfPCell(new Paragraph("Histórico de Vaga por usuário"));
            header.setColspan(3);
            table.addCell(header);
            
            table.addCell("             Vaga");
            table.addCell("    Data de Entrada");
            table.addCell("  Horário de Entrada");
            
            while (result.next()){
                table.addCell(result.getString("CodigoVaga_historico"));
                table.addCell(result.getString("data_historico"));
                table.addCell(result.getString("horario_historico"));
            }
            
            documento.add(table); 
            
        } 
        catch (DocumentException | IOException e){
            JOptionPane.showMessageDialog(null,"Ocoreu um problema na geração do histórico por Usuário. " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Estacionamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Estacionamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try{
                if (documento != null) {
                    //fechamento do documento
                    documento.close();
                }
                if (arquivo != null) {
                   //fechamento da stream de saída
                   arquivo.close();
                }
                
                if (statement.isClosed()){
                    statement.close();
                }
                
                try {  
                    File arquivoHistorico = new File(nomeArquivo); 
                    Desktop.getDesktop().open(arquivoHistorico);
                } catch(Exception e) {   
                  JOptionPane.showMessageDialog(null, "Problemas ao abrir arquivo. " + e.getMessage());  
                } 
                
            }
            catch (IOException e){
                JOptionPane.showMessageDialog(null,"Erro ao fechar arquivo.");
            } catch (SQLException ex) {
                Logger.getLogger(Estacionamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void preencherGrid (){
        try {
            conexaoBanco = new ConexaoBanco();
            statement = conexaoBanco.conexao.createStatement();
            result = statement.executeQuery("SELECT * FROM Usuarios ORDER BY Nome_Usuario");
            
            int i = 0;
            
            while (result.next()){
                if (i < 20){
                    GridUsuarios.setValueAt(result.getString("Nome_Usuario"), i, 0);
                    i++;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HistoricoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            try {
                if (statement.isClosed()){
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HistoricoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GridUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
