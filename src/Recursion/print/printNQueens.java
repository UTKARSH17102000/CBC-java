package Recursion.print;

import java.util.Scanner;

public class printNQueens {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        boolean [][] board = new boolean[n][n];

      System.out.println(CountNQueens(board,0));
      PrintNQueens(board,0,"");
    }

    private static void PrintNQueens(boolean[][] board, int row, String result) {
        if(row == board.length){
            System.out.println(result);
            return;
        }

        for(int col=0;col<board[row].length;col++){
            if(isItSafe(board,row,col)){
                board[row][col] = true;
                PrintNQueens(board,row+1,result+"{"+(row+1+"-"+(col+1)+"}"+";"));
                board[row][col] = false;
            }
        }
    }

    private static int CountNQueens(boolean[][] board, int row) {

        if(row == board.length)
            return 1;

        int count =0;
        for(int col =0;col <board[row].length;col++){
            if(isItSafe(board,row,col)){
                board[row][col] = true;
                count = count + CountNQueens(board,row+1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isItSafe(boolean[][] board, int row, int col) {

        for(int i = row;i>=0;i--){
            if(board[i][col])
                return false;
        }

        for(int i = row,j=col;i>=0&& j>=0;i--,j--){
            if(board[i][j])
                return false;
        }

        for (int i = row, j=col;i>=0&& j<board[i].length;i--,j++){
            if(board[i][j])
                return false;
        }

        return true;
    }
}
