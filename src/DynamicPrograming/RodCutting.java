package DynamicPrograming;

import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {

        int [] length = {0,1,2,3,4,5,6,7,8};
        int [] prices = {0,1,5,8,9,10,17,17,20};
        int max =8;
        int [][] strg = new int [length.length][max+1];
        for(int i =0;i< strg.length;i++)
            Arrays.fill(strg[i],-1);
        System.out.println(RodCuttingRec(length,prices,0,max));
        System.out.println(RodCuttingMam(prices,prices.length-1));
        int strg1[] = new int [prices.length+1];
            Arrays.fill(strg1,-1);
        System.out.println(RodCuttingMamTD(prices,prices.length-1,strg1));
        System.out.println(RodCuttingMamBU(prices));
        System.out.println(RodCuttingTD(length,prices,0,max,strg));
        System.out.println(RodCuttingBU(length,prices,max));

    }

    public static int RodCuttingRec(int [] len , int [] prices , int idx , int max){
        if(idx == len.length || max<=0)
            return 0;

        int exclude = RodCuttingRec(len,prices,idx+1,max);
        int include =0;
        if(len[idx]<=max)
            include = RodCuttingRec(len,prices,idx+1,max-len[idx])+ prices[idx];

        int ans = Math.max(exclude,include);

        return ans;

    }

    public static int RodCuttingMam( int [] prices , int n){
        int max = prices[n];


        int left = 1;
        int right = n-1;

        while(left<=right){
            int fp = RodCuttingMam(prices,left);
            int sp = RodCuttingMam(prices,right);

            int total = fp+sp;
            if(total>max)
                max = total;

            left++;
            right--;
        }
      return max;
    }

    public static int RodCuttingMamTD( int [] prices , int n,int []strg){
        int max = prices[n];

        if(strg[n] != -1)
            return strg[n];

        int left = 1;
        int right = n-1;

        while(left<=right){
            int fp = RodCuttingMamTD(prices,left,strg);
            int sp = RodCuttingMamTD(prices,right,strg);

            int total = fp+sp;
            if(total>max)
                max = total;

            left++;
            right--;
        }

        strg[n] = max;
        return max;
    }
    //We use 1 d array
    //every cell stores the max value it get bu cutting that length of rod

    public static int RodCuttingMamBU( int [] prices ){

        int strg [] = new int[prices.length];
        strg[0] = prices[0];
        strg[1] = prices[1];

        for(int n =2;n< strg.length;n++){
            int max = prices[n];

            int left = 1;
            int right = n-1;

            while(left<=right){
                int fp = strg[left];
                int sp = strg[right];

                int total = fp+sp;
                if(total>max)
                    max = total;

                left++;
                right--;
            }

            strg[n] = max;
        }
       return strg[prices.length-1];
    }
    public static int RodCuttingTD(int [] len , int [] prices , int idx , int max,int strg [][]){
        if(idx == len.length || max<=0)
            return 0;
          if(strg[idx][max] != -1)
               return strg[idx][max];
        int exclude = RodCuttingTD(len,prices,idx+1,max,strg);
        int include =0;
        if(len[idx]<=max)
            include = RodCuttingTD(len,prices,idx+1,max-len[idx],strg)+ prices[idx];

        int ans = Math.max(exclude,include);
         strg[idx][max] = ans;
        return ans;

    }




    public static int RodCuttingBU(int len[], int prices[], int max){
        int [][] strg = new int [len.length+1][max+1];

        for(int row = len.length-1;row>=0;row--){
            for(int col = 1;col<=max;col++){
                int e = strg[row+1][col];
                int i =0;
                if(len[row]<= col)
                    i = strg[row+1][col-len[row]]+prices[row];
                 strg[row][col] = Math.max(e,i);
            }
        }

        return strg[0][max];
    }
}
