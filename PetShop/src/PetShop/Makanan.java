/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetShop;

/**
 *
 * @author RLB
 */
public class Makanan extends javax.swing.JFrame {

    String namamakanan;
    int harga;
    FormBeliMakanan fb = new FormBeliMakanan();

    public String bolt[] = {"Tuna"};
    public String catchoize[] = {"Tuna", "Salmon"};
    public String excel[] = {"Tuna"};
    public String felibite[] = {"Tuna"};
    public String royalcanin[] = {"Salmon"};
    public String whiskas[] = {"Tuna", "Ayam", "Salmon"};

    /**
     * Creates new form Home
     */
    public Makanan() {
        initComponents();
    }

    private void Bolt() {
        namamakanan = "Bolt";
        harga = 22000;

        for (String i : bolt) {
            fb.varianRasa.addItem(i);
        }
        fb.namaMakanan.setText(namamakanan);
        fb.hargaSatuan.setText("" + harga);
        fb.setVisible(true);
    }

    private void CatChoize() {
        namamakanan = "Cat Choize";
        harga = 18000;

        for (String i : catchoize) {
            fb.varianRasa.addItem(i);
        }
        fb.namaMakanan.setText(namamakanan);
        fb.hargaSatuan.setText("" + harga);
        fb.setVisible(true);
    }

    private void Excel() {
        namamakanan = "Excel";
        harga = 12000;

        for (String i : excel) {
            fb.varianRasa.addItem(i);
        }
        fb.namaMakanan.setText(namamakanan);
        fb.hargaSatuan.setText("" + harga);
        fb.setVisible(true);
    }

    private void Felibite() {
        namamakanan = "Felibite";
        harga = 15000;

        for (String i : felibite) {
            fb.varianRasa.addItem(i);
        }
        fb.namaMakanan.setText(namamakanan);
        fb.hargaSatuan.setText("" + harga);
        fb.setVisible(true);
    }

    private void RoyalCanin() {
        namamakanan = "Royal Canin";
        harga = 250000;

        for (String i : royalcanin) {
            fb.varianRasa.addItem(i);
        }
        fb.namaMakanan.setText(namamakanan);
        fb.hargaSatuan.setText("" + harga);
        fb.setVisible(true);
    }

