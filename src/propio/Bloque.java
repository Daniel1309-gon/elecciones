/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package propio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Bloque {
    private int index;
    private String nombre;
    private String cedula;
    private long time;
    private String voto;
    
    private String hash;
    private String previousHash;

    public Bloque(int index, String nombre, String cedula, String voto, String previousHash) {
        this.index = index;
        this.nombre = nombre;
        this.cedula = cedula;
        this.time = new Date().getTime();
        this.voto = voto;
        this.hash = calculateHash();
        this.previousHash = previousHash;
    }
    
    public String calculateHash() {
        String votoToHash = index + time + voto + previousHash;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(votoToHash.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }
    
    
    
}
