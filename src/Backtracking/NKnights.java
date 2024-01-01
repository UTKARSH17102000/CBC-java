package Backtracking;

import java.util.Scanner;

public class NKnights {


    static  int count;
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        boolean [][] board = new boolean[n][n];

       // System.out.println(CountNKnights(board,0,0,0,n));
        PrintKnights(board,0,0,0,n,"");
    }

//    private static int CountNKnights(boolean[][] board, int row, int col, int kpsf, int tk) {
//    }

    private static void PrintKnights(boolean[][] board, int row, int col, int kpsf, int tk, String ans) {

        if(kpsf == tk){
            ++count;
            System.out.println(count + " "+ans);
            return;
        }

        if(col == board[0].length){
            row++;
            col=0;
        }

        if(row == board.length)
            return;

        if(isItSafe(board,row,col)){

            //place
            board[row][col] = true;
            PrintKnights(board,row,col+1,kpsf+1,tk,ans+"{"+ row + " "+ col + "}");
            board[row][col] = false;
        }

        //not place
        PrintKnights(board, row, col+1, kpsf, tk, ans);
    }


    private static boolean isItSafe(boolean[][] board, int row, int col) {

        int [] rowArr = {-1,-2,-2,-1};
        int [] colArr = {2,1,-1,-2};

        for(int i =0;i<4;i++){
            int r = row + rowArr[i];
            int c = col + colArr[i];
            if(r >=0 && r< board.length && c>=0 && c< board.length){
                if(board[r][c])
                    return false;
            }
        }

        return true;
    }
}
