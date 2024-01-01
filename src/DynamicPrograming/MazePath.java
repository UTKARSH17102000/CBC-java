package DynamicPrograming;

import java.util.Arrays;

public class MazePath {
    public static void main(String[] args) {
            int n =4;
        System.out.println(MazePath(0,0,n,n));
        System.out.println(MazePathTD(0,0,n,n, new int [n+1][n+1]));
        System.out.println(MazePathBU(0,0,n,n));
        System.out.println(MazePathBUSE(0,0,n,n));

    }
    public static int MazePath(int cr , int cc , int er , int ec){
        if(cr == er && cc == ec)
             return 1;
        if(cr>ec || cc>ec)
            return 0;
        int ch = MazePath(cr,cc+1,er,ec);
        int cv = MazePath(cr+1,cc,er,ec);

        return ch + cv;
    }

    //T.C - No.of unique problems - er *ec
    //S.C - er*ec
    public static int MazePathTD(int cr,int cc , int er , int ec , int [][] strg){
        if(cr == er && cc == ec)
            return 1;
        if(cr>er || cc>ec)
            return 0;
        if(strg[cr][cc] != 0)
             return strg[cr][cc];
        int ch = MazePathTD(cr,cc+1,er,ec,strg);
        int cv = MazePathTD(cr+1,cc,er,ec,strg);
         strg[cr][cc] = ch+cv;
        return ch +cv;
    }

    //T.C - O(er*ec)
    //S.C - O(er*ec) // removes recursion extra space
    public static int MazePathBU(int cr,int cc , int er , int ec){
       // size of array in BU is dependent on the last access point in TD approach
        // here we need to access er+1 and ec+1 coordinate so the size will be er+2 and ec+2
        int [][] strg = new int [er+2][ec+2];
        //to find the ans of cr and cc we need to have the ans of cc+1,cr and cr+1,cc
        //hence the filling can  goes two ways rows wise or column wise

        for(int row = er ; row>=0;row--){
            for(int col = ec;col>=0;col--){
                if(row == er && col == ec)
                    strg[row][col] = 1;
                else{
                    strg[row][col] = strg[row+1][col]+strg[row][col+1];
                }
            }
        }
        for(int i =0;i< strg.length;i++){
            for(int j =0;j<strg[0].length;j++){
                System.out.print(strg[i][j]+" ");
            }
            System.out.println();
        }
          return strg[0][0];
    }

    //T.C - er*ec
    //S.C - ec
    public static int MazePathBUSE(int cr , int cc , int er , int ec){
        int strg[] = new int [ec+1];
        //overlap it with the last row of 2d array fill it with 1
        // and update it  er times
        //as we know that right most col have same value 1 when col == ec strg[col] =1
        // otherwise the val of strg[col] = sum right col and down col
        //In this case down col is itself only and add right col which is strg[col+1]
        // at the end oue ans will get stored in strg[0]or strg[cc]
        Arrays.fill(strg,1);
        for(int i =0;i<er;i++){
           for(int col = ec;col>=0;col--){
               if(col == ec)
                    strg[col] = 1;
               else{
                   strg[col] = strg[col]+strg[col+1];
               }
           }
        }


        return strg[0];
    }

}
