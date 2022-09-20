/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IceCream;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RLB
 */
public class DataTopping extends javax.swing.JFrame {

    private final Connection conn = new Koneksi().konek();
    private Statement st;
    private ResultSet rsdatatop;
    private String sql = "";

    public String idtop, nametop, pricetop;

    /**
     * Creates new form DataTopping
     */
    public DataTopping() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
        DataTopping(sql);
        LebarKolom();
        noOtomatis();
        aktif();
    }

    private void LebarKolom() {
        tabelTopping.getColumnModel().getColumn(0).setPreferredWidth(15);
        tabelTopping.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabelTopping.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabelTopping.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    private void DataTopping(String sql) {
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("ID Topping");
        datalist.addColumn("Topping Name");
        datalist.addColumn("Price");
        LebarKolom();

        try {
            int i = 1;
            st = conn.createStatement();
            sql = "SELECT * FROM datatopping";
            rsdatatop = st.executeQuery(sql);
            while (rsdatatop.next()) {
                datalist.addRow(new Object[]{
                    ("" + i++),
                    rsdatatop.getString(1),
                    rsdatatop.getString(2),
                    rsdatatop.getString(3),});
                tabelTopping.setModel(datalist);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Data", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void noOtomatis() {
        try {
            sql = "SELECT * FROM datatopping ORDER BY idtop DESC";
            st = conn.createStatement();
            rsdatatop = st.executeQuery(sql);
            if (rsdatatop.next()) {
                String idtop = rsdatatop.getString("idtop").substring(3);
                String id = "" + (Integer.parseInt(idtop) + 1);
                String nol = "";

                if (id.length() == 1) {
                    nol = "0";
                } else {
                    nol = "";
                }
                idTopping.setText("TOP" + nol + id);
            } else {
                idTopping.setText("TOP01");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Otomatis Error", "Peringatan", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void simpain() {
        idtop = String.valueOf(idTopping.getText());
        nametop = String.valueOf(toppingName.getText());
        pricetop = String.valueOf(Price.getText());

        try {
            sql = "INSERT INTO datatopping VALUES" + "('" + idtop + "', '" + nametop + "', '" + pricetop + "')";
            st = conn.createStatement();
            st.executeUpdate(sql);
            reset();
            noOtomatis();
            DataTopping(sql);
            aktif();
            JOptionPane.showMessageDialog(null, "Data Disimpan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan");
        }
        toppingName.requestFocus();
    }

    private void reset() {
        toppingName.setText("");
        Price.setText("");
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        noOtomatis();
    }

    private void aktif() {
        btnSubmit.setEnabled(true);
        btnEdit.setEnabled(false);
        btnCancel.setEnabled(true);
        btnDelete.setEnabled(false);
        btnClose.setEnabled(true);
    }

    private void hapus() {
        int pilihan = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data?", "Konfirmasi", JOptionPane.YES_NO_CANCEL_OPTION);
        if (pilihan == 0) {
            int row = tabelTopping.getSelectedRow();
            String id = tabelTopping.getValueAt(row, 1).toString();

            try {
                sql = "DELETE FROM datatopping" + "WHERE idtop='" + idtop + "'";
                st = conn.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data Dihapus");
                reset();
                noOtomatis();
                DataTopping(sql);
                LebarKolom();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            }
        }
    }

    private void ubah() {
        idtop = String.valueOf(idTopping.getText());
        nametop = String.valueOf(toppingName.getText());
        pricetop = String.valueOf(Price.getText());

        try {
            sql = "UPDATE datatopping SET toppingname='" + nametop + "', price='" + pricetop + "' WHERE idtop='" + idtop + "'";
            st = conn.createStatement();
            st.executeUpdate(sql);
            reset();
            noOtomatis();
            DataTopping(sql);
            LebarKolom();
            JOptionPane.showMessageDialog(null, "Data Diupdate");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diupdate");
        }
    }

    private void caridata() {
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("ID Topping");
        datalist.addColumn("Topping Name");
        datalist.addColumn("Price");
        LebarKolom();

        try {
            int i = 1;
            st = conn.createStatement();
            sql = "SELECT * FROM datatopping WHERE idtop LIKE '%" + cariData.getText() + "%' OR toppingname LIKE '%" + cariData.getText() + "%'";
            rsdatatop = st.executeQuery(sql);
            while (rsdatatop.next()) {
                datalist.addRow(new Object[]{
                    ("" + i++),
                    rsdatatop.getString(idtop),
                    rsdatatop.getString(nametop),
                    rsdatatop.getString(pricetop)});
                tabelTopping.setModel(datalist);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada!", "Peringatan", JOptionPane.WARNING_MESSAGE);
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
        idTopping = new javax.swing.JTextField();
        toppingName = new javax.swing.JTextField();
        Price = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelTopping = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cariData = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("DATA TOPPING");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID Topping");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Topping Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Price");

        idTopping.setEditable(false);
        idTopping.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        toppingName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        tabelTopping.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ID Topping", "Topping Name", "Price"
            }
        ));
        jScrollPane1.setViewportView(tabelTopping);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cari Data");

        cariData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnCari.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(40, 40, 40)
                                    .addComponent(toppingName, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(61, 61, 61)
                                    .addComponent(idTopping, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(100, 100, 100)
                                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnSubmit)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEdit)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDelete)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCancel)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnClose))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cariData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idTopping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(toppingName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnCancel)
                    .addComponent(btnClose))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cariData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        simpain();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        ubah();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        hapus();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        reset();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        MenuUtama menu = new MenuUtama();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        caridata();
    }//GEN-LAST:event_btnCariActionPerformed

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
            java.util.logging.Logger.getLogger(DataTopping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataTopping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataTopping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataTopping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataTopping().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Price;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JTextField cariData;
    private javax.swing.JTextField idTopping;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelTopping;
    private javax.swing.JTextField toppingName;
    // End of variables declaration//GEN-END:variables
}
