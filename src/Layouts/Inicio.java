/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Layouts;

import static Layouts.Sistema.dni;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import propio.DNICryptographer;

/**
 *
 * @author LENOVO
 */
public class Inicio extends javax.swing.JFrame {

    private String user = "root";
    private String password = "password";
    private String nombreSys;
    private String apellidoSys;
    public static String encriyptedDNI;
    private int cedula;

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("BOGOTÁ ELIGE");
        //this.cedula = Integer.parseInt(this.txtCedula.getText().trim());

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        btnValidar = new javax.swing.JButton();
        btnAvanzar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(505, 345));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELECCIONES ALCALDÍA DE BOGOTÁ 2023");

        jLabel2.setText("Primer nombre:");

        jLabel3.setText("Primer apellido:");

        jLabel4.setText("Cédula:");

        txtApellido.setToolTipText("Primer apellido");

        txtNombre.setToolTipText("Primer nombre");
        txtNombre.setActionCommand("<Not Set>");

        txtCedula.setToolTipText("Cédula sin espacios ni puntos");
        txtCedula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnValidar.setText("Validar");
        btnValidar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnValidar.setName("hola"); // NOI18N
        btnValidar.setNextFocusableComponent(btnAvanzar);
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        btnAvanzar.setText("Avanzar");
        btnAvanzar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAvanzar.setEnabled(false);
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar campos");
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setName("hola"); // NOI18N
        btnLimpiar.setNextFocusableComponent(btnAvanzar);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(btnValidar))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLimpiar)
                                .addGap(67, 67, 67)
                                .addComponent(btnAvanzar)))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValidar)
                    .addComponent(btnAvanzar)
                    .addComponent(btnLimpiar))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        cedula = Integer.parseInt(txtCedula.getText().trim());
        //System.out.println(cedula);
        //boolean participacion = validarParticipacion(cedula);
        //System.out.println(participacion);
        if (validarParticipacion(cedula)) {
            try {
                String nombre = txtNombre.getText().trim();
                String apellido = txtApellido.getText().trim();
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/elecciones", user, password);
                PreparedStatement pst = con.prepareStatement("SELECT * FROM votantes WHERE cedula = ?");
                pst.setInt(1, cedula);

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    nombreSys = rs.getString("pNombre");
                    apellidoSys = rs.getString("pApellido");
                    if (nombre.equalsIgnoreCase(nombreSys) && apellido.equalsIgnoreCase(apellidoSys)) {
                        JOptionPane.showMessageDialog(null, "Adelante, presiona avanzar");
                        txtNombre.setEnabled(false);
                        txtApellido.setEnabled(false);
                        txtCedula.setEnabled(false);
                        btnAvanzar.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos erróneos");
                        txtNombre.requestFocus();
                        txtApellido.requestFocus();
                        txtCedula.requestFocus();
                    }
                }

            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Datos incompletos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya votaste");
            limpiar();

        }
    }//GEN-LAST:event_btnValidarActionPerformed

    public boolean validarParticipacion(int cd) {
        boolean pt = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/elecciones", user, password);
            PreparedStatement pst = con.prepareStatement("select participacion from votantes where cedula = ?");

            pst.setInt(1, cd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int participacion = rs.getInt("participacion");
                pt = participacion != 1; // Asumiendo que 1 significa que el votante ya participó, y 0 significa que no lo hizo.
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return pt;
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    public void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtCedula.setEnabled(true);
    }

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        Sistema sistema = new Sistema();
        String dni = txtCedula.getText().trim();
        try {
            encriyptedDNI = DNICryptographer.encryptDNI(dni);
            Sistema.dni = encriyptedDNI;
            sistema.setVisible(true);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAvanzarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        DNICryptographer.initializeSecretKey();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    public static javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
