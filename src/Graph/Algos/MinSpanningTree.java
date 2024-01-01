package Graph.Algos;



import java.util.ArrayList;

//Spanning Tree - When u can convert a graph to a tree and it has exactly N nodes and N-1 edges and every node should be reachable via every other Node
//Min. Spanning trees - Among all possible Spanning trees the tree which have min sum of weights of its edge is called as min. spanning tree
// Algo to find Min. Spanning Trees - Prism & Kruskal
public class MinSpanningTree {
   static class pair{
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
    }
}
