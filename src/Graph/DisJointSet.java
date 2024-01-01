package Graph;

//This data Structure is used to find weather the node belongs to same component
public class DisJointSet {

    int [] parent = new int [1000000];
    int [] rank = new int [1000000];

    public static void main(String[] args) {

        int n =5;

    }

    public void makeSet(int n){
        for(int i =1;i<=n;i++){
            parent[i] = i;
            rank[i]=0;
        }
    }
    int findPair(int node){
        if(node == parent[node])
            return node;

        return parent[node] = findPair(parent[node]);
    }

    public void Union(int u,int v){
        u = findPair(u);
        v = findPair(v);
        if(rank[u]<rank[v]){
            parent[u] =v;
        }else if((rank[v]<rank[u])){
            parent[v] =u;
        }else{
            parent[v]=u;
            rank[u]++;
        }
    }

}
