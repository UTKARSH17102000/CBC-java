package Graph.Ques;
//if we reach to a node which is already visited and not a parent node / prev node that means we have detected a cycle
//we will iterate through the graph using BFS traversal and we store two values in a queue - node and its parent/prev node
//if we get a node which is already visited but not a parent/prev node then we return true else we return false;

//T.C - O(N)
// S/C - O(N)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Node{
    int first;
    int sec;
    public Node(int first , int sec){
        this.first =  first;
        this.sec = sec;
    }
}
public class DetectCycleBFS {

    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=11;i++){
            adj.add(new ArrayList<Integer>());
        }

        //edge1;
        adj.get(1).add(2);


        //edge2;
        adj.get(2).add(1);
        adj.get(2).add(4);


        //edge3;
        adj.get(3).add(5);

        //edge4;
        adj.get(4).add(2);



        //edge5;
        adj.get(5).add(3);
        adj.get(5).add(10);
        adj.get(5).add(6);

        //edge6;
        adj.get(6).add(5);
        adj.get(6).add(7);

        //edge7;
        adj.get(7).add(6);
        adj.get(7).add(8);

        //edge8;
      //  adj.get(8).add(7);
        adj.get(8).add(9);
        adj.get(8).add(11);

        //edge9;
        adj.get(9).add(10);
        adj.get(9).add(8);


        //edge10;
        adj.get(10).add(5);
        adj.get(10).add(9);


        //edge11;
        adj.get(11).add(8);

        for(int i =1;i<=11;i++){
            System.out.print(i +"|");
            for(int j =0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)  + " ");
            }
            System.out.println();
        }

        System.out.print(Cycle(11,adj));
    }

    public static boolean Cycle(int V,ArrayList<ArrayList<Integer>> adj){

        boolean [] vis = new boolean[V+1];

        for(int i =1;i<=V;i++){
            if(vis[i] == false){
                if(checkCycle(adj,i,vis))
                    return true;
            }

        }
        return false;
    }

    public static boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int s,boolean [] vis){

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(s,-1));
        vis[s] = true;

        while(!q.isEmpty()){
            int node = q.peek().first;
            int pre = q.peek().sec;
            q.remove();

            for(int it : adj.get(node)){
                if(vis[it] == false){
                    q.add(new Node(it,node));
                    vis[it] = true;
                }else if(pre != it){
                    System.out.print(it+","+node+","+pre);
                    return true;
                }

            }
        }

        return false;
    }
}
