package Queues;

public class PopEfficientUsingQueues {

    DequeueEfficentUsingStack Primary = new DequeueEfficentUsingStack();
    DequeueEfficentUsingStack Secondary = new DequeueEfficentUsingStack();

    public PopEfficientUsingQueues() throws Exception {
    }

    public boolean isEmpty(){
        return Primary.isEmpty();
    }

    public int size(){
        return Primary.size();
    }

    public void push(int data) throws Exception {
        while(!Primary.isEmpty()){
           Secondary.enqueue(Primary.dequeue());
        }

        Primary.enqueue(data);
        while(!Secondary.isEmpty()){
            Primary.enqueue(Secondary.dequeue());
        }
    }

    public int pop() throws Exception {
        return Primary.dequeue();
    }


    public int Front() throws Exception {
          return Primary.Front();
    }

    public void Display() throws Exception {
        Primary.Display();
    }

    public static void main(String[] args) throws Exception {
        PopEfficientUsingQueues stack = new PopEfficientUsingQueues();

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
