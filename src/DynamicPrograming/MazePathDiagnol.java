package DynamicPrograming;

import java.util.Arrays;

public class MazePathDiagnol {
    public static void main(String[] args) {
     int n =4;
    // System.out.println(MPD(0,0,n,n));
     System.out.println(MPDTD(0,0,n,n, new int [n+1][n+1]));
     System.out.println(MPDBU(0,0,n,n));
     System.out.println(MPDBUSE(0,0,n,n));
    }
    //T.C - (No.of call from 1 Fn frame)^height = 3^(er+ec)
    //S.C -

    public static int MPD(int cr, int cc , int er , int ec ){
        if(cc==ec && cr == er )
             return 1;
        if(cr>er  || cc>ec)
             return 0;

        int ch = MPD(cr+1,cc,er,ec);
        int cv = MPD(cr,cc+1,er,ec);
        int cd = MPD(cr+1,cc+1,er,ec);

        return ch +cv+cd;
    }
    public static int MPDTD(int cr,int cc , int er , int ec ,int [][] strg){
        if(cc==ec && cr == er )
            return 1;
        if(cr>er  || cc>ec)
            return 0;

        if(strg[cr][cc]!= 0)
            return strg[cr][cc];
        int ch = MPDTD(cr+1,cc,er,ec,strg);
        int cv = MPDTD(cr,cc+1,er,ec,strg);
        int cd = MPDTD(cr+1,cc+1,er,ec,strg);

        strg[cr][cc] = ch +cv+cd;
        return ch +cv+cd;
    }
    //T.C - O(er*ec)
    //S.C - O(er*ec) // removes recursion extra space
    public static int MPDBU(int cr,int cc , int er , int ec){
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
                    strg[row][col] = strg[row+1][col]+strg[row][col+1]+strg[row+1][col+1];
                }
            }
        }
        return strg[0][0];
    }

    //T.C - er*ec
    //S.C - ec
    public static int MPDBUSE(int cr , int cc , int er , int ec){
        int strg[] = new int [ec+1];
        //overlap it with the last row of 2d array fill it with 1
        // and update it  er times
        //as we know that right most col have same value 1 when col == ec strg[col] =1
        // otherwise the val of strg[col] = sum right col and down col
        //In this case down col is itself only and add right col which is strg[col+1]
        //To store diag value we store diag = strg[col] and store the ans in val = strg[col] + strg[col+1] + diag; then update diag and then update strg[col] = val
        // to prevent the val of diag for next No.
        Arrays.fill(strg,1);
        int diag = 1;
        for(int i =0;i<er;i++){
            for(int col = ec;col>=0;col--){
                if(col == ec){
                    strg[col] = 1;
                    diag =1;
                }

                else{
                    int val = strg[col]+strg[col+1] + diag;
                    diag = strg[col];
                    strg[col] = val;
                }
            }
        }
        return strg[0];
    }
}
