/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package propio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author LENOVO
 */
public class PruebaBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cadena cadena = new Cadena();
        cadena.addBlock("Daniel", 1321555, "oviedo");
        cadena.addBlock("felipe", 13542332, "galan");
        cadena.addBlock("alejandro", 99899, "bolivar");
        
        System.out.println(cadena.getBlock(2).getVoto());
    }


}
