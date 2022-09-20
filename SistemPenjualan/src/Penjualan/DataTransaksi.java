/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Penjualan;

import com.sun.glass.events.KeyEvent;
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
public class DataTransaksi extends javax.swing.JFrame {
    
    private final Connection conn = new Koneksi().konek();
    private Statement st;
    private ResultSet rs;
    private String sql;
    
    DecimalFormat df = new DecimalFormat();
    private String kodebarang, kategoribarang, namabarang, jumlah, formatharga;
    private double hargabarang, totalharga, totalhargapembelian, uangbayar, uangkembalian;

    /**
     * Creates new form DataTransaksi
     */
    public DataTransaksi() {
        initComponents();
        DataBarang();
        tabelDataBarang.setAutoCreateRowSorter(true);
        DataPembelian();
        TotalHargaPembelian();
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
                tabelDataBarang.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data " + e);
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
            tabelDataBarang.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak Dapat Mencari Data");
        }
    }
    
    private void DataPembelian() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama Barang");
        model.addColumn("Kategori Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga Barang");
        
        try {
            sql = "SELECT * FROM pembelian";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nama_barang"),
                    rs.getString("kategori_barang"),
                    rs.getString("jumlah"),
                    rs.getString("format_harga")
                });
                tabelPembelian.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data " + e);
        }
    }
    
    private void TotalHargaPembelian() {
        try {
            sql = "SELECT SUM(harga_barang) FROM pembelian";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                totalhargapembelian = rs.getDouble("SUM(harga_barang)");
                totalHarga.setText("Rp. " + df.format(totalhargapembelian));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void ResetPembelian() {
        try {
            sql = "DELETE FROM pembelian";
            st = conn.createStatement();
            st.executeUpdate(sql);
            
            sql = "DELETE FROM transaksi";
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        uangBayar.setText("");
        totalHarga.setText("");
        uangKembalian.setText("");
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
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDataBarang = new javax.swing.JTable();
        cariBarang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPembelian = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        uangBayar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        uangKembalian = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        totalHarga = new javax.swing.JTextField();
        btnTambahData = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnHome = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PetShop");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSAKSI PEMBELIAN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1366, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1366, 10));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Data Barang", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        tabelDataBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Kategori Barang", "Nama Barang", "Harga"
            }
        ));
        tabelDataBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelDataBarang);
        if (tabelDataBarang.getColumnModel().getColumnCount() > 0) {
            tabelDataBarang.getColumnModel().getColumn(0).setHeaderValue("Kode Barang");
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 620, 570));

        cariBarang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cariBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariBarangKeyReleased(evt);
            }
        });
        jPanel1.add(cariBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 140, 190, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Total Harga");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 660, -1, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Data Pembelian", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        tabelPembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Barang", "Kategori Barang", "Jumlah", "Harga"
            }
        ));
        tabelPembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPembelianMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelPembelian);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 620, 460));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Cari Barang");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, -1));

        uangBayar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        uangBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                uangBayarKeyReleased(evt);
            }
        });
        jPanel1.add(uangBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 130, 240, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Cash");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 130, -1, -1));

        uangKembalian.setEditable(false);
        uangKembalian.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(uangKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 710, 240, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Kembalian");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 710, -1, -1));

        totalHarga.setEditable(false);
        totalHarga.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(totalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 660, 240, -1));

        btnTambahData.setBackground(new java.awt.Color(6, 255, 0));
        btnTambahData.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnTambahData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tambah.png"))); // NOI18N
        btnTambahData.setText("Tambah Data");
        btnTambahData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahDataActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambahData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        btnClear.setBackground(new java.awt.Color(255, 51, 51));
        btnClear.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 650, -1, -1));

        btnPrint.setBackground(new java.awt.Color(255, 204, 51));
        btnPrint.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 650, -1, -1));

        btnHome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
        });
        jPanel1.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 60, -1, -1));

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
        jPanel2.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1325, 0, 30, 30));

        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });
        jPanel2.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 30, 30));

        jLabel7.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pet");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jLabel6.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setText("Shop");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 30));

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

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cariBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariBarangKeyReleased
        CariBarang();
    }//GEN-LAST:event_cariBarangKeyReleased

    private void uangBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uangBayarKeyReleased
        uangbayar = Double.valueOf(uangBayar.getText().replaceAll("\\,", ""));
        uangBayar.setText(df.format(uangbayar));
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            uangkembalian = uangbayar - totalhargapembelian;
            uangKembalian.setText("Rp. " + df.format(uangkembalian));
            
            try {
                String tharga = "Rp. " + df.format(totalhargapembelian);
                String bayar = "Rp. " + df.format(uangbayar);
                String kembalian = "Rp. " + df.format(uangkembalian);
                sql = "INSERT INTO transaksi VALUES" + "('" + tharga + "','" + bayar + "','" + kembalian + "')";
                st = conn.createStatement();
                st.execute(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_uangBayarKeyReleased

    private void tabelDataBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataBarangMouseClicked
        int row = tabelDataBarang.getSelectedRow();
        kodebarang = tabelDataBarang.getValueAt(row, 0).toString();
        try {
            sql = "SELECT * FROM data_barang WHERE kode_barang='" + kodebarang + "'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                namabarang = rs.getString("nama_barang");
                kategoribarang = rs.getString("kategori_barang");
                jumlah = JOptionPane.showInputDialog(null, "Masukan Jumlah", 1);
                hargabarang = rs.getDouble("harga_barang");
                totalharga = hargabarang * Integer.parseInt(jumlah);
                formatharga = "Rp. " + df.format(totalharga);
                
                sql = "INSERT INTO pembelian VALUES" + "('" + namabarang + "','" + kategoribarang + "','" + jumlah + "','" + totalharga + "','" + formatharga + "')";
                st = conn.createStatement();
                st.execute(sql);
                DataPembelian();
                TotalHargaPembelian();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan " + e);
        }
    }//GEN-LAST:event_tabelDataBarangMouseClicked

    private void btnTambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDataActionPerformed
        new TambahData().show();
        this.dispose();
    }//GEN-LAST:event_btnTambahDataActionPerformed

    private void tabelPembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPembelianMouseClicked
        int row = tabelPembelian.getSelectedRow();
        namabarang = tabelPembelian.getValueAt(row, 0).toString();
        int pilihan = JOptionPane.showConfirmDialog(null, "Yakin Ingin Hapus Barang?", "Pesan", JOptionPane.OK_CANCEL_OPTION);
        
        if (pilihan == JOptionPane.OK_OPTION) {
            try {
                sql = "DELETE FROM pembelian WHERE nama_barang='" + namabarang + "'";
                st = conn.createStatement();
                st.executeUpdate(sql);
                DataPembelian();
                TotalHargaPembelian();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan " + e);
            }
        }
    }//GEN-LAST:event_tabelPembelianMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        ResetPembelian();
        new DataTransaksi().show();
        this.dispose();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            String namaFile = "C:\\Users\\Administrator\\Documents\\NetBeansProjects\\SistemPenjualan\\src\\Laporan\\Struk.jasper";
            HashMap parameter = new HashMap();
            File report = new File(namaFile);
            JasperReport jr = (JasperReport) JRLoader.loadObject(report.getPath());
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, conn);
            JasperViewer.viewReport(jp, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        new Beranda().show();
        this.dispose();
    }//GEN-LAST:event_btnHomeMouseClicked

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
            java.util.logging.Logger.getLogger(DataTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTambahData;
    private javax.swing.JTextField cariBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelDataBarang;
    private javax.swing.JTable tabelPembelian;
    private javax.swing.JTextField totalHarga;
    private javax.swing.JTextField uangBayar;
    private javax.swing.JTextField uangKembalian;
    // End of variables declaration//GEN-END:variables
}
