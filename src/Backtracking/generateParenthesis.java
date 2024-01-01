package Backtracking;

import java.util.Scanner;

public class generateParenthesis {


     public static  int count =0;
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        PrintParanthesis("",0,0,n);
    }

    private static void PrintParanthesis(String ans, int countopen, int countclose, int n) {

          if(count == n)
               return ;
        if(countclose == n){
            System.out.println(ans + " " + count);
            count++;
            return;
        }



        if(countopen>countclose)
            PrintParanthesis(ans + ")" ,countopen,countclose+1,n);


             if(countopen<n)
            PrintParanthesis(ans + "(" ,countopen+1,countclose,n);




    }
}
