/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebabc;

import java.util.ArrayList;
import java.util.List;

public class VotingSystem {

    private Blockchain blockchain;
    private List<String> candidates;

    public VotingSystem() {
        blockchain = new Blockchain();
        candidates = new ArrayList<>();
    }

    public void addCandidate(String candidate) {
        candidates.add(candidate);
    }

    public boolean vote(String candidate) {
        if (candidates.contains(candidate)) {
            String previousHash = blockchain.getLatestBlock().getHash();
            String data = "Voto: " + candidate;
            Block newBlock = new Block(blockchain.getSize(), data, previousHash);
            blockchain.addBlock(newBlock.getData());
            return true;
        }
        return false;
    }
    
    public boolean isChainValid() {
        for (int i = 1; i < blockchain.getSize(); i++) {
            Block currentBlock = blockchain.getBlock(i);
            Block previousBlock = blockchain.getBlock(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

    public void displayResults() {
        int totalVotes = blockchain.getSize() - 1; // Resta 1 para excluir el bloque génesis

        // Contar los votos para cada candidato
        int votesForCandidateA = 0;
        int votesForCandidateB = 0;

        for (int i = 1; i <= totalVotes; i++) {
            Block block = blockchain.getBlock(i);
            String data = block.getData();

            if (data.contains("Candidato A")) {
            votesForCandidateA++;
        } else if (data.contains("Candidato B")) {
            votesForCandidateB++;
        }
        }

        // Mostrar los resultados
        System.out.println("Resultados de la votación:");
        System.out.println("Candidato A: " + votesForCandidateA + " votos");
        System.out.println("Candidato B: " + votesForCandidateB + " votos");
    }

}
