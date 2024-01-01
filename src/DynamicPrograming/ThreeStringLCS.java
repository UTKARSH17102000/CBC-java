package DynamicPrograming;

import java.util.Arrays;

public class ThreeStringLCS {
    public static void main(String[] args) {
        String s1 = "agcefd";
        String s2 = "agcfd";
        String s3 = "ad";
        int [][][] strg = new int [s1.length()][s2.length()][s3.length()];
        for(int i =0;i< strg.length;i++){
            for(int j = 0;j<strg[0].length;j++){
                Arrays.fill(strg[i][j],-1);
            }
        }
        System.out.println(ThreeStringLCSREC(s1,s2,s3,0,0,0));
        System.out.println(ThreeStringLCSRECTD(s1,s2,s3,0,0,0,strg));
        System.out.println(LCSBU(s1,s2,s3));

    }

    public static int ThreeStringLCSREC(String s1,String s2 , String s3, int vidx1,int vidx2 , int vidx3){

        if(s1.length() == vidx1 || s2.length() == vidx2 || s3.length() == vidx3)
             return 0;
        int ans =0;
        if(s1.charAt(vidx1) == s2.charAt(vidx2) && s2.charAt(vidx2) == s3.charAt(vidx3) && s1.charAt(vidx1) == s3.charAt(vidx3))
             ans = ThreeStringLCSREC(s1, s2, s3, vidx1+1, vidx2+1, vidx3+1)+1;
            else{
                int o1 = ThreeStringLCSREC(s1, s2, s3, vidx1+1, vidx2, vidx3);
                int o2 = ThreeStringLCSREC(s1, s2, s3, vidx1, vidx2+1, vidx3);
                int o3 = ThreeStringLCSREC(s1, s2, s3, vidx1, vidx2, vidx3+1);
                     ans  = Math.max(o1, Math.max(o2,o3));
            }

            return ans;
    }

    public static int ThreeStringLCSRECTD(String s1,String s2 , String s3, int vidx1,int vidx2 , int vidx3 , int [][][] strg){

        if(s1.length() == vidx1 || s2.length() == vidx2 || s3.length() == vidx3)
            return 0;

        if(strg[vidx1][vidx2][vidx3] != -1)
            return strg[vidx1][vidx2][vidx3];
        int ans =0;
        if(s1.charAt(vidx1) == s2.charAt(vidx2) && s2.charAt(vidx2) == s3.charAt(vidx3) && s1.charAt(vidx1) == s3.charAt(vidx3))
            ans = ThreeStringLCSRECTD(s1, s2, s3, vidx1+1, vidx2+1, vidx3+1,strg)+1;
        else{
            int o1 = ThreeStringLCSRECTD(s1, s2, s3, vidx1+1, vidx2, vidx3,strg);
            int o2 = ThreeStringLCSRECTD(s1, s2, s3, vidx1, vidx2+1, vidx3,strg);
            int o3 = ThreeStringLCSRECTD(s1, s2, s3, vidx1, vidx2, vidx3+1,strg);
            ans  = Math.max(o1, Math.max(o2,o3));
        }
        strg[vidx1][vidx2][vidx3] = ans;
        return ans;
    }
    public static int LCSBU(String s1,String s2, String s3) {
        int [][][] strg= new int [s1.length()+1][s2.length()+1][s3.length()+1];
        // seed
        //	strg[s1.length()][s2.length()] = 0;
        for(int k =s1.length()-1;k>=0;k--){
            for(int i=s2.length()-1;i>=0;i--) {
                for(int j=s3.length()-1;j>=0;j--) {
                    if(s1.charAt(k)== s2.charAt(i) && s2.charAt(i) == s3.charAt(j))
                        strg[k][i][j]=strg[k+1][i+1][j+1]+1;
                    else {
                        int o1= strg[k+1][i][j];
                        int o2= strg[k][i+1][j];
                        int o3 = strg[k][i][j+1];

                        strg[k][i][j] =Math.max(o1, Math.max(o2,o3));
                    }
                }
            }
        }




        return strg[0][0][0];
    }
}
