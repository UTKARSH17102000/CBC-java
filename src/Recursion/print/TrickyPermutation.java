package Recursion.print;

import java.util.Arrays;
import java.util.Scanner;

public class TrickyPermutation {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String s = scn.next();

        char []arr = s.toCharArray();

        Arrays.sort(arr);



        TricPerm(new String(arr),"");
    }

    private static void TricPerm(String s, String ans) {

        if(s.length() == 0){
            System.out.println(ans);
            return;
        }


        for(int i =0;i<s.length();i++){

            char a = s.charAt(i);

            String res = s.substring(0,i) + s.substring(i+1);

            boolean flag = true;

            for(int j = i+1;j<s.length();j++){
                if(s.charAt(j) == a)
                    flag = false;
            }

            if (flag)
                TricPerm(res,ans + a);
        }
    }
}


// input -ABA

// output
//    AAB
//    ABA
//    BAA