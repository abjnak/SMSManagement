/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Node.Node;

import file.ProductFileReader;

import java.util.Scanner;
import model.Products;
import controler.*;

/**
 *
 * @author kien3
 */
public class remove {

    public Node head, tail;
    String filess = "products.txt";
    Linkedproject pro = new Linkedproject();
    ProductFileReader a = new ProductFileReader();

    public remove() {
        a.readProductsFromFile(filess, pro);
    }

    public void select() {

        System.out.println("select 1 funtion:");

        Scanner v = new Scanner(System.in);
        do {

            System.out.println("1.display");
            System.out.println("2.Add bengin or ends");
            System.out.println("3.Search by pcode <-> serach by name <-> Search ordered by pcode ");
            System.out.println("4.Delete by pcode");
            System.out.println("5.Sort by pcode");
            System.out.println("6.Add before position k <-> delete position k");
            int choice = v.nextInt();
            try {
                switch (choice) {
                    case 1:
                        Node k = pro.head;
                        while (k != null) {
                            System.out.println("products: " + k.data);
                            k = k.next;
                        }

                        break;

                    case 2:
                        addend();
                        break;
                    case 3:
                        System.out.println("Enter character :");
                        Scanner p = new Scanner(System.in);
                        String l = p.nextLine();
                        pro.sereach(pro, l);
                        break;
                    case 6:
                        
                        
                        break;
                        
                        
                        

                }

            } catch (NumberFormatException e) {
                System.out.println(e);
            }

        } while (true);

    }

    public void addend() {
        Scanner n = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("1. addFirst");
            System.out.println("2. addLast");
            System.out.println("3.exit!");
            choice = n.nextInt();

            switch (choice) {
                case 1:
                    Products add = a.insertData(pro);
                    if (add != null) {
                        pro.addFisrt(add);
                        pro.saveToFile(filess);
                    }
                    break;
                case 2:
                    Products end = a.insertData(pro);
                    if (end != null) {
                        pro.addLast(end);
                        pro.saveToFile(filess);
                    }
                    break;
                case 3:
                    return;

                default:
                    throw new AssertionError();
            }

        } while (true);
    }

}
