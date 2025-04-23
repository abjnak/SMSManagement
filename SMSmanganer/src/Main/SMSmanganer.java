/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import java.util.Scanner;

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
        customer_main mn = new customer_main();
        Scanner r = new Scanner(System.in);

        do {

            System.out.println("1.Prodeuct");
            System.out.println("2.Customer");
            System.out.println("3.Order");
            try {

                int choice = r.nextInt();
                r.nextLine();
                switch (choice) {

                    case 1:
                        m.select();
                        break;
                    case 2:
                        mn.cus_main();

                        break;
                    case 3:

                        break;
                    default:
                        throw new AssertionError();
                }

            } catch (Exception e) {
                System.out.println("lua tron lai!");
                r.nextLine();
            }

        } while (true);

    }
}
