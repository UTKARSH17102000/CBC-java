package Trees;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

public class BinaryTree {
    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data , Node left , Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

     Node root = null;
     int size =0;
    BinaryTree(){
        Scanner scn = new Scanner(System.in);
        this.root = takeInput(scn, null,false);
    }

    private Node takeInput(Scanner scn , Node parent , boolean isLeftOrRight){
        if(parent ==  null)
             System.out.println("Enter the data for root node :");
        else{
        if(isLeftOrRight)
            System.out.println("Enter the data for left child of:" + parent.data);
        else
            System.out.println("Enter the data for right child of:" + parent.data);
        }

        int nodeData=  scn.nextInt();
        Node node = new Node(nodeData,null,null);
        this.size++;

        boolean choice = false;
        System.out.println("Do you have left Child of : "+ node.data);
        choice = scn.nextBoolean();

        if(choice){
            node.left = takeInput(scn,node,true);
        }
         choice = false;
        System.out.println("Do you have right Child of : "+ node.data);
        choice = scn.nextBoolean();


        if(choice){
            node.right = takeInput(scn,node,false);
        }

        return node;
    }


    public void dispaly(){
        this.display(this.root);
    }

    private void display(Node node){
       String str = "";
        if(node.left != null)
         str += node.left.data + "=>";
       else
            str +="END =>";

       str += node.data;

        if(node.right != null)
            str += "=>" +  node.right.data ;
        else
            str +="=> END";

        System.out.println(str);
        if(node.left != null)
            this.display(node.left);
        if(node.right != null)
            this.display(node.right);
    }

    public int height(){
        return this.height(this.root);
    }

    private int height(Node node){
        if(node == null)
             return 0;
        int lheight =this.height(node.left);
        int rheight =this.height(node.right);

        int height = Math.max(lheight,rheight)+1;
        return height;

    }

    public void postOrder(){
           postOrder(this.root);
           System.out.println("END");
    }

    private void postOrder(Node node){
        if(node == null)
             return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " , ");
    }

    public void preOrder(){
        preOrder(this.root);
        System.out.println("END");
    }

    private void preOrder(Node node){
        if(node ==null)
            return ;

        System.out.print(node.data +" , ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void Inorder(){
        InOrder(this.root);
        System.out.println("END");
    }

    private void InOrder(Node node){
        if(node == null)
            return;

        InOrder(node.left);
        System.out.print(node.data +" , ");
        InOrder(node.right);
    }

    public void LevelOrder(){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while(!queue.isEmpty()){
            Node rv = queue.removeFirst();
            System.out.print(rv.data + " , ");
            if(rv.left!=null)
                queue.addLast(rv.left);
            if(rv.right != null)
                queue.addLast(rv.right);
        }

        System.out.println("END");
    }

    public int Diameter(){
       return this.Diameter(this.root);
    }

    private int Diameter(Node node){
        if(node == null)
             return 0;
        int c1 = this.height(node.left)+this.height(node.right)+1;
        int c2 = this.Diameter(node.left);
        int c3 = this.Diameter(node.right);

        return Math.max( Math.max(c1,c2),c3);
    }

    public  int diameterBetter(){
        return this.diameterBetter(this.root).Diameter;
    }


    private DiaPair diameterBetter(Node node){
           if(node == null){
               DiaPair bp = new DiaPair(0,0);
               return bp;
           }
        DiaPair lp = this.diameterBetter(node.left);
        DiaPair rp = this.diameterBetter(node.right);

        DiaPair mp = new DiaPair();
        mp.height = Math.max(lp.height,rp.height)+1;
        mp.Diameter = Math.max(lp.height+ rp.height+1,Math.max(lp.Diameter,rp.Diameter));
        return mp;
    }

    public class DiaPair{
        int height ;
        int Diameter;

        DiaPair(){

        }

        DiaPair(int height,int Diameter){
            this.height= height;
            this.Diameter = Diameter;
        }
    }


    public int SumLeafNodes(){
        return this.SumLeafNodes(this.root);
    }

    private int SumLeafNodes(Node node){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return node.data;
        int c1 = SumLeafNodes(node.left);
        int c2 = SumLeafNodes(node.right);

        return c1+c2;
    }

    public boolean isBST(){
      return  this.isBST(this.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isBST(Node node,int min,int max){

        if(node == null)
            return true;

        if(node.data >max||node.data<min )
            return false;
        else if(!this.isBST(node.left,min,node.data))
            return false;
        else if(!this.isBST(node.right,node.data,max))
            return false;

        return true;
    }

    public List<Integer> IterativeInorder(){
      return  this.IterativeInorder(this.root);
    }

    private List<Integer> IterativeInorder(Node node){
        if(node == null){
            List<Integer> ans = new ArrayList<>();
            return ans;
        }

        List<Integer> ans = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        while(true){
            if(node != null) {
                s.push(node);
                node = node.left;
            }else{
              if(s.isEmpty())
                  break;
              node = s.pop();
              ans.add(node.data);
              node = node.right;
            }
        }

        return ans;
    }


}
