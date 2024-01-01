package Graph.Algos;

//Sort al the edges with respect to weight
//For min. we use greedy approach and to create spanning tree we do not take a node which belongs to same component and to do that we use Disjoint Set
//T.C- (MlogM)
//S.C - O(M)+O(M)+O(M)

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Node{
    int u ,v,w;
    Node(int u,int v,int w){
        this.u = u;
        this.v=v;
        this.w =w;
    }
    int getU(){
        return this.u;
    }
    int getV(){
        return this.v;
    }
    int getWeight(){
        return this.w;
    }

}
class SortComparator implements Comparator<Node>{
    @Override
    public int compare(Node a1,Node a2){
        if(a1.getWeight()< a2.getWeight())
            return -1;
        if(a1.getWeight()> a2.getWeight())
            return 1;
        return 0;
    }
}
public class KruskalsAlgo {


    public static void main(String[] args) {

        int n =5;
        ArrayList<Node> adj = new ArrayList<Node>();

        adj.add(new Node(0,1,2));
        adj.add(new Node(0,3,6));
        adj.add(new Node(1,3,8));
        adj.add(new Node(1,2,3));
        adj.add(new Node(1,4,5));
        adj.add(new Node(2,4,7));

        Kruskal(adj,n);
    }

    private static void Kruskal(ArrayList<Node> adj, int n) {
        Collections.sort(adj,new SortComparator());
        int parent[] = new int [n];
        int rank [] = new int[n];

        for(int i =0;i<n;i++){
            parent[i] = i;
            rank[i]=0;
        }

        int costMst =0;
        ArrayList<Node> mst = new ArrayList<>();
        for(Node it:adj){
            if(findPar(it.getU(),parent) != findPar(it.getV(),parent)){
                costMst += it.getWeight();
                mst.add(it);
                union(it.getU(),it.getV(),parent,rank);
            }
        }

        System.out.println(costMst);
        for(Node it:mst){
            System.out.println(it.getU()+" "+ it.getV()+ " " + it.getWeight());
        }
    }

    private static int findPar(int u, int parent[]) {
        if(u==parent[u]) return u;
        return parent[u] = findPar(parent[u], parent);
    }
    private static void union(int u, int v, int parent[], int rank[]) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        if(rank[u] < rank[v]) {
            parent[u] = v;
        }
        else if(rank[v] < rank[u]) {
            parent[v] = u;
        }
        else {
            parent[v] = u;
            rank[u]++;
        }
    }
}
