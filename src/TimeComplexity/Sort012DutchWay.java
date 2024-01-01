package TimeComplexity;

import java.util.Scanner;

public class Sort012DutchWay {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int arr [] = new int [7];

        for(int i =0;i<7;i++){
           arr[i] =  scn.nextInt();
        }

        int ans [] = DutchNationalFlag(arr);

        for(int i =0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }

    private static int[] DutchNationalFlag(int[] arr) {

        int high = arr.length-1;
        int low =0;
        int mid = 0;

        while (mid<=high){
            if(arr[mid] ==0){
                int swap = arr[mid];
                arr[mid] = arr[low];
                arr[low] = swap;
                mid++;
                low++;
            }else if(arr[mid] == 1)
                mid++;
            else{
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }

     return arr;
    }

}
