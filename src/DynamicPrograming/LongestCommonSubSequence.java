package DynamicPrograming;



public class LongestCommonSubSequence {
    //Brute Force
    //Find all subsequence of both the strings and store them into array
    //Then iterate over smaller array and  check if it is present in second array if true then
    // store it in common array
    // find the largest string from common array and return its length
    // T.C - O(2^m+n);
    public static void main(String[] args) {
       String s1 = "abcd" ;
       String s2 = "agcfd";
       System.out.println(LCSrec(s1,s2));
       System.out.println(LCSrecursionVIDX(s1,s2,0,0));
       System.out.println(LCSTD(s1,s2,0,0,new int [s1.length()+1][s2.length()+1]));
       System.out.println(LCSBU(s1,s2));
    }

    //We will check weather the first char of both strings are equal if true then we call the recursive fun for rest of
    //strings and add 1 for the same char
    //if not equal then we will make two calls one for s1 & ros2 && ros1 & s2
    //Store the max value from both the calls
    // if any of string length = 0 then return 0
    private static int LCSrec(String s1, String s2) {


        if(s1.length() == 0 || s2.length() ==0)
             return 0;

        char ch1 = s1.charAt(0);
        char ch2 = s2.charAt(0);
        //T.C of substring func is O(N)
        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);
        int ans =0;
        if(ch1 == ch2){
            ans = LCSrec(ros1,ros2) +1;
        }else{
            int o1 =LCSrec(s1,ros2);
            int o2 = LCSrec(ros1,s2);
            ans = Math.max(o1,o2);
        }

        return ans;
    }

    //T.C - O(2^M+N)(Exponential)
    //S.C
    //To avoid Substring method we use virtual index method
    public static int LCSrecursionVIDX(String s1,String s2,int vidx1,int vidx2) {
        if(s1.length() ==vidx1 || s2.length()==vidx2)
            return 0;

        char ch1 = s1.charAt(vidx1);

        char ch2 = s2.charAt(vidx2);



        int ans=0;

        if(ch1 == ch2) {
            ans= LCSrecursionVIDX(s1,s2,vidx1+1,vidx2+1)+1;
        }else {
            int o1 = LCSrecursionVIDX(s1,s2,vidx1,vidx2+1);
            int o2 = LCSrecursionVIDX(s1,s2,vidx1+1,vidx2);
            ans=Math.max(o1, o2);
        }
        return ans;
    }



    //T.C - No. of unique problems-o(m*n)
    //S.C = o(m*n)

    public static int LCSTD(String s1,String s2,int vidx1,int vidx2,int [][]strg) {
        if(s1.length() ==vidx1 || s2.length()==vidx2)
            return 0;
        if(strg[vidx1][vidx2] !=0)
            return strg[vidx1][vidx2];

        char ch1 = s1.charAt(vidx1);

        char ch2 = s2.charAt(vidx2);

        int ans=0;

        if(ch1 == ch2) {
            ans= LCSTD(s1,s2,vidx1+1,vidx2+1,strg)+1;
        }else {
            int o1 = LCSTD(s1,s2,vidx1,vidx2+1,strg);
            int o2 = LCSTD(s1,s2,vidx1+1,vidx2,strg);
            ans=Math.max(o1, o2);
        }
        strg[vidx1][vidx2]=ans;
        return strg[vidx1][vidx2];
    }

    //T.C - O(n*m)
    //S.C - o(n*m)
    public static int LCSBU(String s1,String s2) {
        int [][] strg= new int [s1.length()+1][s2.length()+1];
        // seed
        //	strg[s1.length()][s2.length()] = 0;
        for(int i=s1.length()-1;i>=0;i--) {
            for(int j=s2.length()-1;j>=0;j--) {
                if(s1.charAt(i)== s2.charAt(j))
                    strg[i][j]=strg[i+1][j+1]+1;
                else {
                    int o1= strg[i][j+1];
                    int o2= strg[i+1][j];

                    strg[i][j]=Math.max(o1, o2);
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
}
