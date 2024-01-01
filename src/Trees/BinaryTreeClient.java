package Trees;

import java.util.List;

public class BinaryTreeClient {
    public static void main(String[] args) {
        BinaryTree tree  = new BinaryTree();
        tree.dispaly();

        //50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
        System.out.println(tree.height());
        tree.postOrder();
        tree.preOrder();
        tree.Inorder();
        tree.LevelOrder();
        System.out.println(tree.Diameter());
        System.out.println(tree.diameterBetter());
        System.out.println(tree.SumLeafNodes());
        System.out.println(tree.isBST());
        List<Integer> ans = tree.IterativeInorder();
        System.out.println(ans);

    }
}
