/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Latihan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RLB
 */
public class DataObat extends javax.swing.JFrame {

    DefaultTableModel model;
    DecimalFormat df = new DecimalFormat();

    /**
     * Creates new form DataObat
     */
    public DataObat() {
        initComponents();
        String[] title = {"Kode Obat", "Nama Obat", "Jenis Obat", "Satuan", "Harga", "Stok"};
        model = new DefaultTableModel(title, 0);
        tabelObat.setModel(model);
        tampilkan();
        idOtomatis();
    }

    private void tampilkan() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rumahsakit", "root", "");
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM obat";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Object[] obj = new Object[6];
                obj[0] = rs.getString("kode_obat");
                obj[1] = rs.getString("nama_obat");
                obj[2] = rs.getString("jenis_obat");
                obj[3] = rs.getString("satuan");
                obj[4] = rs.getString("harga");
                obj[5] = rs.getString("stok");
                model.addRow(obj);
            }
        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan");
        }
    }

    private void idOtomatis() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rumahsakit", "root", "");
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM obat ORDER BY kode_obat DESC";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String kode = rs.getString("kode_obat").substring(2);
                String br = "" + (Integer.parseInt(kode) + 1);
                String nol = "";

                if (br.length() == 1) {
                    nol = "00";
                } else if (br.length() == 2) {
                    nol = "0";
                } else if (br.length() == 3) {
                    nol = "";
                }
                kodeObat.setText("KD" + nol + br);
            } else {
                kodeObat.setText("KD001");
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("ID otomatis error!");
        }
    }

    private void reset() {
        namaObat.setText("");
        jenisObat.setSelectedItem("Sirup");
        Satuan.setText("");
        Harga.setText("");
        Stok.setText("");
    }

    private void simpan() {
        String kodeobat = kodeObat.getText();
        String namaobat = namaObat.getText();
        String jenisobat = String.valueOf(jenisObat.getSelectedItem());
        String stok = Stok.getText();
        String satuan = Satuan.getText();
        int harga = Integer.parseInt(Harga.getText());
        String totalharga = "Rp. " + df.format(harga);

        try {
            if (namaobat.equals("") || stok.equals("") || satuan.equals("") || Harga.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rumahsakit", "root", "");
                Statement st = conn.createStatement();
                String sql = "INSERT INTO obat VALUES" + "('" + kodeobat + "','" + namaobat + "','" + jenisobat + "','" + satuan + "','" + totalharga + "','" + stok + "')";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data Anda Berhasil Disimpan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                idOtomatis();
                tampilkan();
                reset();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak dapat menyimpan data", "Peringatan", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hapus() {
        int pilihan = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data?",
                "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (pilihan == JOptionPane.OK_OPTION) {
            int row = tabelObat.getSelectedRow();
            String kodeobat = tabelObat.getValueAt(row, 0).toString();
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rumahsakit", "root", "");
                Statement st = conn.createStatement();
                String sql = "DELETE FROM obat WHERE kode_obat='" + kodeobat + "'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data Dihapus");
                idOtomatis();
                tampilkan();
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            }
        }
    }

    private void ubah() {
        String kodeobat = kodeObat.getText();
        String namaobat = namaObat.getText();
        String jenisobat = String.valueOf(jenisObat.getSelectedItem());
        String stok = Stok.getText();
        String satuan = Satuan.getText();
        String harga = Harga.getText();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rumahsakit", "root", "");
            Statement st = conn.createStatement();
            String sql = "UPDATE obat SET nama_obat='" + namaobat + "', jenis_obat='" + jenisobat + "', satuan='" + satuan + "', harga='" + harga + "', stok='" + stok + "'WHERE kode_obat='" + kodeobat + "'";
            st.executeUpdate(sql);
            idOtomatis();
            tampilkan();
            reset();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        namaObat = new javax.swing.JTextField();
        Satuan = new javax.swing.JTextField();
        Harga = new javax.swing.JTextField();
        jenisObat = new javax.swing.JComboBox<>();
        Stok = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelObat = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        kodeObat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("DATA OBAT");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nama Obat");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Jenis Obat");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Satuan");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Harga");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Stok");

        namaObat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Satuan.setEditable(false);
        Satuan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Harga.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jenisObat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jenisObat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sirup", "Kapsul", "Tablet" }));
        jenisObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisObatActionPerformed(evt);
            }
        });

        Stok.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel7.setText("Rayhan Lingga Buana");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel8.setText("201943501484");

        tabelObat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Obat", "Nama Obat", "Jenis Obat", "Satuan", "Harga", "Stok"
            }
        ));
        tabelObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelObatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelObat);

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Kode Obat");

        kodeObat.setEditable(false);
        kodeObat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(namaObat)
                                                    .addComponent(jenisObat, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(23, 23, 23)
                                                .addComponent(kodeObat)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addGap(19, 19, 19)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Stok, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(98, 98, 98)
                                    .addComponent(btnSave)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEdit)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDelete))))
                        .addGap(0, 72, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(kodeObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(namaObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jenisObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jenisObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisObatActionPerformed
        String jenisobat, satuanobat;
        jenisobat = String.valueOf(jenisObat.getSelectedItem());

        if (jenisobat == "Sirup") {
            satuanobat = "mL";
        } else if (jenisobat == "Kapsul") {
            satuanobat = "Butir";
        } else {
            satuanobat = "Kaplet";
        }
        Satuan.setText(satuanobat);
    }//GEN-LAST:event_jenisObatActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        simpan();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        hapus();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tabelObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelObatMouseClicked
        try {
            int row = tabelObat.getSelectedRow();

            String kodeobat = tabelObat.getValueAt(row, 0).toString();
            kodeObat.setText(kodeobat);

            String namaobat = tabelObat.getValueAt(row, 1).toString();
            namaObat.setText(namaobat);

            String jenisobat = tabelObat.getValueAt(row, 2).toString();
            jenisObat.setSelectedItem(jenisobat);

            String satuan = tabelObat.getValueAt(row, 3).toString();
            Satuan.setText(satuan);

            String harga = tabelObat.getValueAt(row, 4).toString();
            Harga.setText(harga);

            String stok = tabelObat.getValueAt(row, 5).toString();
            Stok.setText(stok);

        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan");
        }
    }//GEN-LAST:event_tabelObatMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        ubah();
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(DataObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataObat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Harga;
    private javax.swing.JTextField Satuan;
    private javax.swing.JTextField Stok;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenisObat;
    private javax.swing.JTextField kodeObat;
    private javax.swing.JTextField namaObat;
    private javax.swing.JTable tabelObat;
    // End of variables declaration//GEN-END:variables
}
