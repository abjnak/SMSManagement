package file;

import Node.Node;

import java.io.*;
import java.util.*;
import model.*;
import controler.*;

public class ProductFileReader {

    protected Node head, tail;
    private Scanner can = new Scanner(System.in);

    public static List<Products> readProductsFromFile(String filePath) {
        List<Products> productsa = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 8) {
                    try {
                        String pcode = parts[0];
                        String name = parts[1];
                        String maker = parts[2];
                        String unit = parts[3];
                        String category = parts[4];
                        int quantity = Integer.parseInt(parts[5]);
                        int saled = Integer.parseInt(parts[6]);
                        double price = Double.parseDouble(parts[7]);

                        Products product = new Products(pcode, name, maker, unit, category, quantity, saled, price);
                        productsa.add(product);

                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng số: " + line);
                    }

                }
            }

        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }

        return productsa;
    }

    public void loadFromFile(String filePath) {
        Linkedproject m = new Linkedproject();
        List<Products> list = ProductFileReader.readProductsFromFile(filePath);
        for (Products p : list) {
            m.addLast(p); // Đưa vào danh sách liên kết
        }
    }

    

    public Products insertData() {
        String file = "products.txt";

        List<Products> proi = ProductFileReader.readProductsFromFile(file);
        try {
            System.out.println("Enter pcode:");
            String pcode = can.nextLine();
             
            System.out.println("Enter name:");
            String name = can.nextLine();

            System.out.println("Enter market:");
            String market = can.nextLine();
            System.out.println("Enter unit:");
            String unit = can.nextLine();
            System.out.println("Enter catergory:");
            String catergory = can.nextLine();
            System.out.println("Enter quality:");
            int quality = can.nextInt();
            can.nextLine();

            System.out.println("Enter sale:");
            int sale = can.nextInt();
            can.nextLine();
            System.out.println("Enter price:");
            double price = can.nextDouble();
            Boolean vali = true;

            for (Products products : proi) {
                if (products.getPcode().equalsIgnoreCase(pcode)) {
                    System.out.println("ma pcode da ton tai!");
                    vali = false;
                    break;
                }
            }
            if (quality <= 0) {
                System.out.println("enter quality must > 0");
                vali = false;

            }
            if (sale >= quality) {
                System.out.println("enter sale <= quality");
                vali = false;

            }

            if (vali) {
                Products a = new Products(pcode, name, market, unit, catergory, quality, sale, price);
                System.out.println("them san pham thanh cong!");

                return a;

            }

        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return null;

    }

}
