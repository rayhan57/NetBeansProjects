/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Komgraf;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

/**
 *
 * @author RLB
 */
public class LatihanUPM extends javax.swing.JPanel {

    /**
     * Creates new form Rotasi
     */
    public LatihanUPM() {
        initComponents();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

//      Kepala
        g2d.setColor(Color.GREEN);
        g2d.fillOval(70, 30, 150, 100);

//      Kuping
        g2d.setColor(Color.BLUE);
        g2d.fillOval(55, 50, 20, 50);
        g2d.fillOval(215, 50, 20, 50);

//      Mata
        g2d.setColor(Color.WHITE);
        g2d.fillOval(100, 45, 25, 25);
        g2d.fillOval(170, 45, 25, 25);

//      Bola mata
        g2d.setColor(Color.BLACK);
        g2d.fillOval(105, 55, 10, 15);
        g2d.fillOval(175, 55, 10, 15);

//      Hidung
        g2d.setColor(Color.RED);
        g2d.fillArc(125, 40, 50, 50, 240, 60);

//      Topi
        g2d.setColor(Color.PINK);
        g2d.fillArc(100, 5, 90, 60, 0, 180);
        g2d.setColor(Color.RED);
        g2d.fillArc(75, 20, 100, 40, 20, 180);
        g2d.fillArc(115, 20, 100, 40, 340, 180);

//      Mulut
        g2d.setColor(Color.ORANGE);
        g2d.fillOval(105, 100, 80, 15);

//      Badan
        g2d.fillRoundRect(110, 130, 80, 50, 10, 10);

//      Tangan
        g2d.setColor(Color.BLACK);
        g2d.fillOval(70, 135, 40, 15);
        g2d.fillOval(190, 135, 40, 15);

//      Kaki
        g2d.fillOval(120, 180, 15, 40);
        g2d.fillOval(160, 180, 15, 40);
        g2d.fillOval(120, 210, 30, 10);
        g2d.fillOval(160, 210, 30, 10);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.getContentPane().add(new LatihanUPM());
        f.setSize(300, 300);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
