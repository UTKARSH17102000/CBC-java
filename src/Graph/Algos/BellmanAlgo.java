package Graph.Algos;

import java.util.ArrayList;

//provide the shortest past but does not work with the negative weights
//with the help of this algo we ca check weather a negative cycle exists or not
// Relax all the edges N-1 times(longest path can be N-1 Edges so that every node get relaxed)
// Relax - if(dist[u] +wt<dist[v])  dist[v] = dist[u] +wt(just follow the greedy approach)
//T.C O(N-1)*E
//S.C - O(N)

public class BellmanAlgo {
    static class NodeBell{

        int u;
        int v;
        int weight;
        NodeBell(int u ,int v ,int weight){
            this.u =u;
            this.v =v;
            this.weight =weight;
        }

        int getU(){return u;}
        int getV(){return v;}
        int getWeight(){return weight;}
    }
    public static void main(String[] args) {


        ArrayList<NodeBell> adj = new ArrayList<NodeBell>();


            adj.add(new NodeBell(0,1,5));
            adj.add(new NodeBell(1,5,-3));
            adj.add(new NodeBell(1,2,-2));
            adj.add(new NodeBell(2,4,3));
            adj.add(new NodeBell(3,2,6));
            adj.add(new NodeBell(3,4,-2));
            adj.add(new NodeBell(5,3,1));


        Bell(adj,6,0);
    }

    private static void Bell(ArrayList<NodeBell> edges, int N, int src) {

         int dist[] = new int [N+1];
         for(int i =0;i<N;i++){
             dist[i] = Integer.MAX_VALUE;
         }
         dist[src] = 0;
         for(int i =0;i<N;i++)
         {
         for(NodeBell node:edges){
             if(dist[node.getU()] + node.getWeight() < dist[node.getV()] ){
                 dist[node.getV()] = dist[node.getU()] + node.getWeight();
             }
         }
         }
          int fl =0;
         for(NodeBell node :edges){
              if(dist[node.getU()] +node.getWeight() < dist[node.getV()]){
                  fl =1;
                  System.out.println("Negetive Cycle");
                  break;
              }
         }
         if(fl ==0){
             for(int i =0;i<N;i++){
              System.out.println(i + " " + dist[i]);
             }
         }
    }
}
