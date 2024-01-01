package Graph.Traversals;

import java.util.ArrayList;
//It is a recursive call we will come to a node add it and move to its adjacent then add that adjacent and then move to its adjacent and so onn

//1 2 4 6 7 3 5
//T.C - O(N) + O(N)
//S.C - O(N)
public class DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=7;i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge1;
        adj.get(1).add(2);


        //edge2;
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(2).add(7);

        //edge3;
        adj.get(3).add(5);

        //edge4;
        adj.get(4).add(2);
        adj.get(4).add(6);


        //edge5;
        adj.get(5).add(3);

        //edge6;
        adj.get(6).add(4);
        adj.get(6).add(7);

        //edge5;
        adj.get(7).add(2);
        adj.get(7).add(6);


        for(int i =1;i<=7;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)  + " ");
            }
            System.out.println();
        }

        ArrayList<Integer> ans = DFS(7,adj);
        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }

    public static ArrayList<Integer> DFS(int V , ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[V+1];

        for(int i=1;i<=V;i++){
            if(vis[i] == false){
                dfs(i,vis,adj,ans);
            }
        }
        return ans;
    }

    public static void dfs(int node , boolean vis[],ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> ans){
        ans.add(node);
        vis[node] = true;
        for(int it:adj.get(node)){
            if(vis[it] == false){
                dfs(it,vis,adj,ans);
            }
        }
    }
}
