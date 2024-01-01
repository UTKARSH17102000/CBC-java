package Graph.representation;

public class AdjencyMatrix {

    public static void main(String[] args) {
        int n = 3,m =3;
        //disadvantage - if the value of n >= 10^5 then a 2D matrix is not possible it will give an error of out of memory
        int adj[][] = new int [n+1][m+1];

        //edge 1----2
        adj[1][2] =1 ;
        adj[2][1] =1;

        //edge 2----3
        adj[2][3] =1 ;
        adj[3][2] =1;

        //edge 1---3
        adj[1][3] =1 ;
        adj[3][1] =1;

    }
}
