package DynamicPrograming;

import java.util.Arrays;

public class KorderedLCS {
    public static void main(String[] args) {

        String s1 = "abcdfrg";
        String s2 = "agcfdfrg";
        int k =2;
        int [][] strg  = new int [s1.length()][s2.length()];
        for(int i =0;i< strg.length;i++)
            Arrays.fill(strg[i],-1);
        System.out.println(LCSrecursionVIDX(s1,s2,0,0,k));
        System.out.println(LCSrecursionVIDXTD(s1,s2,0,0,k,strg));
        System.out.println(LCSBU(s1,s2,k));
    }

    public static int LCSrecursionVIDX(String s1,String s2,int vidx1,int vidx2, int k ) {
        if(s1.length() ==vidx1 || s2.length()==vidx2)
            return 0;

        char ch1 = s1.charAt(vidx1);

        char ch2 = s2.charAt(vidx2);



        int ans=0;

        if(ch1 == ch2) {
            ans= LCSrecursionVIDX(s1,s2,vidx1+1,vidx2+1,k)+1;
        }else {
            int o1 = LCSrecursionVIDX(s1,s2,vidx1,vidx2+1,k);
            int o2 = LCSrecursionVIDX(s1,s2,vidx1+1,vidx2,k);
            int o3 =0;
            if(k>=1)
             o3 = LCSrecursionVIDX(s1,s2,vidx1+1,vidx2,k-1)+1;
            ans=Math.max(o1, Math.max(o2,o3));
        }
        return ans;
    }

    public static int LCSrecursionVIDXTD(String s1,String s2,int vidx1,int vidx2, int k , int strg [][] ) {
        if(s1.length() ==vidx1 || s2.length()==vidx2)
            return 0;

        char ch1 = s1.charAt(vidx1);

        char ch2 = s2.charAt(vidx2);


          if(strg[vidx1][vidx2] != -1)
               return strg[vidx1][vidx2];
        int ans=0;

        if(ch1 == ch2) {
            ans= LCSrecursionVIDXTD(s1,s2,vidx1+1,vidx2+1,k,strg)+1;
        }else {
            int o1 = LCSrecursionVIDXTD(s1,s2,vidx1,vidx2+1,k,strg);
            int o2 = LCSrecursionVIDXTD(s1,s2,vidx1+1,vidx2,k,strg);
            int o3 =0;
            if(k>=1)
                o3 = LCSrecursionVIDXTD(s1,s2,vidx1+1,vidx2,k-1,strg)+1;
            ans=Math.max(o1, Math.max(o2,o3));
        }
        strg[vidx1][vidx2]=ans;
        return ans;
    }

    public static int LCSBU(String s1,String s2, int tk) {
        int [][][] strg= new int [tk+1][s1.length()+1][s2.length()+1];
        // seed
        //	strg[s1.length()][s2.length()] = 0;
        for(int k =0;k<=tk;k++){
            for(int i=s1.length()-1;i>=0;i--) {
                for(int j=s2.length()-1;j>=0;j--) {
                    if(s1.charAt(i)== s2.charAt(j))
                        strg[k][i][j]=strg[k][i+1][j+1]+1;
                    else {
                        int o1= strg[k][i][j+1];
                        int o2= strg[k][i+1][j];
                        int o3 =0;
                        if(k>=1)
                            o3 = strg[k][i+1][j+1]+1;

                        strg[k][i][j] =Math.max(o1, Math.max(o2,o3));
                    }
                }
            }
        }




        return strg[tk][0][0];
    }
}
