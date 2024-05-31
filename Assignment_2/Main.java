package Assignment_2;

public class Main {

    public static void main(String[] args) {

        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertLast(99);
        list.insertAtPos(100,4);
        list.deleteAtPosition(2);
        System.out.println(list.searchNode(99));
        //list.display();


    }

}
