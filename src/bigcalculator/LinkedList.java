package bigcalculator;
import java.io.*;

public class LinkedList {

    private Node head;
    private int length = 0;
    private boolean sign = false;    
    
    
    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }
    
    public void setSign(boolean check){
        this.sign = check;
    }

    public boolean getSign(){
        return this.sign;
    }

     // Adds an element to the end of the list
    public void add(Object data)  {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;
    }
    
    public LinkedList addFirst(Object data)  {
        LinkedList list = new LinkedList();
        list = list.copyList(this);
        String str = list.toString();
        str = data.toString() + str;
        list = list.toList(str);
        return list;
    }


     // Obtains an element by index
    public Object get(int index) {

        if (head.getNext() == null || index >= length){
            return null;
        }

        Node iterator = head.getNext();
        int counter = 0;

        while(counter < index){

            iterator = iterator.getNext();
            counter++;
        }
        
        
        return iterator.getData();
    }


     // Returns the index of the element in the list
    public int indexOf(Object data) {
        Node obj=head;
        for (int i = 0; i < length; i++) {
            obj = obj.getNext();
            if (obj.getData().equals(data)) {
                return i;
            }
        }
        return -1;
        //throw new Exception("Data not found");
    }


     // Removes an element from the list
    public boolean remove(Object data) {

        if (head.getNext() == null){
            return false;
        }

        Node iterator = head;

        while(iterator.getNext() != null){

            if (iterator.getNext().getData().equals(data)){
                iterator.setNext(iterator.getNext().getNext());
                length--;
                return true;
            }

            iterator = iterator.getNext();
        }

        return false;
    }
    
    public boolean modifyAtPosition(Object data, int position) {

        if (head.getNext() == null){
            return false;
        }

        Node iterator = head;
        int counter = 0;
        while(iterator.getNext() != null){
            iterator = iterator.getNext();
            if (counter == position){
                iterator.setData(data);
                break;
            }
            counter++;
        }

        return false;
    }
    
    
    
    public LinkedList reverseList(){        
        LinkedList newList = new LinkedList();
//        for (int i = this.size()-1; i >= 0; i--){
//            newList.add((int)this.get(i) - 0);
//        }
        String list = this.toString();
        for (int i = list.length() - 1; i >= 0; i--){
            newList.add(list.charAt(i) - '0');
        }
        return newList;
    }
   
    
    public LinkedList copyList(LinkedList list){
        LinkedList newList = new LinkedList(); 
        for (int i = 0; i < list.size(); i++){
            newList.add(list.get(i));
        }
        return newList;
    }
    
    
    
    
    public static void swapList(LinkedList l1, LinkedList l2){
        LinkedList tmp = new LinkedList();
        tmp.copyList(l1);
        l1.copyList(l2);
        l2.copyList(tmp);
    }
    
    public String toString(){
        String s = new String();
        int j = 0;
//        while (this.size() > 1){
//            
//        }
            
        for (int i = 0; i < this.size(); i++){
            s = s + this.get(i);
        }
    return s;
    }
    
    public LinkedList toList(String str){
        LinkedList list = new LinkedList();
        for (int i = 0; i < str.length(); i++)
            list.add(str.charAt(i) - '0');
        return list;
    }
    
    
    public void printList(){
        System.out.print("Kết quả: ");
        int i = 0;
        if (this.sign == true) System.out.print("-");
        
        while ((this.length > 1)&&((int)this.get(0) == 0)){
                this.remove(0);
        }
        // Traverse through the LinkedList
        while (i != this.length) {
            // Print the data at current node
            System.out.print(this.get(i));
            i++;
            // Go to next node
        }
 
        System.out.println();
    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
//import java.io.*;
// 
//// Java program to implement
//// a Singly Linked List
//public class LinkedList {
// 
//    Node head; // head of list
// 
//    // Linked list Node.
//    // Node is a static nested class
//    // so main() can access it
//    static class Node {
// 
//        int data;
//        Node next;
// 
//        // Constructor
//        Node(int d)
//        {
//            data = d;
//            next = null;
//        }
//    }
// 
//    // **************INSERTION**************
// 
//    // Method to insert a new node
//    public static LinkedList insert(LinkedList list,
//                                    int data)
//    {
//        // Create a new node with given data
//        Node new_node = new Node(data);
//        new_node.next = null;
// 
//        // If the Linked List is empty,
//        // then make the new node as head
//        if (list.head == null) {
//            list.head = new_node;
//        }
//        else {
//            // Else traverse till the last node
//            // and insert the new_node there
//            Node last = list.head;
//            while (last.next != null) {
//                last = last.next;
//            }
// 
//            // Insert the new_node at last node
//            last.next = new_node;
//        }
// 
//        // Return the list by head
//        return list;
//    }
// 
//    // **************TRAVERSAL**************
// 
//    // Method to print the LinkedList.
//    public static void printList(LinkedList list)
//    {
//        Node currNode = list.head;
// 
//        System.out.print("\nLinkedList: ");
// 
//        // Traverse through the LinkedList
//        while (currNode != null) {
//            // Print the data at current node
//            System.out.print(currNode.data + " ");
// 
//            // Go to next node
//            currNode = currNode.next;
//        }
//        System.out.println("\n");
//    }
//}
