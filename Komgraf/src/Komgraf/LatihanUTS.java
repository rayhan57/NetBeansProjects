/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Komgraf;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author RLB
 */
public class LatihanUTS extends JPanel {

    public void paintComponent(Graphics g) {
        int x1[] = {10, 100, 10, 100};
        int y1[] = {10, 10, 150, 150};
        int pts1 = x1.length;
        g.drawPolygon(x1, y1, pts1);
        g.fillPolygon(x1, y1, pts1);

        int x2[] = {110, 130, 120};
        int y2[] = {80, 80, 100};
        int pts2 = x2.length;
        g.drawLine(120, 50, 120, 80); //garis
        g.drawPolygon(x2, y2, pts2);
        g.fillPolygon(x2, y2, pts2);

        int x3[] = {150, 250, 150, 250};
        int y3[] = {10, 10, 150, 150};
        int pts3 = x3.length;
        g.drawPolygon(x3, y3, pts3);

        int x4[] = {270, 290, 280};
        int y4[] = {80, 80, 100};
        int pts4 = x4.length;
        g.drawLine(280, 50, 280, 80); //garis
        g.drawPolygon(x4, y4, pts4);
        g.fillPolygon(x4, y4, pts4);

        int x5[] = {300, 400, 300, 400};
        int y5[] = {10, 10, 150, 150};
        int pts5 = x5.length;
        g.drawPolygon(x5, y5, pts5);
        g.fillPolygon(x5, y5, pts5);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.getContentPane().add(new LatihanUTS());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setVisible(true);
    }
}
