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
public class LatihanUTS2 extends JPanel {

    public void paintComponent(Graphics g) {
//        int x[] = {200, 100, 320, 50, 300};
//        int y[] = {60, 330, 180, 180, 330};
//        g.drawPolygon(x, y, x.length);
        
        int x[] = {200, 100, 320, 50, 300};
        int y[] = {60, 330, 180, 180, 330};
        g.drawPolygon(x, y, x.length);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.getContentPane().add(new LatihanUTS2());
        f.setSize(500, 500);
        f.setVisible(true);
    }
}
