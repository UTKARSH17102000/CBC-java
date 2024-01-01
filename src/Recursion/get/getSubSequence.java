package Recursion.get;

import java.util.ArrayList;
import java.util.Scanner;

public class getSubSequence {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String str = scn.next();

        System.out.println(GetSS(str));
        System.out.println(GetSSWAscii(str));
    }

    private static ArrayList<String> GetSSWAscii(String str) {

        if(str.length() == 0){
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }

        char cc = str.charAt(0);
        String res = str.substring(1);
        int ascii = cc;
        String s = String.valueOf(ascii);
        ArrayList<String> myResult = new ArrayList<>();
        ArrayList<String> recResult = GetSSWAscii(res);

        for(int i =0;i<recResult.size();i++){
            myResult.add(recResult.get(i));
            myResult.add(cc + recResult.get(i));
            myResult.add(s + recResult.get(i));
        }

        return myResult;
    }

    private static ArrayList<String> GetSS(String str) {
        if(str.length() == 0){
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }


        char cc = str.charAt(0);
        String res = str.substring(1);

        ArrayList<String> MyResult = new ArrayList<>();
        ArrayList<String> recResult = GetSS(res);

        for (int i =0;i<recResult.size();i++){
            MyResult.add(recResult.get(i));
            MyResult.add(cc + recResult.get(i));
        }

        return MyResult;
    }
}

// No. of total  sub sequence  are 2^n ex = abc = 8
// we have to think that recursion will work and think that what is a step lesser problem for ex  in this question we have to find subsequence of abc
// step -1 we find the subsequence of bc and the add a to it ,to find for bc we find subsequence of c and add b to it