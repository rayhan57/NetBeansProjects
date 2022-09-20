/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Penjualan;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RLB
 */
public class DaftarMandi extends javax.swing.JFrame {

    private final Connection conn = new Koneksi().konek();
    private Statement st;
    private ResultSet rs;
    private String sql;

    DecimalFormat df = new DecimalFormat();
    private String noantrian, namapemilik, namahewan, jenismandi, formatharga;
    private double hargamandi;

    /**
     * Creates new form DaftarMandi
     */
    public DaftarMandi() {
        initComponents();
        DaftarMandi();
        NoAntrian();
    }

    private void DaftarMandi() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama Pemilik");
        model.addColumn("Nama Hewan");
        model.addColumn("Jenis Mandi");
        model.addColumn("Harga");

        try {
            sql = "SELECT * FROM daftar_mandi";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("no_antrian"),
                    rs.getString("nama_pemilik"),
                    rs.getString("nama_hewan"),
                    rs.getString("jenis_mandi"),
                    rs.getString("format_harga")
                });
                tabelAntrian.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data " + e);
        }
    }

    private void NoAntrian() {
        try {
            sql = "SELECT * FROM daftar_mandi ORDER BY no_antrian DESC";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String kode = rs.getString("no_antrian");
                String no = "" + (Integer.parseInt(kode) + 1);
                noantrian = no;
            } else {
                noantrian = "1";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void TambahAntrian() {
        namapemilik = String.valueOf(namaPemilik.getText());
        jenismandi = String.valueOf(jenisMandi.getSelectedItem());
        namahewan = String.valueOf(namaHewan.getText());
        formatharga = "Rp. " + df.format(hargamandi);

        if (jenismandi.equals("Jenis Mandi") || namapemilik.equals("") || namahewan.equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                sql = "INSERT INTO daftar_mandi VALUES" + "('" + noantrian + "', '" + namapemilik + "','" + namahewan + "','" + jenismandi + "','" + hargamandi + "','" + formatharga + "')";
                st = conn.createStatement();
                st.execute(sql);
                NoAntrian();
                reset();
                DaftarMandi();
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan " + e);
            }
        }
    }

    private void UbahAntrian() {
        namapemilik = String.valueOf(namaPemilik.getText());
        jenismandi = String.valueOf(jenisMandi.getSelectedItem());
        namahewan = String.valueOf(namaHewan.getText());
        formatharga = "Rp. " + df.format(hargamandi);

        try {
            sql = "UPDATE daftar_mandi SET nama_pemilik='" + namapemilik + "', nama_hewan='" + namahewan + "', jenis_mandi='" + jenismandi + "', harga='" + hargamandi + "', format_harga='" + formatharga + "'WHERE no_antrian='" + noantrian + "'";
            st = conn.createStatement();
            st.execute(sql);
            NoAntrian();
            reset();
            DaftarMandi();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah " + e);
        }
    }

    private void HapusAntrian() {
        int row = tabelAntrian.getSelectedRow();
        namahewan = tabelAntrian.getValueAt(row, 2).toString();
        noantrian = tabelAntrian.getValueAt(row, 0).toString();

        int pilihan = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus " + namahewan + "?",
                "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (pilihan == JOptionPane.OK_OPTION) {
            try {
                sql = "DELETE FROM daftar_mandi WHERE no_antrian='" + noantrian + "'";
                st = conn.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, namahewan + " Berhasil Dihapus");
                NoAntrian();
                DaftarMandi();
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, namahewan + " Gagal Dihapus");
            }
        }
    }

    private void reset() {
        jenisMandi.setSelectedItem("Pilih Jenis");
        namaPemilik.setText("");
        namaHewan.setText("");
        harga.setText("");
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
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        harga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jenisMandi = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        namaPemilik = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        namaHewan = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnDataTransaksi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelAntrian = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PetShop");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DAFTAR MANDI");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1200, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Harga");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1200, 10));

        harga.setEditable(false);
        harga.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 190, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Nama Pemilik");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jenisMandi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jenisMandi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis", "Mandi Biasa", "Mandi Kutu", "Mandi Jamur", "Mandi Lengkap" }));
        jenisMandi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisMandiActionPerformed(evt);
            }
        });
        jPanel1.add(jenisMandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Jenis Mandi");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        namaPemilik.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(namaPemilik, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 190, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Nama Hewan");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        namaHewan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(namaHewan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 190, -1));

        btnHapus.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hapus.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 380, -1));

        btnTambah.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tambah.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 380, -1));

        btnUbah.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ubah.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel1.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 380, -1));

        btnDataTransaksi.setBackground(new java.awt.Color(6, 255, 0));
        btnDataTransaksi.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnDataTransaksi.setText("Data Transaksi");
        btnDataTransaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDataTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDataTransaksiMouseClicked(evt);
            }
        });
        btnDataTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataTransaksiActionPerformed(evt);
            }
        });
        jPanel1.add(btnDataTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 380, 80));

        tabelAntrian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama Pemilik", "Nama Hewan", "Jenis Mandi", "Harga"
            }
        ));
        tabelAntrian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelAntrianMouseClicked(evt);
            }
        });
        tabelAntrian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelAntrianKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelAntrian);
        if (tabelAntrian.getColumnModel().getColumnCount() > 0) {
            tabelAntrian.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 680, 430));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        jPanel2.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 30, 30));

        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });
        jPanel2.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 30, 30));

        jLabel2.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 51));
        jLabel2.setText("Shop");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        jLabel7.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pet");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1200, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDataTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDataTransaksiMouseClicked
        new DataTransaksi().show();
        this.dispose();
    }//GEN-LAST:event_btnDataTransaksiMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        TambahAntrian();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        UbahAntrian();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        HapusAntrian();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jenisMandiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisMandiActionPerformed
        jenismandi = String.valueOf(jenisMandi.getSelectedItem());

        if (jenismandi.equals("Mandi Biasa")) {
            hargamandi = 50000;
        } else if (jenismandi.equals("Mandi kutu")) {
            hargamandi = 60000;
        } else if (jenismandi.equals("Mandi Jamur")) {
            hargamandi = 60000;
        } else {
            hargamandi = 70000;
        }
        harga.setText("Rp. " + df.format(hargamandi));
    }//GEN-LAST:event_jenisMandiActionPerformed

    private void tabelAntrianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelAntrianMouseClicked
        try {
            int row = tabelAntrian.getSelectedRow();
            namahewan = tabelAntrian.getValueAt(row, 2).toString();
            namaHewan.setText(namahewan);

            sql = "SELECT * FROM daftar_mandi WHERE nama_hewan='" + namahewan + "'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                namaPemilik.setText(rs.getString("nama_pemilik"));
                jenisMandi.setSelectedItem(rs.getString("jenis_mandi"));
                harga.setText(rs.getString("harga"));
            }
        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan" + e);
        }
    }//GEN-LAST:event_tabelAntrianMouseClicked

    private void tabelAntrianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelAntrianKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            HapusAntrian();
        }
    }//GEN-LAST:event_tabelAntrianKeyReleased

    private void btnDataTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataTransaksiActionPerformed
        new TransaksiMandi().show();
        this.dispose();
    }//GEN-LAST:event_btnDataTransaksiActionPerformed

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setExtendedState(DataTransaksi.ICONIFIED);
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
            java.util.logging.Logger.getLogger(DaftarMandi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarMandi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarMandi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarMandi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarMandi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JButton btnDataTransaksi;
    private javax.swing.JButton btnHapus;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jenisMandi;
    private javax.swing.JTextField namaHewan;
    private javax.swing.JTextField namaPemilik;
    private javax.swing.JTable tabelAntrian;
    // End of variables declaration//GEN-END:variables
}
