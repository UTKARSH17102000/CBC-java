package Recursion.print;

import java.util.Scanner;

public class PrintPermutation {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String str = scn.next();

        PrintPerm(str, "");
    }

    private static void PrintPerm(String str, String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }


        for(int i =0;i<str.length();i++ ){

            char c = str.charAt(i);
            String roq = str.substring(0,i) + str.substring(i+1);

            PrintPerm(roq,ans+c);
        }
    }
}
