/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SplashScreen;

import Inventory.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author RLB
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
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

        Background = new javax.swing.JLabel();
        Bar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loadingBar = new javax.swing.JProgressBar();
        persentase = new javax.swing.JLabel();
        loadingText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N

        Bar.setBackground(new java.awt.Color(77, 119, 255));
        Bar.setPreferredSize(new java.awt.Dimension(800, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Inventory");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Version 1.0.0");

        loadingBar.setForeground(new java.awt.Color(51, 204, 255));

        persentase.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        persentase.setForeground(new java.awt.Color(255, 255, 255));
        persentase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        persentase.setText("0%");

        loadingText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loadingText.setForeground(new java.awt.Color(255, 255, 255));
        loadingText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadingText.setText("Loading...");

        javax.swing.GroupLayout BarLayout = new javax.swing.GroupLayout(Bar);
        Bar.setLayout(BarLayout);
        BarLayout.setHorizontalGroup(
            BarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarLayout.createSequentialGroup()
                .addGroup(BarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BarLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                        .addGroup(BarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loadingBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarLayout.createSequentialGroup()
                                .addComponent(loadingText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(persentase))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        BarLayout.setVerticalGroup(
            BarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarLayout.createSequentialGroup()
                .addGroup(BarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(BarLayout.createSequentialGroup()
                        .addGroup(BarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(persentase)
                            .addComponent(loadingText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background)
            .addComponent(Bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Background)
                .addGap(0, 0, 0)
                .addComponent(Bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(800, 400));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SplashScreen splash = new SplashScreen();
        splash.setVisible(true);

        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(20);
                splash.persentase.setText(i + "%");

                if (i == 0) {
                    splash.loadingText.setText("Menyalakan Module...");
                }
                if (i == 30) {
                    splash.loadingText.setText("Memuat Module...");
                    Thread.sleep(1000);
                }
                if (i == 50) {
                    splash.loadingText.setText("Menyambungkan ke Database...");
                    Thread.sleep(1000);
                }
                if (i == 70) {
                    splash.loadingText.setText("Menyiapkan Aplikasi...");
                    Thread.sleep(1000);
                }
                if (i == 80) {
                    splash.loadingText.setText("Membuka Aplikasi...");
                }
                if (i == 100) {
                    Thread.sleep(2000);
                    splash.dispose();
                    new Login().setVisible(true);
                }
                splash.loadingBar.setValue(i);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JPanel Bar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JProgressBar loadingBar;
    private javax.swing.JLabel loadingText;
    private javax.swing.JLabel persentase;
    // End of variables declaration//GEN-END:variables
}
