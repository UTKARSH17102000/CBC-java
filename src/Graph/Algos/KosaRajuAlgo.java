package Graph.Algos;

import java.util.ArrayList;
import java.util.Stack;

//Used to print Strongly Connected Nodes
//Strongly Connected Nodes - Every node is reachable to other node in directed graph
//We use Topo Sort to sort all the nodes in order of finishing point
//Transpose the graph - all the edges gets reversed
//DFS According to the stack formed by Topo sort(Acc. to finishing time on transpose Graph)
//T.C - O(N+E)
//S.C - O(N) +O(N)
public class KosaRajuAlgo {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=7;i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge1;
        adj.get(1).add(2);


        //edge2;
        adj.get(2).add(3);
        adj.get(2).add(4);

        //edge3;
        adj.get(3).add(1);

        //edge4;
        adj.get(4).add(5);

        for(int i =1;i<=5;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)  + " ");
            }
            System.out.println();
        }

        KosoAlgo(adj,5);
    }

    private static void KosoAlgo(ArrayList<ArrayList<Integer>> adj, int n) {

        int vis[] = new int[n+1];
        Stack<Integer> st = new Stack<>();
        for(int i =1;i<=n;i++){
            if(vis[i] == 0)
                dfs(i,st,adj,vis);
        }

        ArrayList<ArrayList<Integer>> trans = new ArrayList<>();
        for(int i =0;i<=n;i++)
            trans.add(new ArrayList<Integer>());
        
        for(int i =0;i<=n;i++){
            vis[i] = 0;
            for(int it:adj.get(i)){
                trans.get(it).add(i);
            }
        }
        
        while (!st.isEmpty()){
            int node = st.peek();
            st.pop();
            if(vis[node] == 0){
                System.out.print("SCC:");
                revDfs(node,trans,vis);
                System.out.println();
            }
        }
    }

    private static void revDfs(int node, ArrayList<ArrayList<Integer>> trans, int[] vis) {
        vis[node] = 1;
        System.out.print(node +" ");
        for(int it:trans.get(node)){
            if(vis[it] == 0){
                revDfs(it,trans,vis);
            }
        }
    }

    private static void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int[] vis) {

        vis[node] = 1;
        for(int it:adj.get(node)){
            if(vis[it] == 0){
                dfs(it,st,adj,vis);
            }
        }
        st.add(node);
    }
}
