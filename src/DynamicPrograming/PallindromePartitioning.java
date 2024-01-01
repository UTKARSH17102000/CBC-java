package DynamicPrograming;

import java.util.Arrays;

public class PallindromePartitioning {
    public static void main(String[] args) {

        String s = "abacdce";
        System.out.println(PallindromePartitioningRec(s,0,s.length()-1));
        System.out.println(PallindromePartitioningBU(s));

        int [][] strg = new int [s.length()][s.length()];
        for(int i =0;i<strg.length;i++)
            Arrays.fill(strg[i],-1);
        System.out.println(PallindromePartitioningTD(s,0,s.length()-1,strg));
    }

    public static int PallindromePartitioningRec(String s , int si , int ei){

        if(isPallindrome(s,si,ei))
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k = si ;k<=ei-1;k++){
            int fp = PallindromePartitioningRec(s,si,k);
            int sp = PallindromePartitioningRec(s,k+1,ei);
            int total = fp+sp+1;
            if(total<min)
                min = total;
        }

        return min;
    }

    public static int PallindromePartitioningTD(String s , int si , int ei , int [][] strg){

        if(isPallindrome(s,si,ei))
            return 0;

        if(strg[si][ei] != -1)
             return strg[si][ei];
        int min = Integer.MAX_VALUE;
        for(int k = si ;k<=ei-1;k++){
            int fp = PallindromePartitioningTD(s,si,k,strg);
            int sp = PallindromePartitioningTD(s,k+1,ei,strg);
            int total = fp+sp+1;
            if(total<min)
                min = total;
        }
         strg[si][ei] = min;
        return min;
    }

    public  static  boolean isPallindrome(String s , int si , int ei){

        int l = si;
        int r = ei;

        while(l<r){

            if(s.charAt(l) != s.charAt(r))
              return false;
            l++;
            r--;
        }

        return true;
    }

    //cell Meaning - cuts required between the string index si and ei
    // so diagonals were the base case filled with 0
    // filling direction will be diagonally so we use slide technique

    public static int PallindromePartitioningBU(String s){

        boolean [][] isStringPallindrome = pallindromeInfo(s);
        int n = s.length();
        int [][] strg = new int[n][n];
        for(int slide = 0;slide<=n-1;slide++){
            for(int si =0;si<=n-slide-1;si++){
                int ei =si+slide;
                if(isStringPallindrome[si][ei])
                   strg[si][ei] = 0;
                else{
                    int min = Integer.MAX_VALUE;
                    for(int k = si ;k<=ei-1;k++){
                        int fp = strg[si][k];
                        int sp = strg[k+1][ei];
                        int total = fp+sp+1;
                        if(total<min)
                            min = total;
                    }
                    strg[si][ei] = min;
                }
            }
        }

        return strg[0][n-1];
    }

    public static boolean [][] pallindromeInfo(String s){
        boolean [][] isPallindrome = new boolean[s.length()][s.length()];

        for(int i =0;i<isPallindrome.length;i++){
            Arrays.fill(isPallindrome[i],true);
        }
       for(int row =s.length()-2;row>=0;row--){
           for(int col = row+1;col<s.length();col++){
               if(s.charAt(row) ==s.charAt(col))
                   isPallindrome[row][col] = isPallindrome[row+1][col-1];
               else
                   isPallindrome[row][col] = false;
           }
       }

       return isPallindrome;
    }

}
