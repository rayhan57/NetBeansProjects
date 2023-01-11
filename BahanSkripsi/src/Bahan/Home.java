/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bahan;

import java.awt.Frame;

/**
 *
 * @author RLB
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu6 = new javax.swing.JLabel();
        Menu5 = new javax.swing.JLabel();
        Menu4 = new javax.swing.JLabel();
        Menu3 = new javax.swing.JLabel();
        Menu2 = new javax.swing.JLabel();
        Menu1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        template = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu6MouseClicked(evt);
            }
        });
        getContentPane().add(Menu6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 398, 270, 280));

        Menu5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu5MouseClicked(evt);
            }
        });
        getContentPane().add(Menu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 398, 270, 280));

        Menu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu4MouseClicked(evt);
            }
        });
        getContentPane().add(Menu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 398, 270, 280));

        Menu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu3MouseClicked(evt);
            }
        });
        getContentPane().add(Menu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, 270, 280));

        Menu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu2MouseClicked(evt);
            }
        });
        getContentPane().add(Menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 80, 270, 280));

        Menu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu1MouseClicked(evt);
            }
        });
        getContentPane().add(Menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 82, 270, 280));

        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 650, 110, 35));

        btnMinimize.setToolTipText("Perkecil");
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });
        getContentPane().add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 35, 35));

        btnClose.setToolTipText("Tutup");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1235, 0, 35, 35));

        template.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Component/Home.png"))); // NOI18N
        getContentPane().add(template, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        dispose();
        new Login().show();
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void Menu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Menu1MouseClicked

    private void Menu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Menu2MouseClicked

    private void Menu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Menu3MouseClicked

    private void Menu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Menu4MouseClicked

    private void Menu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Menu5MouseClicked

    private void Menu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Menu6MouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Menu1;
    private javax.swing.JLabel Menu2;
    private javax.swing.JLabel Menu3;
    private javax.swing.JLabel Menu4;
    private javax.swing.JLabel Menu5;
    private javax.swing.JLabel Menu6;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel template;
    // End of variables declaration//GEN-END:variables
}