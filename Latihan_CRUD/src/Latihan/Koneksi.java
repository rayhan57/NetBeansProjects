/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan;


import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author RLB
 */
public class Koneksi {

    private static Connection koneksi;

    public static java.sql.Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost/databarang";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Terhubung");
            } catch (Exception e) {
                System.out.println("Gagal Terhubung");
            }
        }
        return koneksi;
    }
    public static void main(String[] args) {
        getKoneksi();
    }
}
