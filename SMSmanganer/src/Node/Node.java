/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Node;

/**
 *
 * @author kien3
 */
public class Node {
   public Object data;
   public Node next;

    public Node() {
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
     
    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", next=" + next + '}';
    }

}
