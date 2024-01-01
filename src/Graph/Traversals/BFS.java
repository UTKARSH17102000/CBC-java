package Graph.Traversals;


// In this traversal we move to adjacent nodes at first
//   1-2-3    4-6
//     | |
//     7-5
// Ans - 1 2 3 5 7 4 6

// we will make a visited array and we use for loop on every node(if there are more than 1 component) and use that node in bfs function
// bfs function - we will take a queue and we insert the node and mark that visited and run the loop
// until the  queue becomes empty and inside loop we pop the first element and add that to our bfs
// for that first element we check in our adjacency list and add the node which our connected to that node,
// and we will mark visited in our visited array so that no node get traversed more than one time
// T.C - O(N)
// S.C - O(N)

import java.util.ArrayList;
import java.util.*;
public class BFS {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=7;i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge1;
        adj.get(1).add(2);


        //edge2;
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(7);

        //edge3;
        adj.get(3).add(2);
        adj.get(3).add(5);

        //edge4;
        adj.get(4).add(6);


        //edge5;
        adj.get(5).add(3);
        adj.get(5).add(7);
        //edge6;
        adj.get(6).add(4);

        //edge5;
        adj.get(7).add(2);
        adj.get(7).add(5);


        for(int i =1;i<=7;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)  + " ");
            }
            System.out.println();
        }
        ArrayList<Integer> ans = BFS(7,adj);

        for(int i =0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }
    }

    public static ArrayList<Integer> BFS(int V , ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V+1];

        for(int i =1;i<=V;i++){
            if(vis[i] == false){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;

                while(!q.isEmpty()){
                    int node = q.poll();
                    bfs.add(node);
                    for(Integer it : adj.get(node)){
                        if(vis[it] == false){
                            vis[it] = true;
                            q.add(it);
                        }
                    }
                }
            }
        }

        return bfs;
    }
}
