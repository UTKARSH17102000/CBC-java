package DynamicPrograming;

public class MCM {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int [] arr = {4,2,3,5,1};
        System.out.println(MCMrecursion(arr,0,arr.length-1));
        int [][] strg = new int [arr.length][arr.length];
        System.out.println(MCMTD(arr,0,arr.length-1,strg));
        System.out.println(MCMBU(arr));

    }

    public static int MCMrecursion(int [] arr , int si ,int ei) {
        if(si+1 ==ei)
            return 0;

        int min = Integer.MAX_VALUE;


        // k splits
        for(int k=si+1;k<=ei-1;k++) {
            int fp = MCMrecursion(arr,si,k);
            int sp = MCMrecursion(arr,k,ei);

            int sw = arr[si] * arr[k] * arr[ei];
            int total = fp +sp+sw;
            if(total<min) {
                min = total;
            }
        }
        return min;
    }

    public static int MCMTD(int [] arr , int si ,int ei,int [][] strg) {
        if(si+1 ==ei)
            return 0;

        if(strg[si][ei]!=0)
            return strg[si][ei];

        int min = Integer.MAX_VALUE;


        // k splits
        for(int k=si+1;k<=ei-1;k++) {
            int fp = MCMTD(arr,si,k,strg);
            int sp = MCMTD(arr,k,ei,strg);

            int sw = arr[si] * arr[k] * arr[ei];
            int total = fp +sp+sw;
            if(total<min) {
                min = total;
            }
        }
        strg[si][ei]=min;
        return min;
    }
    // TC : O(n^3)  SC O(n^2)
    public static int MCMBU(int [] arr ) {
        int n = arr.length;
        int [][] strg = new int [n][n];

        //Filling - diagonally
        //if si>=ei then that cell is meaningless
        for(int slide =1 ;slide<=n-1;slide++) {
            for(int si =0;si<=n-slide-1;si++) {
                int ei = si+slide;
                if(si+1 ==ei) {
                    strg[si][ei]=0;
                }else {


                    if(strg[si][ei]!=0)
                        return strg[si][ei];

                    int min = Integer.MAX_VALUE;


                    // k splits
                    for(int k=si+1;k<=ei-1;k++) {
                        int fp = strg[si][k];
                        int sp = strg[k][ei];

                        int sw = arr[si] * arr[k] * arr[ei];
                        int total = fp +sp+sw;
                        if(total<min) {
                            min = total;
                        }
                    }
                    strg[si][ei]=min;
                }

            }
        }

        return strg[0][n-1];
    }


}
