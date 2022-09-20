/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IceCream;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JFrame;
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
public class DataIceCream extends javax.swing.JFrame {

    private final Connection conn = new Koneksi().konek();
    private Statement st;
    private ResultSet rs;
    private String sql = "";

    public String idice, typeice, flavour, price;

    /**
     * Creates new form DataIceCream
     */
    public DataIceCream() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
        DataIceCream(sql);
        LebarKolom();
        noOtomatis();
        iceCreamType.requestFocus();
    }

    private void LebarKolom() {
        tabelIceCream.getColumnModel().getColumn(0).setPreferredWidth(25);
        tabelIceCream.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabelIceCream.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabelIceCream.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabelIceCream.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    private void DataIceCream(String sql) {
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("ID Ice Cream");
        datalist.addColumn("Ice Cream Type");
        datalist.addColumn("Flavour");
        datalist.addColumn("Price");
        LebarKolom();

        try {
            int no = 1;
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM dataice");
            while (rs.next()) {
                datalist.addRow(new Object[]{
                    ("" + no++),
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                });
                tabelIceCream.setModel(datalist);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data");
        }
    }

    private void noOtomatis() {
        try {
            sql = "SELECT * FROM dataice ORDER BY idice DESC";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String idice = rs.getString("idice").substring(3);
                String id = "" + (Integer.parseInt(idice) + 1);
                String nol = "";

                if (id.length() == 1) {
                    nol = "0";
                } else {
                    nol = "";
                }
                idIceCream.setText("ICE" + nol + id);
            } else {
                idIceCream.setText("ICE01");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Otomatis Error", "Peringatan", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void simpan() {
        idice = String.valueOf(idIceCream.getText());
        typeice = String.valueOf(iceCreamType.getText());
        flavour = String.valueOf(Flavour.getSelectedItem().toString());
        price = String.valueOf(Price.getText());

        try {
            sql = "INSERT INTO dataice VALUES" + "('" + idice + "','" + typeice + "','" + flavour + "','" + price + "')";
            st = conn.createStatement();
            st.execute(sql);
            reset();
            noOtomatis();
            DataIceCream(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
        iceCreamType.requestFocus();
    }

    private void reset() {
        iceCreamType.setText("");
        Flavour.setSelectedItem("Chocolate");
        Price.setText("");
        noOtomatis();
    }

    private void hapus() {
        int pilihan = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data?",
                "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (pilihan == JOptionPane.OK_OPTION) {
            int row = tabelIceCream.getSelectedRow();
            String idice = tabelIceCream.getValueAt(row, 1).toString();
            try {
                sql = "DELETE FROM dataice WHERE idice='" + idice + "'";
                st = conn.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data Dihapus");
                noOtomatis();
                DataIceCream(sql);
                reset();
                LebarKolom();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            }
        }
    }

    private void ubah() {
        idice = String.valueOf(idIceCream.getText());
        typeice = String.valueOf(iceCreamType.getText());
        flavour = String.valueOf(Flavour.getSelectedItem().toString());
        price = String.valueOf(Price.getText());

        try {
            sql = "UPDATE dataice SET icecreamtype='" + typeice + "', flavour='" + flavour + "', price='" + price + "'WHERE idice='" + idice + "'";
            st = conn.createStatement();
            st.executeUpdate(sql);
            noOtomatis();
            DataIceCream(sql);
            reset();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah");
        }
    }

    private void cari() {
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("NO");
        datalist.addColumn("ID ICE CREAM");
        datalist.addColumn("ICE CREAM TYPE");
        datalist.addColumn("FLAVOUR");
        datalist.addColumn("PRICE");
        LebarKolom();

        try {
            int i = 1;
            sql = "SELECT * FROM dataice WHERE idice LIKE '%" + cari.getText() + "%' OR icecreamtype LIKE '%" + cari.getText() + "%'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                datalist.addRow(new Object[]{
                    ("" + i++),
                    rs.getString("idice"),
                    rs.getString("icecreamtype"),
                    rs.getString("flavour"),
                    rs.getString("price")
                });
            }
            tabelIceCream.setModel(datalist);
        } catch (Exception e) {
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
        idIceCream = new javax.swing.JTextField();
        iceCreamType = new javax.swing.JTextField();
        Flavour = new javax.swing.JComboBox<>();
        Price = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelIceCream = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("DATA ICE CREAM");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("ID Ice Cream");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ice Cream Type");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Flavour");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Price");

        idIceCream.setEditable(false);
        idIceCream.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idIceCream.setEnabled(false);

        iceCreamType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Flavour.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Flavour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chocolate", "Vanilla", "Strawberry" }));

        Price.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        tabelIceCream.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ID Ice Cream", "Ice Cream Type", "Flavour", "Price"
            }
        ));
        tabelIceCream.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelIceCreamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelIceCream);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Cari");

        cari.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        btnPrint.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(126, 126, 126)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(52, 52, 52)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Price)
                                        .addComponent(iceCreamType)
                                        .addComponent(Flavour, 0, 154, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(idIceCream, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSubmit)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUpdate)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDelete)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancel)))))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idIceCream, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(iceCreamType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Flavour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        reset();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        hapus();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        simpan();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        ubah();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tabelIceCreamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelIceCreamMouseClicked
        try {
            int row = tabelIceCream.getSelectedRow();

            String idice = tabelIceCream.getValueAt(row, 1).toString();
            idIceCream.setText(idice);
            String typeice = tabelIceCream.getValueAt(row, 2).toString();
            iceCreamType.setText(typeice);
            String flavour = tabelIceCream.getValueAt(row, 3).toString();
            Flavour.setSelectedItem(flavour);
            String price = tabelIceCream.getValueAt(row, 4).toString();
            Price.setText(price);
        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan");
        }
    }//GEN-LAST:event_tabelIceCreamMouseClicked

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        cari();
    }//GEN-LAST:event_cariKeyReleased

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            String namaFile = "src/Laporan/LaporanDataIce.jasper";
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
            java.util.logging.Logger.getLogger(DataIceCream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataIceCream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataIceCream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataIceCream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataIceCream().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Flavour;
    private javax.swing.JTextField Price;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField cari;
    private javax.swing.JTextField iceCreamType;
    private javax.swing.JTextField idIceCream;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelIceCream;
    // End of variables declaration//GEN-END:variables
}
