package Graph.representation;

import java.util.ArrayList;

//Space Complexity - Undirected - O(N + 2*E)  Directed - O(N +E)
public class AdjanencyList {
    public static void main(String[] args) {

        int n =3,m =3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge1--2;
        adj.get(1).add(2);
        adj.get(3).add(1);

        //edge2--3;
        adj.get(2).add(3);
        adj.get(3).add(2);

        //edge1--3;
        adj.get(1).add(3);
        adj.get(3).add(1);

        for(int i =0;i<n;i++){
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)  + " ");
            }
            System.out.println();
        }
    }
}
