/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package propio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Cadena {

    private List<Bloque> cadena;

    public Cadena() {
        cadena = new ArrayList<>();
        Bloque genesis = new Bloque(0, "genesis", 0, "voto genesis", "0");
        cadena.add(genesis);
    }

    public Bloque getBlock(int index) {
        if (index >= 0 && index < cadena.size()) {
            return cadena.get(index);
        }
        return null;

    }
    
    public Bloque getLatestBlock() {
        return cadena.get(cadena.size() - 1);
    }
    
    public Bloque addBlock(String nombre, int cedula, String voto) {
        Bloque previousBlock = getLatestBlock();
        int newIndex = previousBlock.getIndex() + 1;
        String previousHash = previousBlock.getHash();
        Bloque newBlock = new Bloque(newIndex, nombre, cedula, voto, previousHash);
        cadena.add(newBlock);
        return newBlock;
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
    
    public int getSize(){
        return cadena.size()-1;
    }
}
