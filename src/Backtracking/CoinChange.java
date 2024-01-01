package Backtracking;

public class CoinChange {

    private static int count;
    public static void main(String[] args) {


        int arr[] = {2,3,5,6};

        PrintCoinPermu(arr,10,"");
        System.out.println("*********************");
        PrintCoinsCombi(arr,10,"",0);

        System.out.println("***************************");

        PrintCoinChangeWitResCoin(arr,0,10,"");
    }



    private static void PrintCoinChangeWitResCoin(int[] denom, int vidx, int amt, String ans) {
        if(amt == 0){
            count++;
            System.out.println(count + " "+ ans);
            return;
        }

        if(amt <0 || vidx == denom.length)
            return;

        PrintCoinChangeWitResCoin(denom,vidx,amt-denom[vidx],ans + denom[vidx]);
        PrintCoinChangeWitResCoin(denom,vidx+1,amt,ans);
    }

    private static void PrintCoinPermu(int[] arr, int amt, String ans) {
        if(amt == 0){

            count++;
            System.out.println(count + " "+ ans);
            return;
        }
        if(amt<0)
            return;

        for(int i = 0;i<arr.length;i++){
                PrintCoinPermu(arr,amt-arr[i],ans+arr[i]);
        }

    }

    private static void PrintCoinsCombi(int[] arr, int amt, String ans, int lastIndex) {

        if(amt == 0){
            System.out.println(ans);
            return;
        }
        for(int i = lastIndex;i<arr.length;i++){
            if(amt>=arr[i])
                PrintCoinsCombi(arr,amt-arr[i],ans+arr[i],i);
        }
    }
}
