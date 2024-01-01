package Queues;

import Stack.StackUsingArray;

public class DequeueEfficentUsingStack {

    StackUsingArray Primary = new StackUsingArray();
    StackUsingArray Secondary = new StackUsingArray();

    public DequeueEfficentUsingStack() throws Exception {

    }

    public boolean isEmpty(){
        return Primary.isEmpty();
    }

    public int size(){
        return Primary.size();
    }

    public void enqueue(int data) throws Exception {
        while (!Primary.isEmpty()){
            Secondary.push(Primary.pop());
        }
        Primary.push(data);
        while (!Secondary.isEmpty()){
            Primary.push(Secondary.pop());
        }
    }

    public int dequeue() throws  Exception{
        return Primary.pop();
    }
    public int Front() throws Exception{
        return Primary.peek();
    }

    public void Display(){
        Primary.display();
    }

    public static void main(String[] args) throws Exception {
        DequeueEfficentUsingStack queue = new DequeueEfficentUsingStack();

        for(int i =1;i<=6;i++){
            queue.enqueue(i*10);
        }

        queue.Display();
        System.out.println(queue.Front());
        System.out.println(queue.dequeue());
        queue.Display();
    }

}
