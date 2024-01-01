package DynamicPrograming;

public class Knapsack {
    public static void main(String[] args) {

        int [] weight  = {1,3,4,5};
        int [] price  = {1,4,5,7};

        int max =7;
        System.out.println(KnapsackRec(weight,price,0, max));
        System.out.println(KnapsackTD(weight,price,0, max,new int [weight.length][max+1]));
        System.out.println(knapsackBU(weight,price,max));
    }

    //T.C- o(2^n)//Exponential
    //S.C - o(N)
    //for every weight there are two options weather to add that weight or not
    // we make two calls for include and exclude
    public static int KnapsackRec(int [] weight, int[] price, int idx, int cap){
        if(idx == weight.length || cap ==0)
            return 0;

        int exclude = KnapsackRec(weight,price,idx +1,cap);

        int include =0;
        if(cap>= weight[idx])
            include = KnapsackRec(weight,price,idx+1,cap-weight[idx]) + price[idx];

        int ans = Math.max(exclude,include);
        return ans;
    }
    // when idx and cap to find is same then that value repeats then we will take 2D array
    // let say we include 2, 3 not 5 and if we exclude 2,3 and include 5 then the rec repeats itself
    public static int KnapsackTD(int [] weight, int[] price, int idx, int cap, int strg[][]){
        if(idx == weight.length || cap ==0)
            return 0;

        if(strg[idx][cap]!= 0)
             return strg[idx][cap];
        int exclude = KnapsackTD(weight,price,idx +1,cap,strg);

        int include =0;
        if(cap>= weight[idx])
            include = KnapsackTD(weight,price,idx+1,cap-weight[idx],strg) + price[idx];

        int ans = Math.max(exclude,include);
        strg[idx][cap] =ans;
        return ans;
    }


    // TC : n*cap
    //S.C - n*cap
    //Cell Meaning - row - idx , col -  cap
    // for each cell means remaining  items considered for remaining cap
    // 1,5 represents - I1,I2,I3 are considered and the cap is 5
    // ans stores in 0, cap cell
    // full 0 col represents that their is no cap hence we can fill it with 0
    // same with last row when idx == weight.length then no more items left so we fill it with 0
    // filling direction - far a particular cell we have to make sure that the row underneath should already fill
    public static int knapsackBU(int [] wt , int [] price , int cap) {
        int n = wt.length;

        int [][] strg = new int [n+1][cap+1];
        for(int row = n-1;row>=0;row--) {
            for(int col = 1 ;col<=cap;col++) {
                int e = strg[row+1][col];
                int i=0;
                if(col>=wt[row])
                    i = strg[row+1][col-wt[row]]+price[row];
                int ans = Math.max(e, i);
                strg[row][col]=ans;
            }
        }
        return strg[0][cap];
    }
}
