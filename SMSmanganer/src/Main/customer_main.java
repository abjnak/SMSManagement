/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Node.CustomerNode;
import controler.CustomerList;
import file.file_handle;
import java.util.Scanner;
import model.Customer;

/**
 *
 * @author LAPTOP
 */
public class customer_main {

    public void cus_main() {

        Scanner sc = new Scanner(System.in);
        CustomerList customerList = new CustomerList();
        String filename = "E:\\SMSManagement-main\\SMSManagement-main\\SMSmanganer\\src\\file\\customer.txt";

        while (true) {
            System.out.println("\n===== CUSTOMER MANAGEMENT MENU =====");
            System.out.println("1. Load customer data from file");
            System.out.println("2. Add customer to the end");
            System.out.println("3. Display all customers");
            System.out.println("4. Save customer list to file");
            System.out.println("5. Search customer by ccode");
            System.out.println("6. Delete customer by ccode");
            System.out.println("7. Search customer by name");
            System.out.println("8. Search unshipped products by ccode");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    // 2.1 Load from file
                    try {
                        customerList = file_handle.loadCustomerListFromFile(filename);
                        System.out.println("Customer list loaded successfully.");
                    } catch (Exception e) {
                        System.out.println("Failed to load customer list: " + e.getMessage());
                    }
                    break;

                case 2:
                    // 2.2 Input & add to the end
                    System.out.print("Enter customer code: ");
                    String ccode = sc.nextLine().trim();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine().trim();

                    if (!customerList.isValidPhone(phone)) {
                        System.out.println("Invalid phone number format!");
                        break;
                    }

                    if (customerList.isDuplicate(ccode, phone)) {
                        System.out.println("Duplicate customer code or phone!");
                        break;
                    }

                    customerList.addLast(new Customer(ccode, name, phone));
                    System.out.println("Customer added successfully.");
                    break;

                case 3:
                    // 2.3 Display all
                    System.out.println("Customer list:");
                    customerList.traverse();
                    break;

                case 4:
                    // 2.4 Save to file
                    try {
                        file_handle.saveCustomerListToFile(customerList, filename);
                        System.out.println("Customer list saved successfully.");
                    } catch (Exception e) {
                        System.out.println("Failed to save file: " + e.getMessage());
                    }
                    break;

                case 5:
                    // 2.5 Search by ccode
                    System.out.print("Enter customer code to search: ");
                    String searchCode = sc.nextLine().trim();
                    CustomerNode found = customerList.searchCcode(searchCode);
                    if (found != null) {
                        System.out.println("Customer found: " + found.infor);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 6:
                    // 2.6 Delete by ccode (should also delete orders - pending implementation)
                    System.out.print("Enter customer code to delete: ");
                    String deleteCode = sc.nextLine().trim();
                    if (customerList.searchCcode(deleteCode) != null) {
                        customerList.remove(deleteCode);
                        // TODO: delete related orders from OrderList if implemented
                        System.out.println("Customer deleted successfully.");
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 7:
                    // 2.7 Search by name
                    System.out.print("Enter customer name to search: ");
                    String searchName = sc.nextLine().trim();
                    CustomerNode result = customerList.searchName(searchName);
                    if (result != null) {
                        System.out.println("Customer found: " + result.infor);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 8:
                    // 2.8 Search unshipped products by ccode
                    System.out.print("Enter customer code to check unshipped products: ");
                    String searchUnshipped = sc.nextLine().trim();
                    customerList.searchUnshippedOrdersByCcode(searchUnshipped);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

}
