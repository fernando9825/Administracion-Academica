/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iudesign;

import Clases.ComprobarConexionInternet;
import Clases.SimpleFactory;
import Clases.conectarBD;
import javax.swing.JOptionPane;

/**
 *
 * @author m98am
 */
public class ingresoNotas extends javax.swing.JFrame {

    /**
     * Creates new form ingresonotas
     */
    public static String fullName, materia, seccion;

    public ingresoNotas(String fullName, String materia, String seccion) {
        initComponents();
        setLocationRelativeTo(null);

        //Dandole valor a las variables globales
        this.fullName = fullName;
        this.materia = materia;
        this.seccion = seccion;

        jLabelNombreProfe.setText(fullName);
        lblMateria.setText(materia);

        conectarBD bd = new conectarBD();
        String Query = "SELECT * FROM notas ORDER BY apellido ASC";
        bd.llenarTabla(tablaAlumnos, Query);
        bd = null;
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
        jLabelNombreProfe = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlabelSeccion = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCarnet = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnNota = new javax.swing.JButton();
        cbxNota = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblMateria = new javax.swing.JLabel();
        labelcomplejo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnPGralA = new javax.swing.JButton();
        btnPGralB = new javax.swing.JButton();
        btnPGralC = new javax.swing.JButton();
        btnSGralA = new javax.swing.JButton();
        btnSGralB = new javax.swing.JButton();
        btnSGralC = new javax.swing.JButton();
        btnPTVA = new javax.swing.JButton();
        btnSTVA = new javax.swing.JButton();
        btnTTVA = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelNombreProfe.setText("Nombre del profesor");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Collaborator_Male_24px_1.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Minimize_Window_32px.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(554, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabelNombreProfe, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabelNombreProfe)
                    .addComponent(jLabel12))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 850, 40));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jlabelSeccion.setText("Ingresa tus notas según las evaluaciones del período correspondiente ");

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Carnet", "Apellido", "Seccion", "Matemáticas", "Sociales", "Ciencia", "Lenguaje", "Ingles", "OPV", "Seminario", "Informática", "Tecnología", "Math financieras", "Lab Creatividad", "Prácticas contables"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaAlumnos);

        jScrollPane4.setViewportView(jScrollPane3);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Carnet:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nota:");

        btnNota.setText("Asignar nota");
        btnNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotaActionPerformed(evt);
            }
        });

        cbxNota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCarnet)
                                    .addComponent(cbxNota, 0, 200, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(455, 455, 455))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnNota)
                .addContainerGap(595, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel5.setText("Ingreso de notas.");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportbaby-iconos-01.png"))); // NOI18N

        lblMateria.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        labelcomplejo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        labelcomplejo.setText("Complejo Educativo Confederación Suiza");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelcomplejo, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(511, 511, 511)
                                .addComponent(jlabelSeccion))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jlabelSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelcomplejo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 890, 630));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Home_32px_1.png"))); // NOI18N
        jLabel2.setText("   Inicio");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Back_Arrow_32px.png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        btnPGralA.setText("1° Gral A");
        btnPGralA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPGralAActionPerformed(evt);
            }
        });

        btnPGralB.setText("1° Gral B");
        btnPGralB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPGralBActionPerformed(evt);
            }
        });

        btnPGralC.setText("1° Gral C");
        btnPGralC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPGralCActionPerformed(evt);
            }
        });

        btnSGralA.setText("2° Gral A");
        btnSGralA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSGralAActionPerformed(evt);
            }
        });

        btnSGralB.setText("2° Gral B");
        btnSGralB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSGralBActionPerformed(evt);
            }
        });

        btnSGralC.setText("2° Gral C");
        btnSGralC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSGralCActionPerformed(evt);
            }
        });

        btnPTVA.setText("1° Tvc A");
        btnPTVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPTVAActionPerformed(evt);
            }
        });

        btnSTVA.setText("2° Tvc A");
        btnSTVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSTVAActionPerformed(evt);
            }
        });

        btnTTVA.setText("3° Tvc A");
        btnTTVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTTVAActionPerformed(evt);
            }
        });

        btnTodos.setText("TODOS");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 86, Short.MAX_VALUE))
                            .addComponent(btnPGralA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPGralB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPGralC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSGralA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSGralB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSGralC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPTVA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSTVA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTTVA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(125, 125, 125)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(btnTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPGralA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPGralB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPGralC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSGralA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSGralB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSGralC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPTVA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSTVA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTTVA)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.setExtendedState(1);
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        //Creando una nueva instancia, un metodo de ella nos permite verificar la conexion a internet
        ComprobarConexionInternet i = new ComprobarConexionInternet();
        if (i.comprobarConexion()) {
            if (seccion == null) {
                this.dispose();
                SimpleFactory simpleFactory = new SimpleFactory();
                simpleFactory.constructorObjetosVariables(3, fullName, materia, seccion);
                simpleFactory = null;
                //new menú(fullName, materia).setVisible(true);
            } else {
                this.dispose();
                SimpleFactory simpleFactory = new SimpleFactory();
                simpleFactory.constructorObjetosVariables(1, fullName, materia, seccion);
                simpleFactory = null;
                //new menú(fullName, materia).setVisible(true);
            }
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if (seccion == null) {
            this.dispose();
            SimpleFactory simpleFactory = new SimpleFactory();
            simpleFactory.constructorObjetosVariables(3, fullName, materia, seccion);
            simpleFactory = null;
            //new menú(fullName, materia).setVisible(true);
        } else {
            this.dispose();
            SimpleFactory simpleFactory = new SimpleFactory();
            simpleFactory.constructorObjetosVariables(1, fullName, materia, seccion);
            simpleFactory = null;
            //new menú(fullName, materia).setVisible(true);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnPGralAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPGralAActionPerformed
        conectarBD bd = new conectarBD();
        String Query = "SELECT * FROM notas where seccion = '1° General A'";
        bd.llenarTabla(tablaAlumnos, Query);
        bd = null;
    }//GEN-LAST:event_btnPGralAActionPerformed

    private void btnPGralBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPGralBActionPerformed
        conectarBD bd = new conectarBD();
        String Query = "SELECT * FROM notas where seccion = '1° General B'";
        bd.llenarTabla(tablaAlumnos, Query);
        bd = null;
    }//GEN-LAST:event_btnPGralBActionPerformed

    private void btnPGralCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPGralCActionPerformed
        conectarBD bd = new conectarBD();
        String Query = "SELECT * FROM notas where seccion = '1° General C'";
        bd.llenarTabla(tablaAlumnos, Query);
        bd = null;
    }//GEN-LAST:event_btnPGralCActionPerformed

    private void btnSGralAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSGralAActionPerformed
        conectarBD bd = new conectarBD();
        String Query = "SELECT * FROM notas where seccion = '2° General A'";
        bd.llenarTabla(tablaAlumnos, Query);
        bd = null;
    }//GEN-LAST:event_btnSGralAActionPerformed

    private void btnSGralBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSGralBActionPerformed
        conectarBD bd = new conectarBD();
        String Query = "SELECT * FROM notas where seccion = '2° General B'";
        bd.llenarTabla(tablaAlumnos, Query);
        bd = null;
    }//GEN-LAST:event_btnSGralBActionPerformed

    private void btnSGralCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSGralCActionPerformed
        conectarBD bd = new conectarBD();
        String Query = "SELECT * FROM notas where seccion = '2° General C'";
        bd.llenarTabla(tablaAlumnos, Query);
        bd = null;
    }//GEN-LAST:event_btnSGralCActionPerformed

    private void btnPTVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPTVAActionPerformed
        conectarBD bd = new conectarBD();
        String Query = "SELECT * FROM notas where seccion = '1° Técnico vocacional A'";
        bd.llenarTabla(tablaAlumnos, Query);
        bd = null;
    }//GEN-LAST:event_btnPTVAActionPerformed

    private void btnSTVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSTVAActionPerformed
        conectarBD bd = new conectarBD();
        String Query = "SELECT * FROM notas where seccion = '2° Técnico vocacional A'";
        bd.llenarTabla(tablaAlumnos, Query);
        bd = null;
    }//GEN-LAST:event_btnSTVAActionPerformed

    private void btnTTVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTTVAActionPerformed
        conectarBD bd = new conectarBD();
        String Query = "SELECT * FROM notas where seccion = '3° Técnico vocacional A'";
        bd.llenarTabla(tablaAlumnos, Query);
        bd = null;
    }//GEN-LAST:event_btnTTVAActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        conectarBD bd = new conectarBD();
        String Query = "SELECT * FROM notas";
        bd.llenarTabla(tablaAlumnos, Query);
        bd = null;
    }//GEN-LAST:event_btnTodosActionPerformed
    float nota;
    private void btnNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotaActionPerformed
        String Query = "SELECT * FROM notas";
        conectarBD bd = new conectarBD();

        if (!(txtCarnet.getText().toString().isEmpty()) && cbxNota.getSelectedIndex() != 0) {

            String carnet = (txtCarnet.getText());
            if (cbxNota.getSelectedIndex() != 0) {
                nota = Float.parseFloat(cbxNota.getSelectedItem().toString());
            }

            if (nota >= 0 && nota <= 10) {
                if (bd.ingresarNotas(carnet, materia, nota)) {
                    JOptionPane.showMessageDialog(this, "Se ha ingresado exitosamente la nota de: " + nota +", detalles:\n"
                            + "Carnet: " + carnet + "\n" + "Materia: " + materia + "\n"
                            + "\nPresione enter para continuar");
                    bd.llenarTabla(tablaAlumnos, Query);
                    bd = null;
                    cbxNota.setSelectedIndex(0);
                    txtCarnet.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Verifique que el carnet coincide "
                            + "con el carnet\ndel alumno al que desea asignarle nota.", "Error!", 0);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Las notas válidas van de 0 a 10.", "Error!", 0);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Complete los campos", "Error!", 0);
        }

    }//GEN-LAST:event_btnNotaActionPerformed

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
            java.util.logging.Logger.getLogger(ingresoNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingresoNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingresoNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingresoNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ingresoNotas(fullName, materia, seccion).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNota;
    private javax.swing.JButton btnPGralA;
    private javax.swing.JButton btnPGralB;
    private javax.swing.JButton btnPGralC;
    private javax.swing.JButton btnPTVA;
    private javax.swing.JButton btnSGralA;
    private javax.swing.JButton btnSGralB;
    private javax.swing.JButton btnSGralC;
    private javax.swing.JButton btnSTVA;
    private javax.swing.JButton btnTTVA;
    private javax.swing.JButton btnTodos;
    private javax.swing.JComboBox<String> cbxNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private static javax.swing.JLabel jLabelNombreProfe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private static javax.swing.JLabel jlabelSeccion;
    private static javax.swing.JLabel labelcomplejo;
    private static javax.swing.JLabel lblMateria;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTextField txtCarnet;
    // End of variables declaration//GEN-END:variables
}
