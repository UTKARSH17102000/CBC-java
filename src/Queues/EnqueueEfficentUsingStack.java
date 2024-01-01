package Queues;

import Stack.StackUsingArray;

public class EnqueueEfficentUsingStack {

   private StackUsingArray Primary  = new StackUsingArray();
    private StackUsingArray Secondary  = new StackUsingArray();
     EnqueueEfficentUsingStack() throws Exception {

     }

     private  boolean isEmpty(){
         return Primary.isEmpty();
     }

     private int size(){
         return Primary.size();
     }

     private void enqueue(int data) throws Exception { // Takes O(1) time Complexity

         this.Primary.push(data);

     }

     private  int Dequeue() throws Exception { // Takes O(n) Time Complexity
         while(Primary.size() !=1){
             Secondary.push(Primary.pop());
         }
        int value = Primary.pop();
         while(!Secondary.isEmpty()){
             Primary.push(Secondary.pop());
         }
         return value;
     }

     private int Front() throws Exception { //// Takes O(n) Time Complexity
         while(Primary.size() !=1){
             Secondary.push(Primary.pop());
         }
         int value = Primary.peek();
         while(!Secondary.isEmpty()){
             Primary.push(Secondary.pop());
         }
         return value;
     }

     private void Display() throws Exception {// Takes O(n) Time Complexity
         ReverseStack(Primary,Secondary,0);
         Primary.display();
          ReverseStack(Primary,Secondary,0);
     }

    private void ReverseStack(StackUsingArray primary, StackUsingArray secondary, int index) throws Exception {
      if(primary.isEmpty()){
          return;
      }

      int item = primary.pop();
      ReverseStack(primary,secondary,index+1);
      secondary.push(item);

      if(index == 0){
          while (!secondary.isEmpty()){
              primary.push(secondary.pop());
          }
      }
     }


    public static void main(String[] args) throws Exception {
        EnqueueEfficentUsingStack queue = new EnqueueEfficentUsingStack();

        for(int i =1;i<=6;i++){
            queue.enqueue(i*10);
        }
        System.out.println(queue.size());
       queue.Display();
        System.out.println(queue.Front());
        queue.Dequeue();
        queue.Display();
       System.out.println(queue.Front());
    }
}
