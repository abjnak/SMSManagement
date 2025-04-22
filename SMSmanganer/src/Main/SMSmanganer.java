/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import model.*;
import controler.*;
import file.ProductFileReader;

import java.util.List;

/**
 *
 * @author kien3
 */
public class SMSmanganer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        remove m = new remove();
        for (Products products : m.proi) {
            m.pro.addLast(products);
        }
        m.select();
            
        }
}
        
       