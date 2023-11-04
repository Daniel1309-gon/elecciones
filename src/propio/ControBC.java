/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package propio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author LENOVO
 */
public class ControBC {

    public static final String user = "root";
    public static final String password = "password";
    public static final String url = "jdbc:mysql://localhost/elecciones";


    public static int getLatestBlockIndex() {
        int index = 0;
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM cadena ORDER BY indice DESC LIMIT 1");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                index = rs.getInt("indice");
            } else {
                index = 0;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return index;
    }

    public static String getLatestBlockHash() {
        String hash = "";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM cadena ORDER BY indice DESC LIMIT 1");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                hash = rs.getString("hash");
            } else {
                hash = "";
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return hash;
    }

    public static void addBlock(String nombre, String cedula, String voto) {
        int newIndex = getLatestBlockIndex();
        String previousHash = getLatestBlockHash();
        Bloque newBlock = new Bloque(newIndex, nombre, cedula, voto, previousHash);
        long tiempo = newBlock.getTime();
        String hash = newBlock.getHash();
        //cadena.add(newBlock);
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement("INSERT INTO cadena (nombre, cedula, tiempo, voto, hash, hashPrevio) VALUES (?,?,?,?,?,?)");
            pst.setString(1, nombre);
            pst.setString(2, cedula);
            pst.setLong(3, tiempo);
            pst.setString(4, voto);
            pst.setString(5, hash);
            pst.setString(6, previousHash);

            pst.executeUpdate();

        } catch (SQLException e) {
        }
    }

}
