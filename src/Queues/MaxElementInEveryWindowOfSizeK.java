package Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxElementInEveryWindowOfSizeK {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int [] arr = new int [n];
        
        for(int i =0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        
        int k = scn.nextInt();
        
        PrintMax(arr,k);
        
    }

    private static void PrintMax(int[] arr, int k) {
        Deque<Integer> q = new LinkedList<>();
        int i;
        for(i =0;i<k;i++){
            while(!q.isEmpty() && arr[i]>arr[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }

        for(;i< arr.length;i++){
            System.out.println(arr[q.getFirst()] + " ");
            while(!q.isEmpty() && q.getFirst() <= i-k){
                q.removeLast();
            }

            q.addLast(i);
        }
        System.out.println(arr[q.getFirst()]);
    }
}


//        7
//        12 1 78 90 57 89 56
//        3