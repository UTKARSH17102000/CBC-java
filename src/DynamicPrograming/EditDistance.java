package DynamicPrograming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "agcfd";
        System.out.println(EDrec(s1,s2));
        System.out.println(EDrecursionVIDX(s1,s2,0,0));
        int strg[][] = new int [s1.length()][s2.length()];
        for(int i =0;i<s1.length();i++){
            Arrays.fill(strg[i],-1);
        }
        System.out.println(EDTD(s1,s2,0,0,strg));
        System.out.println(EDBU(s1,s2));
    }


    //T.C- O(3^M+N)
    public static int EDrec(String s1,String s2){

        if(s1.length() == 0 && s2.length() == 0)
             return 0;
        if(s1.length() == 0 || s2.length() == 0)
            return s2.length();

        char ch1 = s1.charAt(0);
        char ch2 = s2.charAt(0);

        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);
        int ans =0;
        if(ch1 == ch2)
            ans = EDrec(ros1,ros2);
        else{
            int i = EDrec(ros1,s2);//insert
            int d = EDrec(s1,ros2);//delete
            int r = EDrec(ros1,ros2);//replace
            ans = Math.min(Math.min(i,d),r)+1;
        }

        return ans;
    }

    public static int EDrecursionVIDX(String s1 , String s2,int vidx1,int vidx2) {

        if(s1.length()==vidx1 || s2.length()==vidx2)
            return Math.max(s1.length()-vidx1, s2.length()-vidx2);
        char ch1 = s1.charAt(vidx1);
        char ch2 = s2.charAt(vidx2);


        int ans =0;
        if(ch1 == ch2) {
            ans =  EDrecursionVIDX(s1,s2,vidx1+1,vidx2+1);
        }else {
            int i =  EDrecursionVIDX(s1,s2,vidx1+1,vidx2);
            int d =  EDrecursionVIDX(s1,s2,vidx1,vidx2+1);
            int r =  EDrecursionVIDX(s1,s2,vidx1+1,vidx2+1);

            ans = Math.min(i, Math.min(d, r))+1;
        }
        return ans;

    }

    // TC O(m*n)
    public static int EDTD(String s1 , String s2,int vidx1,int vidx2,int [][] strg) {

        if(s1.length()==vidx1 || s2.length()==vidx2)
            return Math.max(s1.length()-vidx1, s2.length()-vidx2);


        if(strg[vidx1][vidx2] !=-1)
            return strg[vidx1][vidx2];

        char ch1 = s1.charAt(vidx1);
        char ch2 = s2.charAt(vidx2);


        int ans =0;
        if(ch1 == ch2) {
            ans =  EDTD(s1,s2,vidx1+1,vidx2+1,strg);
        }else {
            int i =  EDTD(s1,s2,vidx1+1,vidx2,strg);
            int d =  EDTD(s1,s2,vidx1,vidx2+1,strg);
            int r =  EDTD(s1,s2,vidx1+1,vidx2+1,strg);

            ans = Math.min(i, Math.min(d, r))+1;
        }
        strg[vidx1][vidx2]=ans;
        return ans;
    }
        //T.C - o(m*n)
    public static int EDBU(String s1,String s2) {

        int [][] strg = new int [s1.length()+1][s2.length()+1];
// filling bottom to top and right to left
        for(int row = s1.length();row>=0;row--) {
            for(int col = s2.length();col>=0;col--) {
                if(row == s1.length()) {//base case deletion
                    strg[row][col]=s2.length()-col;
                }else if(col == s2.length()) {//base case insertion
                    strg[row][col] = s1.length()-row;
                }else {
                    if(s1.charAt(row) == s2.charAt(col)) {
                        strg[row][col]= strg[row+1][col+1];
                    }else {
                        int i =  strg[row+1][col];
                        int d = strg[row][col+1];
                        int r =  strg[row+1][col+1];

                        strg[row][col] = Math.min(i, Math.min(d, r))+1;

                    }
                }
            }
        }

        for(int i =0;i< strg.length;i++){
            for(int j =0;j<strg[0].length;j++){
                System.out.print(strg[i][j] + " ");
            }
            System.out.println();
        }
        return strg[0][0];
    }
}
