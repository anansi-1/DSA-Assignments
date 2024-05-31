package Assignment_2;
// Assignment 2 one to four
public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAtPos(int val, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position");
        }
        if (position == 1) {
            insertFirst(val);
            return;
        }
        if (position == size + 1) {
            insertLast(val);
            return;
        }

        LL.Node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        LL.Node node = new LL.Node(val, temp.next);
        temp.next = node;
        size++;
    }
    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }
    public int deleteAtPosition(int position) {
        if (position < 1 || position > size) {
            System.out.println("Invalid position");
        }
        if (position == 1) {
            return deleteFirst();
        }
        if (position == size) {
            return deleteLast();
        }

        Node prev = get(position - 2); // get the (position-1)-th node
        int val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }
    public void deleteAfterNode(Node node) {
        if (node == null || node.next == null) {
            System.out.println("Given node is null or has no next node to delete");
        }

        Node nodeToDelete = node.next;
        node.next = nodeToDelete.next;

        if (nodeToDelete == tail) {
            tail = node;
        }

        size--;
    }

    public Node searchNode(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }


    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> "  );
            temp = temp.next;
        }

            System.out.println("End");

    }


    private class Node{
        private  int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


}
