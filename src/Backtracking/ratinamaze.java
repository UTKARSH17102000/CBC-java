package Backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class ratinamaze {

    public static void main(String args[]) {
        // Your Code Here

        Scanner scn = new Scanner (System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        char [][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String data = "";
            if (scn.hasNext()) { // input from user
                data = scn.next();
            } else {
                break;
            }
            for (int j = 0; j < m; j++) {
                board[i][j] = data.charAt(j);
            }
        }

        int [][] ans = new int [n][m];


       if(RatInAMaze(board,0,0,n-1,m-1,ans)){
           for(int i=0;i<n;i++){
               for(int j =0;j<m;j++){
                   System.out.print(ans[i][j]+" ");
               }

               System.out.println();
           }
       }else{
           System.out.println(-1);
       }
    }

    public static boolean RatInAMaze(char[][] board , int i , int j , int n , int m , int [][] ans){


        if(i == n && j == m){
            ans[n][m] = 1;
            return true;
        }

        if(i > n || j>m  || board[i][j] == 'X' )
            return false;



        ans[i][j] = 1;
         boolean right = RatInAMaze(board,i,j+1,n,m,ans);
         if(right)
             return true;

       boolean left =  RatInAMaze(board,i+1,j,n,m,ans);

        if (left)
            return true;

        ans[i][j] = 0;

        return false;
    }
}
