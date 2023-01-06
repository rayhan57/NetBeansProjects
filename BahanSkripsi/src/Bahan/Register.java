/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bahan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author RLB
 */
public class Register extends javax.swing.JFrame {

    private final Connection conn = new Koneksi().konek();
    private Statement st;
    private ResultSet rs;
    private String sql;

    private String nama, username, password1, password2;

    /**
     * Creates new form Login2
     */
    public Register() {
        initComponents();
    }

    private void register() {
        nama = String.valueOf(inputNama.getText());
        username = String.valueOf(inputUsername.getText());
        password1 = String.valueOf(inputPassword.getPassword());
        password2 = String.valueOf(inputKonfirmasiPassword.getPassword());

        if (nama.equals("") || username.equals("") || password1.equals("") || password2.equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else if (!password1.equals(password2)) {
            JOptionPane.showMessageDialog(null, "Konfirmasi Password Tidak Sesuai");
        } else {
            try {
                cekAkun();
                sql = "INSERT INTO user VALUES" + "('" + nama + "','" + username + "','" + password1 + "')";
                st = conn.createStatement();
                st.execute(sql);
                reset();
                JOptionPane.showMessageDialog(null, "Berhasil Masuk");
                dispose();
                new Login().show();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    private void cekAkun() {
        try {
            sql = "SELECT * FROM user WHERE username='" + username + "'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                JOptionPane.showMessageDialog(null, "Username " + username + " sudah ada\nSilahkan Gunakan Username Lain");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void reset() {
        inputNama.setText("");
        inputUsername.setText("");
        inputPassword.setText("");
        inputKonfirmasiPassword.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputKonfirmasiPassword = new javax.swing.JPasswordField();
        inputPassword = new javax.swing.JPasswordField();
        inputUsername = new javax.swing.JTextField();
        inputNama = new javax.swing.JTextField();
        btnRegister = new javax.swing.JLabel();
        btnMasuk = new javax.swing.JLabel();
        template = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputKonfirmasiPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputKonfirmasiPassword.setBorder(null);
        getContentPane().add(inputKonfirmasiPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 375, 220, -1));

        inputPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputPassword.setBorder(null);
        getContentPane().add(inputPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 220, -1));

        inputUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputUsername.setBorder(null);
        getContentPane().add(inputUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 265, 220, -1));

        inputNama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputNama.setBorder(null);
        getContentPane().add(inputNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 220, -1));

        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });
        getContentPane().add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 441, 241, 30));

        btnMasuk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMasukMouseClicked(evt);
            }
        });
        getContentPane().add(btnMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 495, 43, 16));

        template.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Component/Register.png"))); // NOI18N
        getContentPane().add(template, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(800, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMasukMouseClicked
        new Login().show();
        dispose();
    }//GEN-LAST:event_btnMasukMouseClicked

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        register();
    }//GEN-LAST:event_btnRegisterMouseClicked

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnMasuk;
    private javax.swing.JLabel btnRegister;
    private javax.swing.JPasswordField inputKonfirmasiPassword;
    private javax.swing.JTextField inputNama;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JTextField inputUsername;
    private javax.swing.JLabel template;
    // End of variables declaration//GEN-END:variables
}
