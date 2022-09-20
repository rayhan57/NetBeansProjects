/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author RLB
 */
public class Koneksi {

    Connection conn;

    public Connection konek() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Terhubung");
        } catch (Exception e) {
            System.out.println("Terputus");
        }

        String url = "jdbc:mysql://localhost/inventory";
        String username = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Berhasil Terkoneksi ke Database");
        } catch (Exception e) {
            System.out.println("Koneksi ke Database Terputus");
        }
        return conn;

    }

}
