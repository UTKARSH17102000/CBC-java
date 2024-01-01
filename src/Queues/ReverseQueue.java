package Queues;


public class ReverseQueue {
    public static void main(String[] args) throws Exception {

        DequeueEfficentUsingStack queue = new DequeueEfficentUsingStack();

        for(int i =1;i<=6;i++){
            queue.enqueue(i*10);
        }

        reverseQueue(queue);
        while (!queue.isEmpty()){
            System.out.println(queue.Front());
            queue.dequeue();
        }

    }

    public static void reverseQueue(DequeueEfficentUsingStack queue) throws Exception {

        if (queue.isEmpty()){
            return;
        }
        int element = queue.Front();
        queue.dequeue();
        reverseQueue(queue);
        queue.enqueue(element);
    }
}
