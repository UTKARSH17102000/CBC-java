package Graph.Ques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//we use bfs
// we take dist array filed with maxValue on every index
// Queue
//we will add the src node and mark the src dist as zero
//T.C-O(N+E)
//S.C- O(N)
//Intuition - as we know that bfs travels in seq. manner so we know that it will provide the shortest dist. to reah a paticular node
public class ShortDistUndirected {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=8;i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge0;
        adj.get(0).add(1);
        adj.get(0).add(3);


        //edge1;
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);

        //edge2;
        adj.get(2).add(1);
        adj.get(2).add(6);

        //edge3;
        adj.get(3).add(0);
        adj.get(3).add(4);


        //edge4;
        adj.get(4).add(3);
        adj.get(4).add(5);

        //edge5;
        adj.get(5).add(4);
        adj.get(5).add(6);


        //edge6;
        adj.get(6).add(2);
        adj.get(6).add(5);
        adj.get(6).add(7);
        adj.get(6).add(8);


        //edge7;
        adj.get(7).add(6);
        adj.get(7).add(8);


        //edge4;
        adj.get(8).add(6);
        adj.get(8).add(7);
        for(int i =0;i<=8;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)  + " ");
            }
            System.out.println();
        }


        System.out.print(Dist(9,adj,6,5));
    }

    private static int Dist(int N, ArrayList<ArrayList<Integer>> adj,int find,int src) {
        int [] dist = new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();

        dist[src] =0;
        q.add(src);

        while (!q.isEmpty()){
            int node = q.poll();
            for(int it:adj.get(node)){
                if(dist[node]+1<dist[it]){
                    dist[it] =dist[node]+1;
                    q.add(it);
                }
            }
        }
         return dist[find];
    }
}
