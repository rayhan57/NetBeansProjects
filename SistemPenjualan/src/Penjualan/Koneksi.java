/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Penjualan;

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

        String url = "jdbc:mysql://localhost/sistem_penjualan";
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
