/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G_Livres;

import com.itextpdf.text.*;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import com.mysql.cj.xdevapi.Result;
import java.sql.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.text.*;

/**
 *
 * @author khayatti
 */
public class Rapport extends javax.swing.JFrame {

    /**
     * Creates new form Rapport
     */
    public Rapport() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        home = new javax.swing.JButton();
        exit1 = new javax.swing.JButton();
        ref = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rapport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(988, 511));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(988, 511));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setMinimumSize(new java.awt.Dimension(470, 470));
        jPanel2.setPreferredSize(new java.awt.Dimension(940, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setText("Livres Enregistres :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 810, 250));

        home.setBackground(new java.awt.Color(153, 255, 153));
        home.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        home.setText("Accueil");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jPanel2.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 110, 40));

        exit1.setBackground(new java.awt.Color(255, 102, 102));
        exit1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        exit1.setText("EXIT");
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });
        jPanel2.add(exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 430, 110, 40));

        ref.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                refKeyReleased(evt);
            }
        });
        jPanel2.add(ref, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 460, 40));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Recherche par titre : ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));

        rapport.setBackground(new java.awt.Color(153, 153, 255));
        rapport.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        rapport.setText("Rapport");
        rapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rapportActionPerformed(evt);
            }
        });
        jPanel2.add(rapport, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 110, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 930, 490));

        setSize(new java.awt.Dimension(978, 506));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private void showData(String x) throws SQLException{
                   // TODO add your handling code here:

        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/livre", "root", "khayatti22");
        String sql = "select * from mes_livres where titre like '" + x + "%'";
        pst  = con.prepareStatement(sql);
        rs = pst.executeQuery();
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnIdentifiers(new String[]{"Code","titre","auteur"});
        try {
          while(rs.next()){
              m.addRow(new Object[] {rs.getObject(1),rs.getObject(2),rs.getObject(3)});
          }  
        } 
        catch (SQLException e) {}
        table.setModel(m);
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/livre", "root", "khayatti22");
            showData("");
            charger();
        } catch (SQLException ex) {
            Logger.getLogger(Rapport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
       Menue r = new Menue();
       r.setVisible(true);
                   // TODO add your handling code here:
    }//GEN-LAST:event_homeActionPerformed

    private void refKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refKeyReleased
                  // TODO add your handling code here:

        try {
            showData(ref.getText());       
        } catch (SQLException ex) {
            Logger.getLogger(Rapport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refKeyReleased

    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
                    // TODO add your handling code here:
     
        int rep = JOptionPane.showConfirmDialog(null,"voulez-vous quitter l'application ?","Exit",JOptionPane.YES_NO_OPTION);
        if (rep == JOptionPane.YES_OPTION) {
            System.exit(0);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_exit1ActionPerformed

    
     private void charger() {
                     // TODO add your handling code here:

        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/livre", "root", "khayatti22");
            DefaultTableModel modele = new DefaultTableModel();
            String[] nomclomne = {"Code", "titre", "Auteur"};
            modele.setColumnIdentifiers(nomclomne);
            Statement st = con.createStatement();
            String sql = "Select * from mes_Livres";
            ResultSet res = st.executeQuery(sql);
            modele.setRowCount(0);
            while (res.next()) {
            	livres lvr = new livres(res.getString(1),res.getString(2),res.getString(3));
            	
                modele.addRow(new Object[]{ new livres(lvr.getCode(),lvr.getTitre(),lvr.getAuteur())});
            }     
            table.setModel(modele);
        } catch (Exception e) {
            System.err.println(e);
        }
    }


	private void rapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rapportActionPerformed
               // TODO add your handling code here:

             if (table.getRowCount() == 0 ) {
            JOptionPane.showMessageDialog(this, "IL N'EXISTE AUCUNE ACTION", "VIDE", JOptionPane.ERROR_MESSAGE);
        }
        else {
            try {
                Document doc = new Document();
                PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\khayatti\\Desktop\\application\\rapport.pdf"));
                doc.open();
                
                PdfPTable table = new PdfPTable(3);

                PdfPCell header0 = new PdfPCell();
                header0.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header0.setPhrase(new Phrase("CODE BARRES"));
                table.addCell(header0);

                PdfPCell header1 = new PdfPCell();
                header1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header1.setPhrase(new Phrase("titre livre"));
                table.addCell(header1);

                PdfPCell header2 = new PdfPCell();
                header2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header2.setPhrase(new Phrase("Auteur livre"));
                table.addCell(header2);

                String sql = "Select * from mes_livres" ;
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery(sql);

                while (res.next()) {
                    table.addCell(String.valueOf(res.getString("code")));
                    table.addCell(res.getString("titre"));
                    table.addCell(res.getString("auteur"));
                }

                doc.add(table);
                doc.close();

                JOptionPane.showMessageDialog(this, "RAPPORT CREE", "RAPPORT", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                System.err.println(e);
            }
        }

   
        
        
        
    }//GEN-LAST:event_rapportActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
      
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rapport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit1;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rapport;
    private javax.swing.JTextField ref;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
