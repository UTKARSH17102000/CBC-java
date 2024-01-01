package Graph.Ques;

import java.util.ArrayList;

//Bridge Edge - if we remove an edge and graph get broken in two or more components then that edge is known bridge Edge
//we use two arrays 1- time on insertion 2 - least time of insertion we use DFS traversal
//if leastTime[it]>TimeInsert[node] then that edge is a bridge bcz that means u have already reached that better then the last time and hence if u break thea
//edge u can not move ahead to that node hence it is bridge
//if the edge of a node is visited then we update the lowest time
//T.C -O(N+E);
//S.C-O(N)
public class BridgeGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<5;i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge0
        adj.get(0).add(1);
        adj.get(0).add(2);

        //edge1;
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);


        //edge2;
        adj.get(2).add(0);
        adj.get(2).add(1);


        //edge3;
        adj.get(3).add(1);
        adj.get(3).add(4);

        //edge4;
        adj.get(4).add(3);






        for(int i =0;i<5;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)  + " ");
            }
            System.out.println();
        }

        printBridges(adj,5);
    }

    private static void printBridges(ArrayList<ArrayList<Integer>> adj, int n) {
                      int vis[] = new int[n];
                      int tin [] = new int [n];
                      int low [] = new int [n];
                      int timer =0;
                      for(int i =0;i<n;i++){
                          if(vis[i] == 0){
                              dfs(i,-1,vis,tin,low,adj,timer);
                          }
                      }
    }

    private static void dfs(int node, int parent, int[] vis, int[] tin, int[] low, ArrayList<ArrayList<Integer>> adj, int timer) {
           vis[node] = 1;
           tin[node] = low[node] = timer++;

           for(int  it :adj.get(node)){
               if(it == parent)
                   continue;

               if(vis[it] == 0){
                   dfs(it,node,vis,tin,low,adj,timer);
                   low[node] = Math.min(low[node],low[it]);
                   if(low[it]>tin[node]){
                       System.out.println(it + "-" + node);
                   }else{
                       low[node] = Math.min(low[node],tin[it]);
                   }
               }
           }
    }
}
