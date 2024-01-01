package Graph.Ques;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//(Kahn,s Algorithm)
//for BFS we need an array which store the indegree of every node
// then we need a queue data structure and we push the nodes which have 0 indegree
//then we will implement BFS and when we at every node we go to their adjacent nodes and we decrese the indegree of that node
//as soon as indegree of the adjacent node becom zero then we add to our queue
//Intuition - as pre topo sort the no. in ahead have no more node ahead of it that means nodes having indegree zero will
//come ahead and there can be multiple topological sort for a given graph
//T.C - O(N+E)
//S.C-O(N)+O(N)
public class TopoLogicalSortBFS {
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

        int [] ans = toptSort(6,adj);
        for(int i =0;i<6;i++){
            System.out.print(ans[i]+" ");
        }
    }

    private static int[] toptSort(int N, ArrayList<ArrayList<Integer>> adj) {

        int topo[] = new int [N];
        int indegree[] = new int[N];
        for(int i=0;i<N;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int ind =0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[ind++] = node;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }
        }
        return topo;
    }
}