    private void Whiskas() {
        namamakanan = "Whiskas";
        harga = 60000;

        for (String i : whiskas) {
            fb.varianRasa.addItem(i);
        }
        fb.namaMakanan.setText(namamakanan);
        fb.hargaSatuan.setText("" + harga);
        fb.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pembelian = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        makanan = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pasir = new javax.swing.JLabel();
        Background = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnBolt = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnCatChoize = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnExcel = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnFelibite = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnRoyalCanin = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnWhiskas = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        navbar = new javax.swing.JPanel();
        namaUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        penutupToggle = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebar.setBackground(new java.awt.Color(0, 120, 170));
        sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 120, 170));

        pembelian.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pembelian.setForeground(new java.awt.Color(255, 255, 255));
        pembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pembelian.png"))); // NOI18N
        pembelian.setText("Pembelian");
        pembelian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pembelianMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pembelian, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pembelian, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        sidebar.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu");
        sidebar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jPanel2.setBackground(new java.awt.Color(2, 97, 137));

        makanan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        makanan.setForeground(new java.awt.Color(255, 255, 255));
        makanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/makanan.png"))); // NOI18N
        makanan.setText("Makanan");
        makanan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makanan, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(makanan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        sidebar.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 250, 40));

        jPanel3.setBackground(new java.awt.Color(0, 120, 170));

        pasir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pasir.setForeground(new java.awt.Color(255, 255, 255));
        pasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pasir.png"))); // NOI18N
        pasir.setText("Pasir");
        pasir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pasirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pasir, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pasir, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        sidebar.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 250, 40));

        getContentPane().add(sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 720));

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bolt.jpg"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 170));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel10.setText("BOLT");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel16.setText("Rp. 22.000");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        btnBolt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnBolt.setText("Beli");
        btnBolt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBolt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoltActionPerformed(evt);
            }
        });
        jPanel4.add(btnBolt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 280, -1));

        Background.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 300, 250));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cat choize.png"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 170));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel11.setText("Rp. 18.000");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        btnCatChoize.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnCatChoize.setText("Beli");
        btnCatChoize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCatChoize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatChoizeActionPerformed(evt);
            }
        });
        jPanel5.add(btnCatChoize, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 280, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel17.setText("Cat Choize");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        Background.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 300, 250));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.jpg"))); // NOI18N
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 170));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel12.setText("Excel");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        btnExcel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnExcel.setText("Beli");
        btnExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });
        jPanel6.add(btnExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 280, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel19.setText("Rp. 12.000");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        Background.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 300, 250));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/felibite.png"))); // NOI18N
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 170));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel13.setText("Felibite");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        btnFelibite.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnFelibite.setText("Beli");
        btnFelibite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFelibite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFelibiteActionPerformed(evt);
            }
        });
        jPanel7.add(btnFelibite, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 280, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel18.setText("Rp. 15.000");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        Background.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 300, 250));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/royal canin.jpg"))); // NOI18N
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 170));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel14.setText("Royal Canin");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        btnRoyalCanin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnRoyalCanin.setText("Beli");
        btnRoyalCanin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRoyalCanin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoyalCaninActionPerformed(evt);
            }
        });
        jPanel8.add(btnRoyalCanin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 280, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel20.setText("Rp. 250.000");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        Background.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 300, 250));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/whiskas.jpg"))); // NOI18N
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 170));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel15.setText("Whiskas");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        btnWhiskas.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnWhiskas.setText("Beli");
        btnWhiskas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnWhiskas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWhiskasActionPerformed(evt);
            }
        });
        jPanel9.add(btnWhiskas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 280, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel21.setText("Rp. 60.000");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        Background.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 380, 300, 250));

        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1366, 720));

        navbar.setBackground(new java.awt.Color(58, 180, 242));
        navbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        namaUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        namaUser.setForeground(new java.awt.Color(255, 255, 255));
        namaUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        namaUser.setText("Hello, Admin");
        navbar.add(namaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 180, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("WIN PETSHOP");
        navbar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        penutupToggle.setBackground(new java.awt.Color(58, 180, 242));
        penutupToggle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bar.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        penutupToggle.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        navbar.add(penutupToggle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 50));

        bar.setBackground(new java.awt.Color(58, 180, 242));
        bar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bar.png"))); // NOI18N
        bar.setSelected(true);
        bar.setBorder(null);
        bar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barActionPerformed(evt);
            }
        });
        navbar.add(bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 50));

        getContentPane().add(navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barActionPerformed
        if (bar.isSelected()) {
            sidebar.show();
        } else {
            sidebar.hide();
        }
    }//GEN-LAST:event_barActionPerformed

    private void btnBoltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoltActionPerformed
        Bolt();
    }//GEN-LAST:event_btnBoltActionPerformed

    private void btnCatChoizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatChoizeActionPerformed
        CatChoize();
    }//GEN-LAST:event_btnCatChoizeActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        Excel();
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnFelibiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFelibiteActionPerformed
        Felibite();
    }//GEN-LAST:event_btnFelibiteActionPerformed

    private void btnRoyalCaninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoyalCaninActionPerformed
        RoyalCanin();
    }//GEN-LAST:event_btnRoyalCaninActionPerformed

    private void btnWhiskasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWhiskasActionPerformed
        Whiskas();
    }//GEN-LAST:event_btnWhiskasActionPerformed

    private void pembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianMouseClicked
        new Pembelian().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pembelianMouseClicked

    private void pasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pasirMouseClicked
        new Pasir().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pasirMouseClicked

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
            java.util.logging.Logger.getLogger(Makanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Makanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Makanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Makanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Makanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JToggleButton bar;
    private javax.swing.JButton btnBolt;
    private javax.swing.JButton btnCatChoize;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnFelibite;
    private javax.swing.JButton btnRoyalCanin;
    private javax.swing.JButton btnWhiskas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel makanan;
    public javax.swing.JLabel namaUser;
    private javax.swing.JPanel navbar;
    private javax.swing.JLabel pasir;
    private javax.swing.JLabel pembelian;
    private javax.swing.JPanel penutupToggle;
    private javax.swing.JPanel sidebar;
    // End of variables declaration//GEN-END:variables
}