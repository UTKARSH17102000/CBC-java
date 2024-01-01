package DynamicPrograming;

import java.util.Arrays;

public class Mixtures {
//
//    Harry Potter has n mixtures in front of him, arranged in a row. Each mixture has one of 100 different colors (colors have numbers from 0 to 99).
//
//    He wants to mix all these mixtures together. At each step, he is going to take two mixtures that stand next to each other and mix them together, and put the resulting mixture in their place.
//
//    When mixing two mixtures of colors a and b, the resulting mixture will have the color (a+b) mod 100.
//
//    Also, there will be some smoke in the process. The amount of smoke generated when mixing two mixtures of colors a and b is a*b.
//
//    Find out what is the minimum amount of smoke that Harry can get when mixing all the mixtures together.
//
//    Input:
//            2
//            18 19
//            3
//            40 60 20
//
//    Output:
//            342
//            2400
//
//    In the second test case, there are two possibilities:
//
//    first mix 40 and 60 (smoke: 2400), getting 0, then mix 0 and 20 (smoke: 0); total amount of smoke is 2400
//    first mix 60 and 20 (smoke: 1200), getting 80, then mix 40 and 80 (smoke: 3200); total amount of smoke is 4400
//
//    The first scenario is a much better way to proceed.
    public static void main(String[] args) {

        int arr[] = {40,60,20,50};
        System.out.println(MixturesRec(arr,0, arr.length-1));
        int [][] strg = new int [arr.length][arr.length];
        for(int i =0;i< strg.length;i++)
        Arrays.fill(strg[i],-1);
        System.out.println(MixturesTD(arr,0, arr.length-1, strg));
        System.out.println(MixturesBU(arr));
    }

    public  static  int MixturesRec(int [] color , int si , int ei){

        if(si == ei)
            return 0;

        int min = Integer.MAX_VALUE;
        for(int k =si;k<=ei-1;k++){
            int fp = MixturesRec(color,si,k);
            int sp = MixturesRec(color,k+1,ei);

            int sw = Calccolor(color,si,k)*Calccolor(color,k+1,ei);

            int total = fp +sp +sw;
            if(total<min)
                 min = total;
        }

        return min;
    }

    //For T.D method we have to find no. of arguments which are changing in each rec call
    // for this case there are two arguments which are si and ei so 2d array
    public  static  int MixturesTD(int [] color , int si , int ei, int [][] strg){

        if(si == ei)
            return 0;

        if(strg[si][ei] != -1)
             return strg[si][ei];
        int min = Integer.MAX_VALUE;
        for(int k =si;k<=ei-1;k++){
            int fp = MixturesTD(color,si,k,strg);
            int sp = MixturesTD(color,k+1,ei,strg);

            int sw = Calccolor(color,si,k)*Calccolor(color,k+1,ei);

            int total = fp +sp +sw;
            if(total<min)
                min = total;
        }
          strg[si][ei] = min;
        return min;
    }

    //size of strg array - 2D
    //Cell Meaning - 2,2 - It means amount of smoke produced when it splits in (40,60) & (20,50)
    // left 2 - si and right is e1
    // 0,2 - split - (40,60,20)& 50
    //if only 1 element is considered then the ans is 0 so when si == ei then strg[si][ei] =0;
    // filling - can find using rec which say to mix 4 we need the ans of 3 and for 3 we need the ans of 2 and for 2 we need  the ans of 1
    // we use sliding technique where slide goes 0 to arr.length-1
    // ei = si +1;

    // Required slide
    //slide|si|n-slide|n-slide+1
    //  0   3    4      3
    //  1   2    3      2
    //  2   1    2      1
    //  3   0    1      0
    public static  int MixturesBU(int[] arr){

        int [] [] strg = new int[arr.length +1][arr.length+1];

        for(int slide = 0; slide<= arr.length-1;slide++){
            for(int si =0;si<= arr.length-slide-1;si++){
                 int ei = si +slide;
                 if(si == ei)
                     strg[si][ei] =0;
                 else{
                     int min = Integer.MAX_VALUE;
                     for(int k =si;k<=ei-1;k++){
                         int fp = strg[si][k];
                         int sp = strg[k+1][ei];

                         int sw = Calccolor(arr,si,k)*Calccolor(arr,k+1,ei);

                         int total = fp +sp +sw;
                         if(total<min)
                             min = total;
                     }
                     strg[si][ei] = min;
                 }
            }
        }
        return strg[0][arr.length-1];
    }

    public  static  int Calccolor (int [] arr , int i , int j){
        int sum =0;
        for(int k =i;k<=j;k++)
            sum +=arr[k];

        return sum%100;
    }
}
