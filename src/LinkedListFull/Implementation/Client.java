package LinkedListFull.Implementation;

public class Client {

    public static void main(String[] args) throws Exception {

        Linkedlist ll  = new Linkedlist();

        ll.addFirst(10);
        ll.addFirst(20);
        ll.addLast(30);
        ll.display();
        System.out.println("*******************");
        ll.addLast(50);
        ll.display();
        System.out.println("*******************");
        ll.addAt(25,2);
        ll.display();
        System.out.println("*******************");
        ll.ReverseLLData();
        ll.display();
        System.out.println("*******************");

    }
}
