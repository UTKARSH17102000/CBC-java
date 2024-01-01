//package CSESProblemSet.Graph;
import java.util.*;
public class CountingRooms {
    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();
//        System.out.println(n);
//        System.out.println(m);
        char mat[][] = new char[n][m];
        boolean vis[][] = new boolean[n][m];
        for(int i =0;i<n;i++){
           String str = scn.next();
            for(int j =0;j<m;j++){
               mat[i][j]= str.charAt(j);
               vis[i][j]= false;
              // System.out.print(mat[i][j]);
            }
        }
//        for(int i =0;i<n;i++){
//            for(int j =0;j<m;j++){
//              System.out.print(mat[i][j]);
//            }
//            System.out.println();
//        }
        int cnt =0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j] &&  mat[i][j]=='.'){
                    cnt++;
                    dfs(mat,i,j,n,m,vis);
                }
            }
        }

        System.out.println(cnt);

    }

    public static void dfs(char[][] mat , int i ,int j,int n,int m,boolean vis[][]){

        vis[i][j] = true;
       int dx[] = {0,1,-1,0};
       int dy[] = {1,0,0,1};

       for(int d =0;d<4;d++){
           int new_i= i+dx[d];
           int new_j= j+dy[d];

           if(new_i>= 0 && new_i<n && new_j>=0 && new_j<m ){
               if(!vis[new_i][new_j] && mat[new_i][new_j] == '.')
                    dfs(mat,new_i,new_j,n,m,vis);
           }
       }

    }
}
