package Graph.Ques;

import java.util.ArrayList;

//Removing a node which on removal breaks a graph into two parts
//low[it]>=time[node] && parent != -1; it means that to reach its any adjacent node there are no any options hence that is an Atriculation point
//for parent != 1 to remove thr src node
//if src node have multiple individual child(that their child are not interlinked) so that src node would be an articulation poin
//T.C - O(N+E)
//S.C - O(N)
public class ArticulationPoint {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=12;i++){
            adj.add(new ArrayList<Integer>());
        }



        //edge1;
        adj.get(1).add(2);
        adj.get(1).add(4);
        //edge2;
        adj.get(2).add(3);
        adj.get(2).add(1);
        //edge3;
        adj.get(3).add(2);
        adj.get(3).add(4);

        //edge4;
        adj.get(4).add(1);
        adj.get(4).add(5);

        //edge5;
        adj.get(5).add(4);
        adj.get(5).add(6);
        //edge6;
        adj.get(6).add(5);
        adj.get(6).add(7);
        adj.get(6).add(9);
        //edge7;
        adj.get(7).add(6);
        adj.get(7).add(8);
        //edge8;
        adj.get(8).add(7);
        adj.get(8).add(9);
        adj.get(8).add(10);
        //edge9;
        adj.get(9).add(6);
        adj.get(9).add(8);
        //edge10;
        adj.get(10).add(8);
        adj.get(10).add(11);
        adj.get(10).add(12);
        //edge11;
        adj.get(11).add(10);
        adj.get(11).add(12);
        //edge4;
        adj.get(12).add(10);
        adj.get(12).add(11);


        for(int i =1;i<=12;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)  + " ");
            }
            System.out.println();
        }

        PrintArticulation(adj,12);
    }

    private static void PrintArticulation(ArrayList<ArrayList<Integer>> adj, int n) {
    int vis [] = new int [n+1];
    int tim [] = new int [n+1];
    int low [] = new int [n+1];

    int ans [] = new int[n+1];
    int timer =0;
    for(int i =1;i<n;i++){
        if(vis[i] == 0)
            dfs(i,-1,vis,tim,low,adj,timer,ans);
    }

    for(int i =0;i<n;i++){
        if(ans[i] == 1)
            System.out.println(i);
    }
    }

    private static void dfs(int node, int parent, int[] vis, int[] tim, int[] low, ArrayList<ArrayList<Integer>> adj, int timer, int[] ans) {

        vis[node]=1;
        tim[node] = low[node]= timer++;
        int child=0;
        for(int it:adj.get(node)){
            if(it == parent)
                continue;
            if(vis[it] == 0){
                dfs(it,node,vis,tim,low, adj,timer,ans);
                low[node] = Math.min(low[node],low[it]);
                if(low[it] >= tim[node] && parent !=-1){
                    ans[node] =1;
                }
                child++;
            }else{
                low[node] = Math.min(low[node],tim[it]);
            }
            if(parent !=-1 && child>1)
                ans[node] =1;
        }
    }


}
