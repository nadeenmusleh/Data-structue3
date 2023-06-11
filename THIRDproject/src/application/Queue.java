package application;

import java.io.File;

class Queue {
    
    private static class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;  // front of the queue
    private Node tail;  // back of the queue

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(String st) {
        Node newNode = new Node(st);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
    }

    public String dequeue() {
        if (head == null) {
            return null;
        }
        String data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public String peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }
}



