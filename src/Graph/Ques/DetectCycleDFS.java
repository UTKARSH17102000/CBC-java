package Graph.Ques;

import java.util.ArrayList;
import java.util.Arrays;

// concept is same as BFS
public class DetectCycleDFS {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=11;i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge1;
        adj.get(1).add(2);


        //edge2;
        adj.get(2).add(1);
        adj.get(2).add(4);


        //edge3;
        adj.get(3).add(5);

        //edge4;
        adj.get(4).add(2);



        //edge5;
        adj.get(5).add(3);
        adj.get(5).add(10);
        adj.get(5).add(6);

        //edge6;
        adj.get(6).add(5);
        adj.get(6).add(7);

        //edge7;
        adj.get(7).add(6);
        adj.get(7).add(8);

        //edge8;
        adj.get(8).add(7);
        adj.get(8).add(9);
        adj.get(8).add(11);

        //edge9;
        adj.get(9).add(10);
        adj.get(9).add(8);


        //edge10;
        adj.get(10).add(5);
        adj.get(10).add(9);


        //edge11;
        adj.get(11).add(8);

        for(int i =1;i<=11;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)  + " ");
            }
            System.out.println();
        }
        
        System.out.print(Cycle(11,adj));
    }

    private static boolean Cycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean  vis[] = new boolean[V+1];
        Arrays.fill(vis,false);
        for(int i =1;i<=V;i++){
            if(vis[i] == false){

                if(checkCycle(i,-1,adj,vis))
                    return true;
            }
        }
        return false;
    }

    private static boolean checkCycle(int node,int parent , ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
       vis[node] = true;
       for(int it:adj.get(node)){
           if(vis[it] == false){
               if(checkCycle(it, node,adj,vis) == true) return true;
           }else if(it != parent){
               System.out.println(it + "," + node+","+ parent);
               return true;
           }
       }
       return false;
    }
}
