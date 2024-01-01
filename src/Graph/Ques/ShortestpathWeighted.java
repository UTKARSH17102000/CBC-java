package Graph.Ques;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


//we will find the topological sort of DAG
//we will create a dist array store with the max_value
//we will pop the first element of the stack at the first step check weather the dist != max_value(if not max_value that means we have reached node prior).
//we will go to adjacent node and add the weight to our dist array
// now we pop the sec element and do the same step
//T.C- 2O(N+E)
//S.C - O(N)
 class pair{
    int node;
    int weight;
    public pair(int node,int weight){
        this.node = node;
        this.weight = weight;
    }
    public int getNode(){
        return node;
    }
    public int getWeight(){
        return weight;
    }
}
public class ShortestpathWeighted {
    public static void main(String[] args) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();

        for(int i =0;i<=5;i++){
            adj.add(new ArrayList<pair>());
        }

        //edge0;
        adj.get(0).add(new pair(1,2));
        adj.get(0).add(new pair(4,1));


        //edge1;
        adj.get(1).add(new pair(2,3));
        //edge2;
        adj.get(2).add(new pair(3,6));

        //edge3


        //edge4;
        adj.get(4).add(new pair(2,2));
        adj.get(4).add(new pair(5,4));

        //edge5;
        adj.get(5).add(new pair(3,1));

        for(int i =0;i<=5;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j).node  + "," +adj.get(i).get(j).weight+" ");
            }
            System.out.println();
        }
        ShortestPath(0,adj,6);
    }

    private static void ShortestPath(int src, ArrayList<ArrayList<pair>> adj, int N) {

        Stack<Integer> st = new Stack<>();
        int dist[] = new int[N];

        boolean [] vis = new boolean[N];
        Arrays.fill(vis,false);
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i =0;i<N;i++){
            if(vis[i] == false){
                topoSort(i,vis,adj,st);
            }
        }
        dist[src] = 0;
         while (!st.isEmpty()){
             int node = (int)st.pop();
             //if node has been reached previously
             if(dist[node] !=Integer.MAX_VALUE ){
                 for(pair it:adj.get(node)){
                     if(dist[node]+it.getWeight()<dist[it.getNode()]){
                         dist[it.getNode()] = dist[node]+it.getWeight();
                     }
                 }
             }
         }

         for(int i =0;i<N;i++){
             System.out.print(dist[i]+" ");
         }


    }

    private static void topoSort(int node, boolean[] vis, ArrayList<ArrayList<pair>> adj, Stack<Integer> st) {
        vis[node] = true;
        for(pair it:adj.get(node)){
            if(vis[it.getNode()] == false)
                 topoSort(it.getNode(),vis,adj,st);
        }
        st.push(node);
    }

}
