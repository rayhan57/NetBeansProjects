/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Komgraf;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Looping extends JPanel {

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < 400; i += 100) {
            g.fillRect(0 + i, 0, 50, 50);
            g.fillRect(0 + i, 100, 50, 50);
            g.fillRect(0 + i, 200, 50, 50);
            g.fillRect(0 + i, 300, 50, 50);

            g.fillRect(50 + i, 50, 50, 50);
            g.fillRect(50 + i, 150, 50, 50);
            g.fillRect(50 + i, 250, 50, 50);
            g.fillRect(50 + i, 350, 50, 50);
        }
        g.setColor(Color.BLUE);
        for (int i = 0; i < 400; i += 100) {
            g.fillRect(50 + i, 0, 50, 50);
            g.fillRect(50 + i, 100, 50, 50);
            g.fillRect(50 + i, 200, 50, 50);
            g.fillRect(50 + i, 300, 50, 50);

            g.fillRect(0 + i, 50, 50, 50);
            g.fillRect(0 + i, 150, 50, 50);
            g.fillRect(0 + i, 250, 50, 50);
            g.fillRect(0 + i, 350, 50, 50);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.getContentPane().add(new Looping());
        f.setSize(500, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
    }
}
