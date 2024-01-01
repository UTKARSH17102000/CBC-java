package Graph.Ques;

import java.util.ArrayList;

//T.C - O(N+E)
//S.C-O(N)
public class DetectCycleDirected {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=9;i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge1;
        adj.get(1).add(2);


        //edge2;
        adj.get(2).add(3);



        //edge3;
        adj.get(3).add(4);
        adj.get(3).add(6);

        //edge4;
        adj.get(4).add(5);



        //edge5;

        //edge6;
        adj.get(6).add(5);

        //edge7;
        adj.get(7).add(2);
        adj.get(7).add(8);

        //edge8;

        adj.get(8).add(9);


        //edge9;
        adj.get(9).add(7);

        for(int i =1;i<=9;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)  + " ");
            }
            System.out.println();
        }


        System.out.println(Cycle(9,adj));
    }

    private static boolean Cycle(int N, ArrayList<ArrayList<Integer>> adj) {
        
        boolean vis[] = new boolean[N+1];
        boolean dfsVis[] = new boolean[N+1];
        
        for(int i =1;i<=N;i++){
            if(vis[i] == false){
                if(check(i,adj,vis,dfsVis)){
                    return  true;
                }
            }
        }
        
        return false;
    }

    private static boolean check(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] dfsVis) {

        vis[node] = true;
        dfsVis[node] = true;

        for(int it:adj.get(node)){
            if(vis[it] == false){
                if(check(it,adj,vis,dfsVis) == true) {
                    return true;
                }
            }else if(dfsVis[it] == true){
                return true;
            }
        }
        dfsVis[node] = false;
        return  false;
    }
}
