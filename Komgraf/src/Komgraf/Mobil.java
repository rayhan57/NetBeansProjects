/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Komgraf;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;

/**
 *
 * @author RLB
 */
public class Mobil extends javax.swing.JPanel {

    /**
     * Creates new form Mobil
     */
    public Mobil() {
        initComponents();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        GeneralPath path = new GeneralPath();
        path.moveTo(50, 50);
        path.lineTo(150, 150);
        path.quadTo(200, 200, 250, 150);
        path.quadTo(150, 300, 150, 200);
        path.closePath();

        path.moveTo(50, 500);
        path.lineTo(200, 500);
        path.quadTo(300, 650, 400, 500);
        path.lineTo(550, 500);
        path.quadTo(650, 650, 750, 500);
        path.lineTo(850, 500);
        path.curveTo(850, 500, 850, 300, 750, 250);
        path.lineTo(300, 250);
        path.lineTo(200, 350);
        path.lineTo(50, 350);
        path.lineTo(50, 500);

        g2.draw(path);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.getContentPane().add(new Mobil());
        f.setSize(1000, 1000);
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
