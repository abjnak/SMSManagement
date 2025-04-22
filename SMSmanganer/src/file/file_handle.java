/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import controler.CustomerList;
import Node.CustomerNode;
import model.Customer;
/**
 *
 * @author LAPTOP
 */
public class file_handle {
    public static controler.CustomerList loadCustomerListFromFile(String filename) throws Exception {
        controler.CustomerList list = new controler.CustomerList();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length == 3) {
                String ccode = parts[0].trim();
                String name = parts[1].trim();
                String phone = parts[2].trim();
                list.addLast(new model.Customer(ccode, name, phone));
            }
        }
        br.close();
        return list;
    }

    public static void saveCustomerListToFile(controler.CustomerList list, String filename) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        Node.CustomerNode current = list.head;
        while (current != null) {
            bw.write(current.infor.ccode + " | " + current.infor.name + " | " + current.infor.phone);
            bw.newLine();
            current = current.next;
        }
        bw.close();
    }    
}
