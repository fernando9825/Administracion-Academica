/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iudesign;

import Clases.SimpleFactory;
import Clases.conectarBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author m98am
 */
public class loginn extends javax.swing.JFrame {

    public String fullName, usuarioBD, materia, seccion;

    /**
     * Creates new form loginn
     */
    public loginn() {
        initComponents();
        setLocationRelativeTo(null);
        Color color = new Color(0, 153, 153, 100);
        jPanel1.setBackground(color);
    }

    private void log_in() {

        labelsesion.setText("Espere...");
        String usuario, password;
        usuario = (textFieldUsuario.getText());
        password = (textFieldPassword.getText());

        if (!(usuario.isEmpty()) && !(password.isEmpty())) {

            //INICIAR SESIÓN
            conectarBD con = new conectarBD();

            if (con.abrirConexion()) {
                con.IniciarSesion(usuario, password);
                if (usuario.equalsIgnoreCase(con.usuarioBD) && password.equals(con.passwordBD)) {
                    fullName = con.fullname;
                    usuarioBD = con.usuarioBD;
                    materia = con.materia;
                    seccion = con.seccion;
                    if (seccion == null) { //Si no es guia se abre el menu normal
                        //SE OCULTA EL LOGIN
                        this.setVisible(false);
//                    SE ABRE EL MENÚ
                        SimpleFactory simpleFactory = new SimpleFactory();
                        simpleFactory.constructorObjetosVariables(3, fullName, materia, seccion);
                        simpleFactory = null;
//                    new menú(fullName, materia).setVisible(true);
                        //SE CIERRA EL Login
                        this.dispose();
                    } else {//Si es guia se abre un menu especial

                        //SE OCULTA EL LOGIN
                        this.setVisible(false);
//                    SE ABRE EL MENÚ
                        SimpleFactory simpleFactory = new SimpleFactory();
                        simpleFactory.constructorObjetosVariables(1, fullName, materia, seccion);
                        simpleFactory = null;
//                    new menú(fullName, materia).setVisible(true);
                        //SE CIERRA EL Login
                        this.dispose();
                    }
                } else {
                    //JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos y/o no existe.");
                    JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos y/o no existe.", "Información", 0);
                    btnIngresar.setEnabled(true);
                    btnRegistrarse.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se puede establecer la conexión con el servidor\n¡Vuelva a intentarlo!");
                btnIngresar.setEnabled(true);
                btnRegistrarse.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, escribe tu usuario y contraseña", "Información", 0);
        }
        labelsesion.setText("");


        /* if(usuario.equals("fer")){
            if(password.equals("123")){
                this.dispose();
                new menú().setVisible(true);
            }
        }
         */
 /* SIMPLEMENTE ABRIR LA VENTANA
        this.dispose();
        new menú().setVisible(true);
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrarse = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        textFieldUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        labelsesion = new javax.swing.JLabel();
        textFieldPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/42509.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, 138));

        jSeparator1.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 200, 16));

        jSeparator2.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 280, 10));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Complejo Educativo Confederación Suiza");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 520, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/27473.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 222, 242));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 720));

        jPanel2.setBackground(new java.awt.Color(9, 9, 62));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrarse.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnRegistrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Plus_32px.png"))); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.setBorder(null);
        btnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 570, 119, 38));

        btnIngresar.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Login_32px.png"))); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(null);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 103, 38));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("EMAIL/ USER NAME");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("CONTRASEÑA");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 265, 15));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 457, 270, 20));

        textFieldUsuario.setBackground(new java.awt.Color(9, 9, 62));
        textFieldUsuario.setForeground(new java.awt.Color(240, 240, 240));
        textFieldUsuario.setBorder(null);
        textFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(textFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 260, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Inicia sesión o Regístrate");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 116, 275, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Close_Window_32px.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Horizontal_Line_32px.png"))); // NOI18N
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 20, -1));

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Mostrar");
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jToggleButton1ItemStateChanged(evt);
            }
        });
        jPanel2.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 84, 20));
        jPanel2.add(labelsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 525, -1, -1));

        textFieldPassword.setBackground(new java.awt.Color(9, 9, 62));
        textFieldPassword.setForeground(new java.awt.Color(240, 240, 240));
        textFieldPassword.setBorder(null);
        textFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPasswordActionPerformed(evt);
            }
        });
        textFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textFieldPasswordKeyPressed(evt);
            }
        });
        jPanel2.add(textFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 270, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 420, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents
       //BOTÓN INGRESAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        log_in();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void textFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldUsuarioActionPerformed

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown

// TODO add your handling code here:
    }//GEN-LAST:event_jPanel2ComponentShown
    //BOTÓN REGISTRARSE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        try {
            Object[] options = {"¡Sí!", "¡No!"};
            String mensaje = "¿Es maestro/a guia?";
            SimpleFactory simpleFactory = new SimpleFactory();
            conectarBD bd = new conectarBD();

            int n = JOptionPane.showOptionDialog(this, mensaje, "Información",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (n == JOptionPane.YES_OPTION) {

                String res = bd.mostrarDisp(bd.MaestroGuia());
                if (res.equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los años tienen "
                            + "maestro guia.\nEn seguida le presentaré un formulario "
                            + "donde podrá \nelegir el año, sección y materia "
                            + "que va a desarrolar.");
                    simpleFactory.constructorObjetos(3); //Registrarse
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Los siguientes años están "
                            + "disponibles para usted:\n\n" + res
                            + "\nPodrá estar a cargo de uno de ellos, en seguida le"
                            + " presentaré un formulario de registro");
                    simpleFactory.constructorObjetos(4); //RegistrarseGuia
                    this.dispose();
                }

            } else if (n == JOptionPane.NO_OPTION) {
                simpleFactory.constructorObjetos(3); //Registrarse
                this.dispose();
            } else {

            }
            simpleFactory = null;
            bd = null;
            //new registrarse().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Se ha presentado el siguiente "
                    + "error: \n\n" + e + "\nComuniquese con el administrador "
                    + "para obtener una solución", "Ocurrio un error!", 0);
        }

    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        this.setExtendedState(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked
    int xy, xx;
    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        setOpacity((float) 0.8);
        xx = evt.getX();
        xy = evt.getY();
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased
        setOpacity((float) 1.0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseReleased

    private void textFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPasswordActionPerformed

    private void textFieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldPasswordKeyPressed
        //Si el usuario preciona enter en el campo de contraseña haga el login
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            log_in();
        }
    }//GEN-LAST:event_textFieldPasswordKeyPressed

    private void jToggleButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jToggleButton1ItemStateChanged
        if (jToggleButton1.isSelected()) {
            jToggleButton1.setText("Ocultar");
            textFieldPassword.setEchoChar((char) 0); //Mostrar la contraseña
        } else {
            jToggleButton1.setText("Mostrar");
            textFieldPassword.setEchoChar('*'); //Ocultar la contraseña
        }
    }//GEN-LAST:event_jToggleButton1ItemStateChanged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        setOpacity((float) 0.8);
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        setOpacity((float) 1.0);
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel1MouseDragged

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
            java.util.logging.Logger.getLogger(loginn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelsesion;
    private javax.swing.JPasswordField textFieldPassword;
    private javax.swing.JTextField textFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
