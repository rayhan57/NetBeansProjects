/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Komgraf;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author RLB
 */
public class Drawing2 extends javax.swing.JFrame {

    /**
     * Creates new form Drawing
     */
    public Drawing2() {
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.gray);
        g.fillArc(100, 50, 100, 100, 0, 360);//Kepala

        g.setColor(Color.white);
        g.fillArc(110, 70, 40, 40, 0, 360);//Mata kiri
        g.fillArc(150, 70, 40, 40, 0, 360);//Mata kanan

        g.setColor(Color.black);
        g.fillArc(120, 80, 20, 20, 0, 360);//Bola mata kiri
        g.fillArc(160, 80, 20, 20, 0, 360);//Bola mata kanan
        g.fillArc(140, 100, 20, 20, 0, 360);//Hidung
        g.fillArc(127, 100, 45, 45, 180, 180);//Mulut
        g.drawLine(100, 90, 95, 30);//Kuping kiri
        g.drawLine(95, 30, 140, 50);//Kuping kiri
        g.drawLine(198, 90, 210, 30);//Kuping kanan
        g.drawLine(210, 30, 160, 50);//Kuping kanan

        g.setColor(Color.red);
        g.fillArc(137, 120, 25, 25, 180, 180);//Lidah

        g.setColor(Color.black);
        g.fillArc(110, 150, 90, 105, 0, 360);//Badan
        g.fillRect(70, 170, 60, 10);//Tangan kiri
        g.fillArc(60, 155, 20, 40, 0, 360);//Tangan kiri
        g.fillRect(190, 170, 60, 10);//Tangan kanan
        g.fillArc(230, 155, 20, 40, 0, 360);//Tangan kanan

        g.setColor(Color.gray);
        g.fillArc(120, 175, 70, 70, 0, 360);//Perut

        g.setColor(Color.black);
        g.fillRect(263, 360, 20, 70);//Kaki kiri
        g.fillArc(235, 410, 50, 30, 0, 360);//Kaki kiri
        g.fillRect(313, 360, 20, 70);//Kaki kanan
        g.fillArc(310, 410, 50, 30, 0, 360);//Kaki kanan
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kucing Nyengir");
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(316, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Drawing2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Drawing2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Drawing2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Drawing2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Drawing2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
