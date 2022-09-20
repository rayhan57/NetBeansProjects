/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Inventory;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author RLB
 */
public class TransaksiBarangMasuk extends javax.swing.JFrame {

    private final Connection conn = new Koneksi().konek();
    private Statement st;
    private ResultSet rs;
    private String sql = "";

    public String kodebarang, namabarang, hargabarang, kodesupplier, namasupplier, nohp;

    /**
     * Creates new form BarangMasuk
     */
    public TransaksiBarangMasuk() {
        initComponents();
        tampilData();
        kodeBarang();
        kodeSupplier();
    }

    private void tampilData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Harga Barang");
        model.addColumn("Kode Supplier");
        model.addColumn("Nama Supplier");
        model.addColumn("No Hp");

        try {
            int i = 1;
            st = conn.createStatement();
            sql = "SELECT * FROM transaksi_masuk";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    ("" + i++),
                    rs.getString("kode_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("tanggal_masuk"),
                    rs.getString("harga_barang"),
                    rs.getString("kode_supplier"),
                    rs.getString("nama_supplier"),
                    rs.getString("no_hp")
                });
                tabelBarangMasuk.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data");
        }
    }

    private void simpan() {
        kodebarang = String.valueOf(kodeBarang.getSelectedItem());
        namabarang = String.valueOf(namaBarang.getText());
        LocalDate tanggalmasuk = LocalDate.now();
        hargabarang = String.valueOf(hargaBarang.getText());
        kodesupplier = String.valueOf(kodeSupplier.getSelectedItem());
        namasupplier = String.valueOf(namaSupplier.getText());
        nohp = String.valueOf(noHp.getText());

        try {
            sql = "INSERT INTO transaksi_masuk VALUES" + "('" + kodebarang + "','" + namabarang + "','" + tanggalmasuk + "','" + hargabarang + "', '" + kodesupplier + "', '" + namasupplier + "', '" + nohp + "')";
            st = conn.createStatement();
            st.execute(sql);
            reset();
            tampilData();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan " + e);
        }
    }

    private void ubah() {
        kodebarang = String.valueOf(kodeBarang.getSelectedItem());
        namabarang = String.valueOf(namaBarang.getText());
        hargabarang = String.valueOf(hargaBarang.getText());
        kodesupplier = String.valueOf(kodeSupplier.getSelectedItem());
        namasupplier = String.valueOf(namaSupplier.getText());
        nohp = String.valueOf(noHp.getText());

        try {
            sql = "UPDATE transaksi_masuk SET nama_barang='" + namabarang + "', harga_barang='" + hargabarang + "', kode_supplier='" + kodesupplier + "', nama_supplier='" + namasupplier + "', no_hp='" + nohp + "' WHERE kode_barang='" + kodebarang + "'";
            st = conn.createStatement();
            st.execute(sql);
            reset();
            tampilData();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah " + e);
        }
    }

    private void hapus() {
        int row = tabelBarangMasuk.getSelectedRow();
        kodebarang = tabelBarangMasuk.getValueAt(row, 1).toString();
        namabarang = tabelBarangMasuk.getValueAt(row, 2).toString();

        int pilihan = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus " + namabarang + "?",
                "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (pilihan == JOptionPane.OK_OPTION) {
            try {
                sql = "DELETE FROM transaksi_masuk WHERE kode_barang='" + kodebarang + "'";
                st = conn.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, namabarang + " Berhasil Dihapus");
                tampilData();
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, namabarang + " Gagal Dihapus");
            }
        }
    }

    private void reset() {
        kodeBarang.setSelectedItem("Pilih Barang");
        namaBarang.setText("");
        hargaBarang.setText("");
        kodeSupplier.setSelectedItem("Pilih Supplier");
        namaSupplier.setText("");
        noHp.setText("");
    }

    private void kodeBarang() {
        try {
            sql = "SELECT * FROM data_barang";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                kodeBarang.addItem(rs.getString("kode_barang"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void kodeSupplier() {
        try {
            sql = "SELECT * FROM data_supplier";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                kodeSupplier.addItem(rs.getString("kode"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void kodeBarangTerpilih() {
        kodebarang = String.valueOf(kodeBarang.getSelectedItem());

        try {
            sql = "SELECT * FROM data_barang WHERE kode_barang='" + kodebarang + "'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                namaBarang.setText(rs.getString("nama_barang"));
                hargaBarang.setText(rs.getString("harga_satuan"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void kodeSupplierTerpilih() {
        kodesupplier = String.valueOf(kodeSupplier.getSelectedItem());

        try {
            sql = "SELECT * FROM data_supplier WHERE kode='" + kodesupplier + "'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                namaSupplier.setText(rs.getString("nama_supplier"));
                noHp.setText(rs.getString("no_hp"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarangMasuk = new javax.swing.JTable();
        btnKeluar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kodeBarang = new javax.swing.JComboBox<>();
        namaBarang = new javax.swing.JTextField();
        hargaBarang = new javax.swing.JTextField();
        kodeSupplier = new javax.swing.JComboBox<>();
        namaSupplier = new javax.swing.JTextField();
        noHp = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventory");

        jPanel1.setBackground(new java.awt.Color(86, 187, 241));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("BARANG MASUK");

        tabelBarangMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "Kode Barang", "Nama Barang", "Tanggal Masuk", "Harga Barang", "Kode Supplier", "Nama Supplier", "No Hp"
            }
        ));
        tabelBarangMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMasukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarangMasuk);

        btnKeluar.setBackground(new java.awt.Color(94, 230, 235));
        btnKeluar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Kode Barang");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nama Barang");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Harga Barang");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Kode Supplier");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nama Supplier");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("No Hp");

        kodeBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kodeBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Barang" }));
        kodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeBarangActionPerformed(evt);
            }
        });

        namaBarang.setEditable(false);
        namaBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        hargaBarang.setEditable(false);
        hargaBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        kodeSupplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kodeSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Supplier" }));
        kodeSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeSupplierActionPerformed(evt);
            }
        });

        namaSupplier.setEditable(false);
        namaSupplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        noHp.setEditable(false);
        noHp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSimpan.setBackground(new java.awt.Color(94, 230, 235));
        btnSimpan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(94, 230, 235));
        btnUbah.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(94, 230, 235));
        btnHapus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnCetak.setBackground(new java.awt.Color(94, 230, 235));
        btnCetak.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnCetak.setText("Cetak");
        btnCetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(namaBarang))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(22, 22, 22)
                                                    .addComponent(kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(125, 125, 125)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(4, 4, 4)))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(noHp, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(kodeSupplier, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(namaSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(btnSimpan)
                                .addGap(53, 53, 53)
                                .addComponent(btnUbah)
                                .addGap(46, 46, 46)
                                .addComponent(btnHapus)
                                .addGap(47, 47, 47)
                                .addComponent(btnKeluar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCetak)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(kodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(namaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(noHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        new MenuUtama().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        simpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        ubah();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void kodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeBarangActionPerformed
        kodebarang = String.valueOf(kodeBarang.getSelectedItem());

        if (kodebarang == "Pilih Barang") {
            namaBarang.setText("");
            hargaBarang.setText("");
        } else {
            kodeBarangTerpilih();
        }
    }//GEN-LAST:event_kodeBarangActionPerformed

    private void kodeSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeSupplierActionPerformed
        kodesupplier = String.valueOf(kodeSupplier.getSelectedItem());

        if (kodesupplier == "Pilih Supplier") {
            namaSupplier.setText("");
            noHp.setText("");
        } else {
            kodeSupplierTerpilih();
        }
    }//GEN-LAST:event_kodeSupplierActionPerformed

    private void tabelBarangMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMasukMouseClicked
        int row = tabelBarangMasuk.getSelectedRow();
        kodebarang = tabelBarangMasuk.getValueAt(row, 1).toString();
        kodeBarang.setSelectedItem(kodebarang);

        kodesupplier = tabelBarangMasuk.getValueAt(row, 5).toString();
        kodeSupplier.setSelectedItem(kodesupplier);
    }//GEN-LAST:event_tabelBarangMasukMouseClicked

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try {
            String namaFile = "src/Laporan/LaporanBarangMasuk.jasper";
            HashMap parameter = new HashMap();
            File report = new File(namaFile);
            JasperReport jr = (JasperReport) JRLoader.loadObject(report.getPath());
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, conn);
            JasperViewer.viewReport(jp, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnCetakActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiBarangMasuk.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiBarangMasuk.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiBarangMasuk.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiBarangMasuk.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiBarangMasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JTextField hargaBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kodeBarang;
    private javax.swing.JComboBox<String> kodeSupplier;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTextField namaSupplier;
    private javax.swing.JTextField noHp;
    private javax.swing.JTable tabelBarangMasuk;
    // End of variables declaration//GEN-END:variables
}
