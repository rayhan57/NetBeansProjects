/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
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
public class TransaksiPembelian extends javax.swing.JFrame {

    private final Connection conn = new Koneksi().konek();
    private Statement st;
    private ResultSet rs;
    private String sql = "";

    public String kodebarang, namabarang, kodecustomer, namacustomer, kota, nohp, hargabarang, totalharga;
    public int jumlahbeli, harga, tharga, stokbarang, hargasatuan;
    DecimalFormat df = new DecimalFormat();

    /**
     * Creates new form TransaksiPembelian
     */
    public TransaksiPembelian() {
        initComponents();
        tampilData();
        kodeBarang();
        kodeCustomer();
    }

    private void tampilData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Barang");
        model.addColumn("Jumlah Beli");
        model.addColumn("Total Harga");
        model.addColumn("Kode Customer");
        model.addColumn("Nama Customer");
        model.addColumn("Kota");
        model.addColumn("No Hp");

        try {
            int i = 1;
            st = conn.createStatement();
            sql = "SELECT * FROM transaksi_pembelian";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    ("" + i++),
                    rs.getString("kode_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("harga_barang"),
                    rs.getString("jumlah_beli"),
                    rs.getString("total_harga"),
                    rs.getString("kode_customer"),
                    rs.getString("nama_customer"),
                    rs.getString("kota"),
                    rs.getString("no_hp")
                });
                tabelPembelian.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data " + e);
        }
    }

    private void simpan() {
        kodebarang = String.valueOf(kodeBarang.getSelectedItem());
        namabarang = String.valueOf(namaBarang.getText());
        harga = Integer.parseInt(hargaBarang.getText());
        jumlahbeli = Integer.parseInt((String) jumlahBeli.getSelectedItem());
        tharga = harga * jumlahbeli;
        kodecustomer = String.valueOf(kodeCustomer.getSelectedItem());
        namacustomer = String.valueOf(namaCustomer.getText());
        kota = String.valueOf(kotaCustomer.getText());
        nohp = String.valueOf(noHp.getText());
        hargabarang = "Rp. " + df.format(harga);
        totalharga = "Rp. " + df.format(tharga);

        try {
            sql = "INSERT INTO transaksi_pembelian VALUES" + "('" + kodebarang + "','" + namabarang + "','" + hargabarang + "','" + jumlahbeli + "', '" + totalharga + "', '" + kodecustomer + "', '" + namacustomer + "', '" + kota + "', '" + nohp + "')";
            st = conn.createStatement();
            st.execute(sql);
            stokBarang();
            reset();
            tampilData();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan " + e);
        }
    }

    private void stokBarang() {
        kodebarang = String.valueOf(kodeBarang.getSelectedItem());
        jumlahbeli = Integer.parseInt((String) jumlahBeli.getSelectedItem());
        hargasatuan = Integer.parseInt(hargaBarang.getText());

        try {
            sql = "SELECT * FROM data_barang WHERE kode_barang='" + kodebarang + "'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                stokbarang = Integer.parseInt(rs.getString("stok_barang"));
            }

            stokbarang -= jumlahbeli;
            harga = hargasatuan * stokbarang;
            totalharga = "Rp. " + df.format(harga);
            sql = "UPDATE data_barang SET stok_barang='" + stokbarang + "', total_harga='" + totalharga + "'WHERE kode_barang='" + kodebarang + "'";
            st = conn.createStatement();
            st.execute(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void ubah() {
        kodebarang = String.valueOf(kodeBarang.getSelectedItem());
        namabarang = String.valueOf(namaBarang.getText());
        harga = Integer.parseInt(hargaBarang.getText());
        jumlahbeli = Integer.parseInt((String) jumlahBeli.getSelectedItem());
        tharga = harga * jumlahbeli;
        kodecustomer = String.valueOf(kodeCustomer.getSelectedItem());
        namacustomer = String.valueOf(namaCustomer.getText());
        kota = String.valueOf(kotaCustomer.getText());
        nohp = String.valueOf(noHp.getText());
        hargabarang = "Rp. " + df.format(harga);
        totalharga = "Rp. " + df.format(tharga);

        try {
            sql = "UPDATE transaksi_pembelian SET nama_barang='" + namabarang + "', harga_barang='" + hargabarang + "', jumlah_beli='" + jumlahbeli + "', total_harga='" + totalharga + "', kode_customer='" + kodecustomer + "', nama_customer='" + namacustomer + "', kota='" + kota + "', no_hp='" + nohp + "' WHERE kode_barang='" + kodebarang + "'";
            st = conn.createStatement();
            st.execute(sql);
            stokBarang();
            reset();
            tampilData();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah " + e);
        }
    }

    private void hapus() {
        int row = tabelPembelian.getSelectedRow();
        kodebarang = tabelPembelian.getValueAt(row, 1).toString();
        namabarang = tabelPembelian.getValueAt(row, 2).toString();

        int pilihan = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus " + namabarang + "?",
                "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (pilihan == JOptionPane.OK_OPTION) {
            try {
                sql = "DELETE FROM transaksi_pembelian WHERE kode_barang='" + kodebarang + "'";
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
        jumlahBeli.setSelectedItem(null);
        kodeCustomer.setSelectedItem("Pilih Customer");
        namaCustomer.setText("");
        kotaCustomer.setText("");
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

    private void kodeCustomer() {
        try {
            sql = "SELECT * FROM data_customer";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                kodeCustomer.addItem(rs.getString("kode_customer"));
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
                hargaBarang.setText(rs.getString("format_harga"));
                int i = 1;
                int jumlah = Integer.parseInt(rs.getString("stok_barang"));
                for (i = 1; i <= jumlah; i++) {
                    jumlahBeli.addItem(i + "");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void kodeCustomerTerpilih() {
        kodecustomer = String.valueOf(kodeCustomer.getSelectedItem());

        try {
            sql = "SELECT * FROM data_customer WHERE kode_customer='" + kodecustomer + "'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                namaCustomer.setText(rs.getString("nama_customer"));
                kotaCustomer.setText(rs.getString("kota"));
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
        jLabel2 = new javax.swing.JLabel();
        kodeBarang = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        namaBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        hargaBarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        kodeCustomer = new javax.swing.JComboBox<>();
        namaCustomer = new javax.swing.JTextField();
        kotaCustomer = new javax.swing.JTextField();
        noHp = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPembelian = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();
        jumlahBeli = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory");
        setMinimumSize(new java.awt.Dimension(1000, 540));

        jPanel1.setBackground(new java.awt.Color(86, 187, 241));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PEMBELIAN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Kode Barang");

        kodeBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kodeBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Barang" }));
        kodeBarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kodeBarangItemStateChanged(evt);
            }
        });
        kodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeBarangActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nama Barang");

        namaBarang.setEditable(false);
        namaBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Harga Barang");

        hargaBarang.setEditable(false);
        hargaBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Jumlah Beli");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Kode Customer");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Nama Customer");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Kota");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("No Hp");

        kodeCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kodeCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Customer" }));
        kodeCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeCustomerActionPerformed(evt);
            }
        });

        namaCustomer.setEditable(false);
        namaCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        kotaCustomer.setEditable(false);
        kotaCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        btnKeluar.setBackground(new java.awt.Color(94, 230, 235));
        btnKeluar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        tabelPembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Kode Barang", "Nama Barang", "Harga", "Jumlah Beli", "Total Harga", "Kode Customer", "Nama Customer", "Kota", "No Hp"
            }
        ));
        tabelPembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPembelianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPembelian);

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
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(403, 403, 403)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnHapus)
                                        .addGap(56, 56, 56))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnSimpan)
                                        .addGap(53, 53, 53)
                                        .addComponent(btnUbah)
                                        .addGap(191, 191, 191)))
                                .addComponent(btnKeluar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(namaBarang, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(kodeBarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(162, 162, 162)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(kodeCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kotaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namaCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(noHp)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnCetak)))
                        .addGap(0, 147, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(kodeCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(namaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(kotaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(noHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeBarangActionPerformed
        kodebarang = String.valueOf(kodeBarang.getSelectedItem());

        if (kodebarang == "Pilih Barang") {
            namaBarang.setText("");
            hargaBarang.setText("");
        } else {
            kodeBarangTerpilih();
        }
    }//GEN-LAST:event_kodeBarangActionPerformed

    private void kodeCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeCustomerActionPerformed
        kodecustomer = String.valueOf(kodeCustomer.getSelectedItem());

        if (kodebarang == "Pilih Customer") {
            namaCustomer.setText("");
            kotaCustomer.setText("");
            noHp.setText("");
        } else {
            kodeCustomerTerpilih();
        }
    }//GEN-LAST:event_kodeCustomerActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        simpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        ubah();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        new MenuUtama().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void tabelPembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPembelianMouseClicked
        int row = tabelPembelian.getSelectedRow();
        kodebarang = tabelPembelian.getValueAt(row, 1).toString();
        kodeBarang.setSelectedItem(kodebarang);
        jumlahBeli.setSelectedItem((String) tabelPembelian.getValueAt(row, 4));

        kodecustomer = tabelPembelian.getValueAt(row, 6).toString();
        kodeCustomer.setSelectedItem(kodecustomer);
    }//GEN-LAST:event_tabelPembelianMouseClicked

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try {
            String namaFile = "src/Laporan/LaporanPembelian.jasper";
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

    private void kodeBarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kodeBarangItemStateChanged
        jumlahBeli.removeAllItems();
    }//GEN-LAST:event_kodeBarangItemStateChanged

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
            java.util.logging.Logger.getLogger(TransaksiPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiPembelian().setVisible(true);
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jumlahBeli;
    private javax.swing.JComboBox<String> kodeBarang;
    private javax.swing.JComboBox<String> kodeCustomer;
    private javax.swing.JTextField kotaCustomer;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTextField namaCustomer;
    private javax.swing.JTextField noHp;
    private javax.swing.JTable tabelPembelian;
    // End of variables declaration//GEN-END:variables
}
