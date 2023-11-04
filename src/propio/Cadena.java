/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package propio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Cadena {

    private final String user = "root";
    private final String password = "password";
    private final String url = "jdbc:mysql://localhost/elecciones";
    private final Connection con;

    private List<Bloque> cadena;

    public Cadena() throws SQLException {
        cadena = new ArrayList<>();
        Bloque genesis = new Bloque(0, "genesis", "", "voto genesis", "0");
        cadena.add(genesis);
        this.con = DriverManager.getConnection(url, user, password);
    }

    public Bloque getBlock(int index) {
        if (index >= 0 && index < cadena.size()) {
            return cadena.get(index);
        }
        return null;

    }

    public int getLatestBlockIndex() {
        int index = 0;
        try {
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

    public String getLatestBlockHash() {
        String hash = "";
        try {
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

    public void addBlock(String nombre, String cedula, String voto) {
        int newIndex = getLatestBlockIndex();
        String previousHash = getLatestBlockHash();
        Bloque newBlock = new Bloque(newIndex, nombre, cedula, voto, previousHash);
        long tiempo = newBlock.getTime();
        String hash = newBlock.getHash();
        //cadena.add(newBlock);
        try {
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

    public boolean isChainValid() {
        for (int i = 1; i < cadena.size(); i++) {
            Bloque currentBlock = cadena.get(i);
            Bloque previousBlock = cadena.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return cadena.size() - 1;
    }
}
