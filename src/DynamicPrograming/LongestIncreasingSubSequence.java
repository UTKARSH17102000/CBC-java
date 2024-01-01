package DynamicPrograming;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int arr[] = {10,9,2,5,3,7,101,18};
        System.out.println(LISBU(arr));
        System.out.println(Lis(arr));
    }

    //o(n^2)
    //we will take a strg array in which each cell stores the max LIS until that index
    // too check weather to include that no. we check if the no. is greater than previous we just update the strg value
    // with max of strg until that or strg of previous no. including this no.
    // Math.max(strg[i],strg[j]+1);
    // after that we will simply return the max valur of strg value
    private static int LISBU(int[] arr) {
        int strg [] = new int [arr.length];
        Arrays.fill(strg,1);
        int n = arr.length;
        for(int i =1;i<n;i++){
            for(int j =0;j<i;j++){
                if(arr[i]>arr[j])
                    strg[i] = Math.max(strg[i],strg[j]+1);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            if(max<strg[i])
                max = strg[i];
        }

        return max;
    }

    //T.C - nlogn
    public static  int Lis(int [] arr){
        int [] le = new int [arr.length];
        int len =1;
        le[0] = arr[0];

        for(int i =1;i< arr.length;i++){
            if(arr[i]>le[len-1]){
                le[len] = arr[i];
                len++;
            }else{
               int idx = binarySearch(le,0,len-1,arr[i]);
               le[idx] = arr[i];
            }

            System.out.println(arr[i]+":");
            for(int val:le){
                System.out.print(val +" ");
            }
            System.out.println();
        }

        return len;
    }

    public static int binarySearch(int [] le , int si , int ei , int item){
        int low = si;
        int high =ei;
        while (low<=high){
            int mid = (low+high)/2;
            if(item>le[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return low;
    }
}
