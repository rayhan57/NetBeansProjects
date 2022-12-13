/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Komgraf;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author RLB
 */
public class Mobil2 extends javax.swing.JPanel {

    /**
     * Creates new form Mobil
     */
    public Mobil2() {
        initComponents();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GeneralPath path = new GeneralPath();
        
        //Awan
        g.setColor(Color.cyan);
        Shape lingkaran1 = new Ellipse2D.Double(100, 20, 50, 50);
        Shape lingkaran2 = new Ellipse2D.Double(140, 20, 50, 50);
        Shape lingkaran3 = new Ellipse2D.Double(90, 40, 70, 30);
        Shape lingkaran4 = new Ellipse2D.Double(120, 40, 90, 30);
        g2d.fill(lingkaran1);
        g2d.fill(lingkaran2);
        g2d.fill(lingkaran3);
        g2d.fill(lingkaran4);

        //Body belakang
        g2d.setColor(Color.red);
        g2d.fillRect(20, 180, 40, 80);

        //Body belakang atas
        Shape persegi = new Rectangle2D.Double(20, 140, 40, 40);
        Shape lingkaran = new Ellipse2D.Double(20, 140, 80, 80);
        Area a1 = new Area(persegi);
        Area a2 = new Area(lingkaran);
        a2.intersect(a1); //persimpangan a1 masuk ke a2
        g2d.fill(a2);

        //Atap
        BasicStroke gtebal = new BasicStroke(4.0f);
        g2d.setStroke(gtebal);
        g2d.drawLine(60, 140, 270, 140);

        //Kaca depan
        BasicStroke Gtebal = new BasicStroke(4.0f);
        g2d.setStroke(Gtebal);
        path.moveTo(270, 140);
        path.curveTo(280, 170, 290, 170, 280, 200);
        g2d.draw(path);

        //Body tengah
        g2d.fillRect(60, 200, 210, 60);
        g2d.fillArc(210, 200, 120, 120, 0, 90);

        //Pembatas 
        g.setColor(Color.black);
        BasicStroke tebal = new BasicStroke(4.0f);
        g2d.setStroke(tebal);
        g2d.drawLine(60, 140, 60, 260);
        g2d.drawLine(60, 210, 290, 210);
        g2d.drawLine(140, 140, 140, 260);
        g2d.drawLine(220, 140, 220, 260);

        //Handle
        g2d.fillRect(150, 220, 20, 10);

        //Ban
        g2d.fillOval(240, 240, 50, 50);//Depan
        g2d.fillOval(70, 240, 50, 50);//Belakang

        //Bumper
        g2d.fillRect(280, 250, 50, 10);

        //Knalpot
        g2d.fillRect(10, 240, 20, 10);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.getContentPane().add(new Mobil2());
        f.setSize(400, 400);
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
