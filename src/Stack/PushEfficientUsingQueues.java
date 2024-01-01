package Stack;

import Queues.DequeueEfficentUsingStack;
import Queues.ReverseQueue;

public class PushEfficientUsingQueues {

    DequeueEfficentUsingStack Primary = new DequeueEfficentUsingStack();
    DequeueEfficentUsingStack Secondary = new DequeueEfficentUsingStack();

    PushEfficientUsingQueues() throws Exception {

    }

    public boolean isEmpty(){
        return Primary.isEmpty();
    }

    public int size(){
        return Primary.size();
    }

    public void push(int data) throws Exception {
        Primary.enqueue(data);
    }

    public int pop() throws Exception {
        while(Primary.size() != 1){
            Secondary.enqueue(Primary.dequeue());
        }

       int rv =  Primary.dequeue();
        while(!Secondary.isEmpty()){
            Primary.enqueue(Secondary.dequeue());
        }
        return rv;
    }


    public int Front() throws Exception {
        while(Primary.size() != 1){
            Secondary.enqueue(Primary.dequeue());
        }
        int rv =  Primary.dequeue();
        Secondary.enqueue(rv);
        while(!Secondary.isEmpty()){
            Primary.enqueue(Secondary.dequeue());
        }
        return rv;
    }

    public void Display() throws Exception {
        ReverseQueue.reverseQueue(Primary);
        Primary.Display();
        ReverseQueue.reverseQueue(Primary);
    }

    public static void main(String[] args) throws Exception {
        PushEfficientUsingQueues stack = new PushEfficientUsingQueues();

        for(int i =1;i<=6;i++){
            stack.push(i*10);
        }

        stack.Display();

        System.out.println("**********************");
        System.out.println(stack.Front());
        System.out.println(stack.pop());

        System.out.println("**********************");
        stack.Display();
    }
}
