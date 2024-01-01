package DynamicPrograming;

public class fibbonaci {
    public static void main(String[] args) {

        int n  = 20;
        System.out.println(fibRec(n));
        System.out.println(fibTopDown(n,new int [n+1]));
        System.out.println(fibBottomUp(n));
        System.out.println(fibBottomUpSpaceEffi(n));
    }

    //slide n-1 times
    //T.C - O(n)
    //S.C - O(1)
    // as we know to find fib of a no. we have to find fib of previous two no. so
    // we can avoid creating a whole array instead we use two variables and update the variables simultaneously

    private static int fibBottomUpSpaceEffi(int n) {
        int a =0;
        int b =1;
        for(int i =2;i<=n;i++){
        int sum = a+b;
        a = b;
        b= sum;
        }
        return b;
    }

    //T.C - O(n)
    //S.C - O(n)//Array
    private static int fibBottomUp(int n ) {

        int [] strg = new int [n+1];
        strg[0] =0;
        strg[1] =1;

        for(int i =2;i<=n;i++){
            strg[i] = strg[i-1]+ strg[i-2];
        }

        return strg[n];
    }

    //T.C - O(n) // n func calls
    // S.C - O(n) +O(n) // Array + stack
    // Top Down approach did not work  for the value of n greater than 10^5 because we use rec and it will give stack overflow
    private static int fibTopDown(int n, int strg []) {
        if(n == 0 || n == 1)
             return  n;
        if(strg[n] != 0){//reuse
            return strg[n];
        }
        int fnm1 = fibTopDown(n-1,strg);
        int fnm2 = fibTopDown(n-2,strg);
        int fn = fnm1 + fnm2;

        strg[n] = fn;//store
        return fn;
    }

    //T.C - Recursive Function
    // T(n) = T(n-1) + T(n-2)+1
    // T(n) = O(2^n)
    //T.C - Shortcut
    //T.C - No. of Fn Frames * work done in 1 Fn frame
    // no.of calls from 1 Fn frame is 2 hence T.C - 2^n
    private static int fibRec(int n) {

        if(n == 0 || n ==1 )
             return n;

        int fnm1 = fibRec(n-1);
        int fnm2 = fibRec(n-2);
        return  fnm1 + fnm2;
    }

}
