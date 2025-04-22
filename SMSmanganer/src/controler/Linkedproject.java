/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import Node.Node;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import model.Products;

/**
 *
 * @author kien3
 */
public class Linkedproject {

    public Node head, tail;

    /**
     *
     */
    boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void addLast(Products p) {
        if (isEmpty()) {
            head = tail = new Node(p);

        } else {
            Node q = new Node(p);
            tail.next = q;
            tail = q;

        }
    }

    public void visit(Node p) {
        System.out.println(p.data + " ");

    }

    public String traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }

        System.out.println();
        return null;
    }

    public void addFisrt(Products o) {
        if (isEmpty()) {
            head = tail = new Node(o);

        } else {
            Node l = new Node(o);
            l.next = head;
            head = l;

        }

    }

    public Node sereach(Linkedproject a, String u) {
        Node p = a.head;
        while (p.next != null) {
            Products k = (Products) p.data;
            if (k.getPcode().endsWith(u) || k.getName().endsWith(u)) {
                System.out.println(" tim thay :" + p.data);
                return p;
            }
            p = p.next;

        }
        System.out.println(" ko tim thay");
        return null;

    }

    public void insertAfter(Node p, Products x) {

        {
            if (p == tail) {
                addLast(x);
            } else {
                Node q = new Node(x, p);
                q.next = p.next;
                p.next = q;
            }

        }

    }

    public void saveToFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            Node p = head;
            while (p != null) {
                Products prod = (Products) p.data;
                bw.write(prod.getPcode() + "," + prod.getName() + "," + prod.getMaker() + ","
                        + prod.getUnit() + "," + prod.getCategory() + "," + prod.getQuantity() + ","
                        + prod.getSaled() + "," + prod.getPrice());
                bw.newLine();
                p = p.next;
            }
            System.out.println("Danh sách đã lưu vào file.");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

}
