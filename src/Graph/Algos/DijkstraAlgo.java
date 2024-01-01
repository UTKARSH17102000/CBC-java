package Graph.Algos;

//it is used find the shortest path between two nodes
//mostly used when the weight of edges are not equal to unity(Not work with Negetive Edges bcoz it runs into infinite loops)
// we will use a priority Queue which will store distance , Node (Min Heap Priority Queue)
// Reason of taking priority Queue is greedy approach if we choose the node which have smallest dist then it will provide the min dist.
// T.C - O(N+E)logN
// S.C - O(N) + O(N)
//We can also use set data structure instead of priority Queue bcz set also provide min value and also add the functionality to delete a pair



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class pair implements Comparator<pair> {
    int node;
    int weight;
    public pair(int node,int weight){
        this.node = node;
        this.weight = weight;
    }
    public pair(){}
    public int getNode(){
        return node;
    }
    public int getWeight(){
        return weight;
    }

    public int compare(pair pair1, pair pair2){
        if(pair1.weight < pair2.weight)
            return -1;
        if(pair1.weight>pair2.weight)
            return 1;
        return 0;
    }
}
public class DijkstraAlgo {

    public static void main(String[] args) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();

        for(int i =1;i<=6;i++){
            adj.add(new ArrayList<pair>());
        }




        //edge1;
        adj.get(1).add(new pair(2,2));
        adj.get(1).add(new pair(4,1));

        //edge2;
        adj.get(2).add(new pair(1,2));
        adj.get(2).add(new pair(5,5));
        adj.get(2).add(new pair(3,4));

        //edge3

        adj.get(3).add(new pair(2,4));
        adj.get(3).add(new pair(4,3));
        adj.get(3).add(new pair(5,1));

        //edge4;
        adj.get(4).add(new pair(1,1));
        adj.get(4).add(new pair(3,3));

        //edge5;
        adj.get(5).add(new pair(2,5));
        adj.get(5).add(new pair(3,1));

        for(int i =0;i<=5;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j).node  + "," +adj.get(i).get(j).weight+" ");
            }
            System.out.println();
        }

         MinDist(1,adj,6);
    }

    private static void MinDist(int src, ArrayList<ArrayList<pair>> adj, int N) {

        int dist [] = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] =0;

        PriorityQueue<pair> pq = new PriorityQueue<pair>(N , new pair());

        pq.add(new pair(src,0));

        while(pq.size()>0){
            pair node = pq.poll();
            for(pair it:adj.get(node.getNode())){
                if(node.getWeight() + it.getWeight() <dist[it.getNode()]){
                    dist[it.getNode()] = dist[node.getNode()] + it.getWeight();
                    pq.add(new pair(it.getNode(),dist[it.getNode()]));
                }
            }
        }

        for(int i =1;i<N;i++){
            System.out.println(dist[i]);
        }
    }

}
