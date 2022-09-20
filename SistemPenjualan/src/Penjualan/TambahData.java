/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Penjualan;

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
public class TambahData extends javax.swing.JFrame {

    private final Connection conn = new Koneksi().konek();
    private Statement st;
    private ResultSet rs;
    private String sql;

    DecimalFormat df = new DecimalFormat();
    private String kodebarang, kategori, namabarang, formatharga;
    private double hargabarang;

    /**
     * Creates new form TambahData
     */
    public TambahData() {
        initComponents();
        DataBarang();
        KodeBarang();
        tabelBarang.setAutoCreateRowSorter(true);
    }

    private void DataBarang() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Barang");
        model.addColumn("Kategori Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Barang");

        try {
            sql = "SELECT * FROM data_barang";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("kode_barang"),
                    rs.getString("kategori_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("format_harga_satuan")
                });
                tabelBarang.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data " + e);
        }
    }

    private void KodeBarang() {
        try {
            sql = "SELECT * FROM data_barang ORDER BY kode_barang DESC";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String kode = rs.getString("kode_barang").substring(3);
                String id = "" + (Integer.parseInt(kode) + 1);
                String nol = "";

                if (id.length() == 1) {
                    nol = "00";
                } else if (id.length() == 2) {
                    nol = "0";
                } else {
                    nol = "";
                }
                kodeBarang.setText("KB-" + nol + id);
            } else {
                kodeBarang.setText("KB-001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void TambahBarang() {
        kodebarang = String.valueOf(kodeBarang.getText());
        kategori = String.valueOf(kategoriBarang.getSelectedItem());
        namabarang = String.valueOf(namaBarang.getText());
        formatharga = "Rp. " + df.format(hargabarang);

        if (kategori.equals("Pilih Barang") || namabarang.equals("") || hargaBarang.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                sql = "INSERT INTO data_barang VALUES" + "('" + kodebarang + "','" + kategori + "','" + namabarang + "','" + hargabarang + "','" + formatharga + "')";
                st = conn.createStatement();
                st.execute(sql);
                reset();
                KodeBarang();
                DataBarang();
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan " + e);
            }
        }
    }

    private void UbahBarang() {
        kodebarang = String.valueOf(kodeBarang.getText());
        kategori = String.valueOf(kategoriBarang.getSelectedItem());
        namabarang = String.valueOf(namaBarang.getText());
        formatharga = "Rp. " + df.format(hargabarang);

        try {
            sql = "UPDATE data_barang SET kategori_barang='" + kategori + "', nama_barang='" + namabarang + "',  harga_barang='" + hargabarang + "', format_harga_satuan='" + formatharga + "'WHERE kode_barang='" + kodebarang + "'";
            st = conn.createStatement();
            st.execute(sql);
            reset();
            KodeBarang();
            DataBarang();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah " + e);
        }
    }

    private void HapusBarang() {
        int row = tabelBarang.getSelectedRow();
        String kodebarang = tabelBarang.getValueAt(row, 0).toString();
        String namabarang = tabelBarang.getValueAt(row, 2).toString();

        int pilihan = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus " + namabarang + "?",
                "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (pilihan == JOptionPane.OK_OPTION) {
            try {
                sql = "DELETE FROM data_barang WHERE kode_barang='" + kodebarang + "'";
                st = conn.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, namabarang + " Berhasil Dihapus");
                KodeBarang();
                DataBarang();
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, namabarang + " Gagal Dihapus");
            }
        }
    }

    private void CariBarang() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Barang");
        model.addColumn("Kategori Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Barang");

        try {
            sql = "SELECT * FROM data_barang WHERE nama_barang LIKE '%" + cariBarang.getText() + "%' OR kategori_barang LIKE '%" + cariBarang.getText() + "%'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("kode_barang"),
                    rs.getString("kategori_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("format_harga_satuan")
                });
            }
            tabelBarang.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak Dapat Mencari Data");
        }
    }

    private void reset() {
        kategoriBarang.setSelectedItem("Pilih Kategori");
        namaBarang.setText("");
        hargaBarang.setText("");
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
        hargaBarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kodeBarang = new javax.swing.JTextField();
        cariBarang = new javax.swing.JTextField();
        kategoriBarang = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        namaBarang = new javax.swing.JTextField();
        btnDataTransaksi = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PetShop");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TAMBAH DATA BARANG");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1200, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Cari Barang");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, -1, -1));

        hargaBarang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        hargaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hargaBarangKeyReleased(evt);
            }
        });
        jPanel1.add(hargaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 160, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Kode Barang");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Kategori Barang");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Nama Barang");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        kodeBarang.setEditable(false);
        kodeBarang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(kodeBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 120, -1));

        cariBarang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cariBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariBarangKeyReleased(evt);
            }
        });
        jPanel1.add(cariBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 230, -1));

        kategoriBarang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kategoriBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kategori", "Makanan", "Pasir", "Vitamin/Obat", "Perlengkapan" }));
        kategoriBarang.setToolTipText("");
        jPanel1.add(kategoriBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 160, -1));

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Kategori Barang", "Nama Barang", "Harga Barang"
            }
        ));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 700, 370));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Harga Barang");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        namaBarang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(namaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 260, -1));

        btnDataTransaksi.setBackground(new java.awt.Color(6, 255, 0));
        btnDataTransaksi.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnDataTransaksi.setText("Data Transaksi");
        btnDataTransaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDataTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDataTransaksiMouseClicked(evt);
            }
        });
        jPanel1.add(btnDataTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 430, 80));

        btnTambah.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tambah.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 430, -1));

        btnUbah.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ubah.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel1.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 430, -1));

        btnHapus.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hapus.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 430, -1));

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

        jLabel7.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pet");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jLabel8.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 51));
        jLabel8.setText("Shop");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 30));

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

        setSize(new java.awt.Dimension(1200, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDataTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDataTransaksiMouseClicked
        new DataTransaksi().show();
        this.dispose();
    }//GEN-LAST:event_btnDataTransaksiMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        TambahBarang();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void hargaBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaBarangKeyReleased
        hargabarang = Double.valueOf(hargaBarang.getText().replaceAll("\\,", ""));
        hargaBarang.setText(df.format(hargabarang));
    }//GEN-LAST:event_hargaBarangKeyReleased

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        UbahBarang();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        try {
            int row = tabelBarang.getSelectedRow();
            kodebarang = tabelBarang.getValueAt(row, 0).toString();
            kodeBarang.setText(kodebarang);

            sql = "SELECT * FROM data_barang WHERE kode_barang='" + kodebarang + "'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                namaBarang.setText(rs.getString("nama_barang"));
                kategoriBarang.setSelectedItem(rs.getString("kategori_barang"));
                hargaBarang.setText(rs.getString("harga_barang"));
            }
        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan" + e);
        }
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        HapusBarang();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void cariBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariBarangKeyReleased
        CariBarang();
    }//GEN-LAST:event_cariBarangKeyReleased

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
            java.util.logging.Logger.getLogger(TambahData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahData().setVisible(true);
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
    private javax.swing.JTextField cariBarang;
    private javax.swing.JTextField hargaBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kategoriBarang;
    private javax.swing.JTextField kodeBarang;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTable tabelBarang;
    // End of variables declaration//GEN-END:variables
}
