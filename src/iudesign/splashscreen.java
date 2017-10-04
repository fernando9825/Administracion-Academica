/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iudesign;

import com.sun.awt.AWTUtilities;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author m98am
 */
public class splashscreen extends javax.swing.JFrame implements Runnable {

    private Thread tiempo = null;

    /**
     * Creates new form splashscreen
     */
    public splashscreen() {
        initComponents();
        setLocationRelativeTo(null);
        AWTUtilities.setWindowOpaque(this, false);
        tiempo = new Thread(this);
        tiempo.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Horizontal_Line_32px.png"))); // NOI18N
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 0, 20, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Close_Window_32px.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 40, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/loading.gif"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, 100, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/splash letras.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 540, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/choang-voi-cach-ve-sinh-laptop-trong-phim-an-do.gif"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.dispose();
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        this.setExtendedState(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

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
            java.util.logging.Logger.getLogger(splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(splashscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new splashscreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        /*
            try {
                Thread.sleep(9500);
                this.dispose();
                new loginn().setVisible(true);
                Thread.sleep(50000);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(splashscreen.class.getName()).log(Level.SEVERE, null, ex);
            }
         */

        try {
            String dirWeb = "www.google.com";
            int puerto = 80;
            Socket s = new Socket(dirWeb, puerto);
            if (s.isConnected()) {
                Thread.sleep(1000);
                this.dispose();
                new loginn().setVisible(true);
                System.out.println("Conexión establecida con la dirección: " + dirWeb + " a travéz del puerto: " + puerto);
            } else {
                JOptionPane.showMessageDialog(this, "Este programa precisa de una conexión "
                        + "a internet para poder funcionar\nPor favor revise su conexión a internet y vuelva a intentarlo.", "Información", 0);
            }
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(splashscreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(splashscreen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Este programa precisa de una conexión "
                        + "a internet para poder funcionar\nPor favor revise su conexión a internet y vuelva a intentarlo.", "Información", 0);
            System.exit(0);
        }
    }

}
