/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetShop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author RLB
 */
public class FormUbahMakanan extends javax.swing.JFrame {

    private final Connection conn = new Koneksi().konek();
    private Statement st;
    private ResultSet rs;
    private String sql;

    int jumlahbeli, hargasatuan, total;
    String namamakanan, varian;
    public String id;
    DecimalFormat df = new DecimalFormat();

    /**
     * Creates new form FormBeli
     */
    public FormUbahMakanan() {
        initComponents();

    }

    private void totalharga() {
        jumlahbeli = Integer.parseInt(jumlahBeli.getValue().toString());
        hargasatuan = Integer.parseInt(hargaSatuan.getText());

        total = jumlahbeli * hargasatuan;
        totalHarga.setText("" + total);
    }

    private void selesai() {
        namamakanan = String.valueOf(namaMakanan.getText());
        varian = String.valueOf(varianRasa.getSelectedItem());
        jumlahbeli = Integer.valueOf(jumlahBeli.getValue().toString());
        hargasatuan = Integer.valueOf(hargaSatuan.getText());
        total = Integer.valueOf(totalHarga.getText());
        String formatharga = "Rp. " + df.format(total);

        try {
            sql = "UPDATE makanan SET nama_makanan='" + namamakanan + "', varian='" + varian + "',  jumlah='" + jumlahbeli + "', harga='" + total + "', format_harga='" + formatharga + "', harga_satuan='" + hargasatuan + "'WHERE id='" + id + "'";
            st = conn.createStatement();
            st.execute(sql);
            this.dispose();
            new Makanan().setVisible(false);
            new Pembelian().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Dimasukan " + e);
        }
    }

    private void hapus() {
        namamakanan = String.valueOf(namaMakanan.getText());

        int pilihan = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus " + namamakanan + "?",
                "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (pilihan == JOptionPane.OK_OPTION) {
            try {
                sql = "DELETE FROM makanan WHERE id='" + id + "'";
                st = conn.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, namamakanan + " Dihapus");
                this.dispose();
                new Pembelian().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, namamakanan + " Gagal Dihapus");
            }
        }
    }

    void varianRasa() {
        namamakanan = String.valueOf(namaMakanan.getText());
        Makanan m = new Makanan();

        if (namamakanan.equals("Bolt")) {
            for (String i : m.bolt) {
                varianRasa.addItem(i);
            }
        } else if (namamakanan.equals("Cat Choize")) {
            for (String i : m.catchoize) {
                varianRasa.addItem(i);
            }
        } else if (namamakanan.equals("Excel")) {
            for (String i : m.excel) {
                varianRasa.addItem(i);
            }
        } else if (namamakanan.equals("Felibite")) {
            for (String i : m.felibite) {
                varianRasa.addItem(i);
            }
        } else if (namamakanan.equals("Royal Canin")) {
            for (String i : m.royalcanin) {
                varianRasa.addItem(i);
            }
        } else if (namamakanan.equals("Whiskas")) {
            for (String i : m.whiskas) {
                varianRasa.addItem(i);
            }
        }
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
        totalHarga = new javax.swing.JTextField();
        namaMakanan = new javax.swing.JTextField();
        varianRasa = new javax.swing.JComboBox<>();
        btnSelesai = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        hargaSatuan = new javax.swing.JTextField();
        jumlahBeli = new javax.swing.JSpinner();
        btnKembali = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 120, 170));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total Harga");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama Makanan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Varian");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Harga Satuan");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        totalHarga.setEditable(false);
        totalHarga.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(totalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 160, -1));

        namaMakanan.setEditable(false);
        namaMakanan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(namaMakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 160, -1));

        varianRasa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(varianRasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 160, -1));

        btnSelesai.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnSelesai.setText("Selesai");
        btnSelesai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnSelesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jumlah Beli");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        hargaSatuan.setEditable(false);
        hargaSatuan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(hargaSatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 160, -1));

        jumlahBeli.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jumlahBeli.setModel(new javax.swing.SpinnerNumberModel(0, null, 10, 1));
        jumlahBeli.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jumlahBeliStateChanged(evt);
            }
        });
        jPanel1.add(jumlahBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 60, -1));

        btnKembali.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        jPanel1.add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 360, -1));

        btnHapus.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 180, -1));

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

        setSize(new java.awt.Dimension(400, 350));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jumlahBeliStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jumlahBeliStateChanged
        totalharga();
    }//GEN-LAST:event_jumlahBeliStateChanged

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        dispose();
        varianRasa.removeAllItems();
        jumlahBeli.setValue(0);
        totalHarga.setText("");
        new Pembelian().setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        selesai();
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(FormUbahMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUbahMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUbahMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUbahMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUbahMakanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSelesai;
    public javax.swing.JTextField hargaSatuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JSpinner jumlahBeli;
    public javax.swing.JTextField namaMakanan;
    public javax.swing.JTextField totalHarga;
    public javax.swing.JComboBox<String> varianRasa;
    // End of variables declaration//GEN-END:variables
}
