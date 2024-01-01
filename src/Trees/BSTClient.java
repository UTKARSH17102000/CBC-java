package Trees;
public class BSTClient {

    public static void main(String[] args) {

        int arr [] = {10,20,30,40,50,60,70,80,90,100};
        BST tr = new BST(arr);

        tr.Display();
        System.out.println(tr.find(100));
        System.out.println(tr.find(1000));

        tr.add(55);
        tr.add(110);
        tr.Display();

        System.out.println(tr.max());
        tr.remove(110);
        tr.Display();
        tr.remove(50);
        System.out.println("****************");
        tr.Display();

    }



}
