package Graph.Ques;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// as we know that topological sort is not applicable on cyclic graph
//we use the above info and try to find the topological sort if we did not get that then the cycle exists otherwise it is an Acyclic graph
public class CycleDirectedBFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=9;i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge1;
        adj.get(1).add(2);


        //edge2;
        adj.get(2).add(3);



        //edge3;
        adj.get(3).add(4);
        adj.get(3).add(6);

        //edge4;
        adj.get(4).add(5);



        //edge5;

        //edge6;
        adj.get(6).add(5);

        //edge7;
        adj.get(7).add(2);
        adj.get(7).add(8);

        //edge8;

        adj.get(8).add(9);


        //edge9;
        adj.get(9).add(7);

        for(int i =1;i<=9;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)  + " ");
            }
            System.out.println();
        }
        System.out.print(Cycle(9,adj));    
    }

    private static boolean Cycle(int N, ArrayList<ArrayList<Integer>> adj) {

        int [] indegree = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            for(int it:adj.get(i))
                 indegree[it]++;
        }

        for(int i =1;i<=N;i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        int cnt =0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
        }
        if(cnt == N) return false;

        return true;
    }


}
