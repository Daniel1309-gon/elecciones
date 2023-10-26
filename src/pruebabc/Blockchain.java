/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebabc;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> chain;
    private int size;

    public Blockchain() {
        chain = new ArrayList<>();
        size = chain.size();
        // Crea el bloque génesis
        Block genesisBlock = new Block(0, "Bloque Génesis", "0", "voto");
        chain.add(genesisBlock);
    }
    
    public Block getBlock(int index) {
    if (index >= 0 && index < chain.size()) {
        return chain.get(index);
    }
    return null;
}


    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public Block addBlock(String data) {
        Block previousBlock = getLatestBlock();
        int newIndex = previousBlock.getIndex() + 1;
        String previousHash = previousBlock.getHash();
        Block newBlock = new Block(newIndex, data, previousHash);
        chain.add(newBlock);
        return newBlock;
    }

    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

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
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
