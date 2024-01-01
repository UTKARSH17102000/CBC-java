package Graph.Algos;

//this algo works as greedy approach starts with starting node and check for min. weighted edge and connect it with the node
// we will repeat the same step for every node
//Exception case - if we pick a min edge but if that edge create a cycle bcoz in a spanning tree we can not have any cycle so we pick the min
//we take 3 arrays-
   // key - filled with Infinite value
   // MST - filled with false value;
   // Parent filled with -1;

//Implementation - On every step we find the next min node to travel
  // we go to first node and go to its adjacent node we will mark the min weight to go to adjacent node in the key array
  // and mark the parent node in the parent array
  // then we iterate through key array find the min value and move to that node and mark that node true in the mst array
  // for the next row we check for those nodes which already not true in MST array
  // repeat the above steps for every node unless we iterate to every node
//To get MST we just iterate through parent array and connect edges


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgo {

 static  class pair implements Comparator<pair> {
        int node;
        int weight;
        pair(){}
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

     @Override
     public int compare(pair o1, pair o2) {
            if(o1.weight< o2.weight)
                 return -1;
            if(o1.weight>o2.weight)
                return 1;
         return 0;
     }
 }

    public static void main(String[] args) {

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<pair>());
        }

        //edge0;
        adj.get(0).add(new pair(1, 2));
        adj.get(0).add(new pair(3, 6));



        //edge1;
        adj.get(1).add(new pair(0, 2));
        adj.get(1).add(new pair(2, 3));
        adj.get(1).add(new pair(3, 8));
        adj.get(1).add(new pair(4, 5));
        //edge2;
        adj.get(2).add(new pair(1, 3));
        adj.get(2).add(new pair(4, 7));


        //edge3
        adj.get(3).add(new pair(0, 6));
        adj.get(3).add(new pair(1, 8));


        //edge4;
        adj.get(4).add(new pair(1, 5));
        adj.get(4).add(new pair(2, 7));


        for (int i = 0; i < 5; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j).node + "," + adj.get(i).get(j).weight + " ");
            }
            System.out.println();
        }
        Prims(adj,5);
        System.out.println("************");
        OptimisedPrism(adj,5);
    }

    private static void OptimisedPrism(ArrayList<ArrayList<pair>> adj, int N) {//To optimise we can use a priority queue to get the min edge hence we were able to optimise
      //T.C O(NlogN + E)
      //S.C O(N)
        int key [] = new int[N];
        int parent[] = new int[N];
        boolean mst[] = new boolean[N];

        for(int i =0;i<N;i++){
            key[i] = (int)1e8;
            mst[i] = false;
            parent[i] = -1;
        }

        PriorityQueue<pair> pq = new PriorityQueue<pair>(N,new pair());
        key[0] = 0;
        pq.add(new pair(0,key[0]));

        for(int i =0;i<N-1;i++){
            int u = pq.poll().getNode();
            mst[u] = true;
            for(pair it: adj.get(u)){
                if(mst[it.getNode()] == false && it.getWeight()<key[it.getNode()]){
                    parent[it.getNode()] = u;
                    key[it.getNode()] = it.getWeight();
                    pq.add(new pair(it.getNode(),key[it.getNode()]));
                }
            }
        }

        for(int i =1;i<N;i++){
            System.out.println(parent[i]);
        }
    }

    private static void Prims(ArrayList<ArrayList<pair>> adj, int N) { //T.C O(N^2);
      int key [] = new int[N];
      int parent[] = new int[N];
      boolean mst[] = new boolean[N];

      for(int i =0;i<N;i++){
          key[i] = (int)1e8;
          mst[i] = false;
          parent[i] = -1;
      }

      key[0] = 0;

      for(int i =0;i<N;i++){
          int min = (int)1e8,u =0;
          for(int v=0;v<N;v++){
              if(mst[v] == false && key[v]<min){
                  min = key[v];
                  u =v;
              }
          }
          mst[u] = true;

          for(pair it: adj.get(u)){
              if(mst[it.getNode()] == false && it.getWeight()<key[it.getNode()]){
                  parent[it.getNode()] = u;
                  key[it.getNode()] = it.getWeight();
              }
          }

      }

      for(int i =1;i<N;i++){
          System.out.println(parent[i]);
      }
 }
}

