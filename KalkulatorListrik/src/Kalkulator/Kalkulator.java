/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kalkulator;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author RLB
 */
public class Kalkulator extends javax.swing.JFrame {

    private final Connection conn = new Koneksi().konek();
    private Statement st;
    private ResultSet rs;
    private String sql;

    private double perkwh, dayalistrik, jam, sehari, seminggu, sebulan;
    private String no, perkwh2, dayalistrik2, jam2, sehari2, seminggu2, sebulan2;

    DecimalFormat df = new DecimalFormat();
    Hasil hasil = new Hasil();

    /**
     * Creates new form Kalkulator
     */
    public Kalkulator() {
        initComponents();
        noAuto();
    }

    private void noAuto() {
        try {
            sql = "SELECT * FROM riwayat ORDER BY no DESC";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String getNo = rs.getString("no");
                String addNo = "" + (Integer.parseInt(getNo) + 1);
                no = addNo;
            } else {
                no = "1";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void cekData() {
        String txtPerkwh = String.valueOf(hargaPerkwh.getText());
        String txtdayalistrik = String.valueOf(dayaListrik.getText());
        String txtjam = String.valueOf(wakuPemakaian.getText());

        if (txtPerkwh.equals("Harga Perkwh") || txtdayalistrik.equals("Daya Listrik") || txtjam.equals("Waktu Pemakaian")) {
            JOptionPane.showMessageDialog(null, "Ada data belum diisi", "Pesan", JOptionPane.WARNING_MESSAGE);
        } else {
            Biaya();
        }
    }

    private void Biaya() {
        perkwh = Double.valueOf(hargaPerkwh.getText());
        dayalistrik = Double.valueOf(dayaListrik.getText());
        jam = Double.valueOf(wakuPemakaian.getText());

        sehari = (dayalistrik * jam) / 1000 * perkwh;
        seminggu = (dayalistrik * jam * 7) / 1000 * perkwh;
        sebulan = (dayalistrik * jam * 30) / 1000 * perkwh;

        perkwh2 = "Rp." + df.format(perkwh);
        dayalistrik2 = String.valueOf(dayaListrik.getText() + " Watt");
        jam2 = String.valueOf(wakuPemakaian.getText() + " Jam");
        sehari2 = "Rp." + df.format(sehari);
        seminggu2 = "Rp." + df.format(seminggu);
        sebulan2 = "Rp." + df.format(sebulan);

        try {
            sql = "INSERT INTO riwayat VALUES" + "('" + no + "', '" + perkwh2 + "','" + dayalistrik2 + "','" + jam2 + "','" + sehari2 + "','" + seminggu2 + "','" + sebulan2 + "')";
            st = conn.createStatement();
            st.execute(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        hasil.satuHari.setText(sehari2);
        hasil.tujuhHari.setText(seminggu2);
        hasil.tigapuluhHari.setText(sebulan2);

        noAuto();
        hasil.show();
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        hargaPerkwh = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        dayaListrik = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        wakuPemakaian = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnHitung = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRiwayat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kalkulator Listrik");
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(154, 220, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PERHITUNGAN BIAYA LISTRIK");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 800, -1));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png"))); // NOI18N
        jLabel3.setText("Kalkulator Listrik");

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btnClose.setToolTipText("Keluar");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        btnMinimize.setToolTipText("Perkecil");
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 552, Short.MAX_VALUE)
                .addComponent(btnMinimize)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 25));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 100));

        jPanel3.setBackground(new java.awt.Color(255, 248, 154));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hargaPerkwh.setBackground(new java.awt.Color(255, 248, 154));
        hargaPerkwh.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        hargaPerkwh.setForeground(new java.awt.Color(204, 204, 204));
        hargaPerkwh.setText("Harga Perkwh");
        hargaPerkwh.setBorder(null);
        hargaPerkwh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hargaPerkwhFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hargaPerkwhFocusLost(evt);
            }
        });
        hargaPerkwh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hargaPerkwhKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaPerkwhKeyTyped(evt);
            }
        });
        jPanel3.add(hargaPerkwh, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 290, -1));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 55, 320, 1));

        dayaListrik.setBackground(new java.awt.Color(255, 248, 154));
        dayaListrik.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        dayaListrik.setForeground(new java.awt.Color(204, 204, 204));
        dayaListrik.setText("Daya Listrik");
        dayaListrik.setBorder(null);
        dayaListrik.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dayaListrikFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dayaListrikFocusLost(evt);
            }
        });
        dayaListrik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dayaListrikKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dayaListrikKeyTyped(evt);
            }
        });
        jPanel3.add(dayaListrik, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 320, -1));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 125, 320, 1));

        wakuPemakaian.setBackground(new java.awt.Color(255, 248, 154));
        wakuPemakaian.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        wakuPemakaian.setForeground(new java.awt.Color(204, 204, 204));
        wakuPemakaian.setText("Waktu Pemakaian");
        wakuPemakaian.setBorder(null);
        wakuPemakaian.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                wakuPemakaianFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                wakuPemakaianFocusLost(evt);
            }
        });
        wakuPemakaian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                wakuPemakaianKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                wakuPemakaianKeyTyped(evt);
            }
        });
        jPanel3.add(wakuPemakaian, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 320, -1));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 195, 320, 1));

        btnHitung.setBackground(new java.awt.Color(154, 220, 255));
        btnHitung.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btnHitung.setText("Hitung");
        btnHitung.setBorder(null);
        btnHitung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });
        jPanel3.add(btnHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 320, 40));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel2.setText("Jam");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel4.setText("Rp");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        btnRiwayat.setBackground(new java.awt.Color(255, 178, 166));
        btnRiwayat.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnRiwayat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/history.png"))); // NOI18N
        btnRiwayat.setToolTipText("Riwayat");
        btnRiwayat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRiwayatActionPerformed(evt);
            }
        });
        jPanel3.add(btnRiwayat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel5.setText("Watt");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel6.setText("Watt");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 810, 330));

        setSize(new java.awt.Dimension(800, 420));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void hargaPerkwhFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hargaPerkwhFocusGained
        if (hargaPerkwh.getText().equals("Harga Perkwh")) {
            hargaPerkwh.setText("");
            hargaPerkwh.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_hargaPerkwhFocusGained

    private void hargaPerkwhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hargaPerkwhFocusLost
        if (hargaPerkwh.getText().equals("")) {
            hargaPerkwh.setText("Harga Perkwh");
            hargaPerkwh.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_hargaPerkwhFocusLost

    private void dayaListrikFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dayaListrikFocusGained
        if (dayaListrik.getText().equals("Daya Listrik")) {
            dayaListrik.setText("");
            dayaListrik.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_dayaListrikFocusGained

    private void dayaListrikFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dayaListrikFocusLost
        if (dayaListrik.getText().equals("")) {
            dayaListrik.setText("Daya Listrik");
            dayaListrik.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_dayaListrikFocusLost

    private void wakuPemakaianFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_wakuPemakaianFocusGained
        if (wakuPemakaian.getText().equals("Waktu Pemakaian")) {
            wakuPemakaian.setText("");
            wakuPemakaian.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_wakuPemakaianFocusGained

    private void wakuPemakaianFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_wakuPemakaianFocusLost
        if (wakuPemakaian.getText().equals("")) {
            wakuPemakaian.setText("Waktu Pemakaian");
            wakuPemakaian.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_wakuPemakaianFocusLost

    private void hargaPerkwhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaPerkwhKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_hargaPerkwhKeyTyped

    private void dayaListrikKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dayaListrikKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_dayaListrikKeyTyped

    private void wakuPemakaianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wakuPemakaianKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_wakuPemakaianKeyTyped

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        cekData();
    }//GEN-LAST:event_btnHitungActionPerformed

    private void dayaListrikKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dayaListrikKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            wakuPemakaian.requestFocus();
        }
    }//GEN-LAST:event_dayaListrikKeyReleased

    private void wakuPemakaianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wakuPemakaianKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Biaya();
        }
    }//GEN-LAST:event_wakuPemakaianKeyReleased

    private void hargaPerkwhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaPerkwhKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dayaListrik.requestFocus();
        }
    }//GEN-LAST:event_hargaPerkwhKeyReleased

    private void btnRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRiwayatActionPerformed
        new Riwayat().show();
        this.dispose();
    }//GEN-LAST:event_btnRiwayatActionPerformed

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setExtendedState(Kalkulator.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

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
            java.util.logging.Logger.getLogger(Kalkulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kalkulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kalkulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kalkulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kalkulator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JButton btnHitung;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JButton btnRiwayat;
    private javax.swing.JTextField dayaListrik;
    private javax.swing.JTextField hargaPerkwh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField wakuPemakaian;
    // End of variables declaration//GEN-END:variables
}
