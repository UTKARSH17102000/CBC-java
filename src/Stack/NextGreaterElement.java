package Stack;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {

        int [] arr = {13, 7, 6, 12};

      //  {2,1,3,8,6,7,5}
        Stack<Integer> stack = new Stack<>();


        for(int i =0;i<arr.length;i++){
            while (!stack.isEmpty() && arr[i]>stack.peek()){

                int element = stack.pop();
                System.out.println(element + " -> "+arr[i]);
            }

            stack.push(arr[i]);
        }


            while (!stack.isEmpty())
                System.out.println(stack.pop() + " ->  -1");
        }
}
