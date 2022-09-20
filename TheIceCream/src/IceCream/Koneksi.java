/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IceCream;

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
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Terhubung");
        } catch (Exception e) {
            System.out.println("Terputus");
        }

        String url = "jdbc:mysql://localhost/db_ice";
        String username = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Berhasil Terkoneksi");
        } catch (Exception e) {
            System.out.println("Koneksi Gagal");
        }
        return conn;

    }
}
