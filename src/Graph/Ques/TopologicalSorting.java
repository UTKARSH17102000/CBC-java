package Graph.Ques;


import java.util.ArrayList;
import java.util.Stack;

//linear order of vertices such that if there is an edge u->v it appears before v in that ordering
//possible for DAG-Directed Acyclic  Graph
//we will use a stack and a visited array to implement topological sort in DFS
//we will make a dfs recursive call for every node and when that call come to an end then we add that node to our stack
//stack for the following  ques - 0 1 3 2 4 5
// we will pop our stack one by one and store in an array which will be our desired result
// T.C - O(N+E)
// S.C - O(N) + O(N)
public class TopologicalSorting {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=5;i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge0;


        //edge1;

        //edge2;
        adj.get(2).add(3);


        //edge3;
        adj.get(3).add(1);

        //edge4;
        adj.get(4).add(0);
        adj.get(4).add(1);


        //edge5;
        adj.get(5).add(0);
        adj.get(5).add(2);
        for(int i =0;i<=5;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)  + " ");
            }
            System.out.println();
        }
        int [] ans = TopoSort(6,adj);

        for(int i =0;i<6;i++)
            System.out.print(ans[i]+" ");
    }

    private static int[] TopoSort(int N, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[N];

        for(int i =0;i<N;i++){
            if(vis[i] == false){
                findTopo(i,vis,adj,st);
            }
        }

        int topo[] = new int[N];
        int ind =0;
        while(!st.isEmpty()){
            topo[ind++] = st.pop();
        }

        return topo;
    }

    private static void findTopo(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
         vis[node] = true;
         for(int it:adj.get(node)){
             if(vis[it] == false){
                 findTopo(it,vis,adj,st);
             }
         }

         st.push(node);
    }
}
