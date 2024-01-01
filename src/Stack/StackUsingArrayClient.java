package Stack;

public class StackUsingArrayClient {

    public static void main(String[] args) throws Exception {

        StackUsingArray  stack = new StackUsingArray(5);

        for(int i =1;i<=5;i++){
            stack.push(i*10);
        }
//        stack.display();
//
//        System.out.println(stack.peek());
//        stack.pop();
//        stack.display();
//        System.out.println(stack.peek());
//        stack.display();
//        stack.reverseStack();
//        stack.display();


        stack.display();

        StackUsingArray Helper = new StackUsingArray(5);

        reverseStack(stack,Helper,0);
        stack.display();
    }

    private static void reverseStack(StackUsingArray stack, StackUsingArray helper,int index) throws Exception {

        if(stack.isEmpty())
            return;

        int item = stack.pop();
        reverseStack(stack,helper,index+1);
        helper.push(item);
        if(index == 0){
            while (!helper.isEmpty()){
                stack.push(helper.pop());
            }
        }

    }
}
