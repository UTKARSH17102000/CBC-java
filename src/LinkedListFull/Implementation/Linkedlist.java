package LinkedListFull.Implementation;

public class Linkedlist {

    private  class Node{
        int data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    //O(n)
    public void display(){
        Node temp = head;
        while(temp!= null){
            System.out.println(temp.data);

            temp = temp.next;
        }
    }
     ////O(1)
    public void addFirst(int item){

        Node nn = new Node();
        nn.data = item;
        nn.next = null;

        // attach node
        if(this.size>=1){
            nn.next = head;
        }
        // Update Summary data
        if(size == 0){
            this.head = nn;
            this.tail = nn;
            this.size++;
        }else{
            this.head = nn;
            this.size++;
        }

    }

    //O(1)
    public void addLast(int item){


        //create New Node
        Node nn = new Node();
        nn.data = item;
        nn.next = null;

        //attach
        if(this.size>=1)
            this.tail.next = nn;

           // Update Summary data
        if(size == 0){
            this.head = nn;
            this.tail = nn;
            this.size++;
        }else{
            this.tail = nn;
            this.size++;
        }
    }
    //O(1)
    public int getFirst() throws  Exception{
        if(size == 0)
            throw new Exception("List is Empty");

        return  this.head.data;
    }
    //O(1)
    public  int getLast() throws  Exception{
        if(this.size == 0)
             throw new Exception("List is Empty");

        return this.tail.data;
    }
    //O(n)
    public int getAt(int idx) throws Exception{
        if(size == 0)
             throw new Exception("List is Empty");

        if(idx<0 || idx>size)
            throw new Exception("Invalid Input");

        Node temp = head;

        for(int i =1;i<=idx;i++){
            temp = temp.next;
        }

        return temp.data;

    }

    //O(n)
    public Node getNodeAt(int idx) throws Exception{
        if(size == 0)
            throw new Exception("List is Empty");

        if(idx<0 || idx>size)
            throw new Exception("Invalid Input");

        Node temp = head;

        for(int i =1;i<=idx;i++){
            temp = temp.next;
        }

        return temp;

    }
        // //O(n)
    public void addAt(int item, int idx) throws  Exception{
        if(idx<0 || idx>size)
        throw new Exception("Invalid Input");

        if(idx == 0)
            addFirst(item);
        else if (idx == this.size)
            addLast(item);
        else{

            Node nn = new Node();
            nn.data = item;
            nn.next = null;

            Node nn1 = getNodeAt(idx-1);
            Node np1 = nn1.next;
            nn1.next = nn;
            nn.next = np1;
            this.size++;
        }
    }
    //O(1)
    public int removeFirst() throws Exception{
        if(size == 0)
            throw new Exception("List is Empty");

        int rv = this.head.data;
        if(this.size ==1){
            this.head = null;
            this.tail = null;
            this.size--;
        }else{
            this.head = this.head.next;
            this.size--;
        }
        return rv;

    }

    //O(n)
    public int removeLast() throws Exception {

        if(this.size == 0) {
            throw new Exception("LL is empty");
        }

        int rv = this.tail.data;
        if(this.size == 1)
        {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            Node sizem2 = getNodeAt(this.size-2);
            this.tail = sizem2;
            this.tail.next = null;
            this.size--;
        }
        return rv;
    }
    //O(n)
    public int removeAt( int idx) throws Exception{

        if(idx< 0 || idx> size){
            throw new Exception ("Invalid Index");
        }
        if(this.size == 0) {
            throw new Exception("LL is empty");
        }

        if(idx == 0)
        {
            return removeFirst();
        }else if (idx == this.size-1)
            return removeLast();
        else {
            Node nm1 = getNodeAt(idx-1);
            Node n = nm1.next;
            Node np1 = n.next;
            nm1.next = np1;
            this.size--;
            return n.data;

        }
    }


    public   void ReverseLLData()  throws Exception{

        int left = 0;
        int right = this.size-1;

        while(left<=right){
            Node ln= getNodeAt(left);
            Node rn = getNodeAt(right);

            int temp = ln.data;
            ln.data = rn.data;
            rn.data = temp;

            left++;
            right--;

        }
    }

    public int KthNodeFromEnd(int k) throws Exception {

        Node slow = this.head;
        Node fast = this.head;
        if(k<= 0 || k>this.size)
        {
            throw new Exception ("invalid idx");
        }
        for(int i=1;i<=k;i++)
        {
            fast=fast.next;
        }
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow.data;

    }
    public int mid()
    {
        Node slow = this.head;
        Node fast = this.head;

        while(fast.next != null || fast.next.next != null)
        {
            slow = slow.next;
            fast= fast.next.next;
        }

        return slow.data;
    }


}
