package Recursion;

public class RecursionBasics {

    public static void main(String[] args) {


        // PrintWhileStackBuilding(5);
        // PrintWhileStackPopOut(5);
        // PrintBothTogether(5);
        // PrintSkip(5);
//         System.out.println( PrintPower(2,5));
//         System.out.println( PrintFactorial(5));
//         System.out.println( PrintNthFibonacci(13));
        int[] arr = {3, 8, 5, 8, 4, 10, 8, 7};
//         int [] arr1 = {1,2,3,4};
//         System.out.println(IsSorttedArray(arr1,0));
//           PrintPattern(5,0,0);
        System.out.println(PrintFirstIndex(arr, 5, 0));
        System.out.println(PrintLastIndex(arr, 8, 0));
        BubbleSortRecursion(arr, 0, arr.length - 1);
        PrintArray(arr, 0);
        System.out.println();
        System.out.println(PrintMax(arr, 0));
        System.out.println(PrintMin(arr, 0));
        int [] ans = allIndices(arr,0,8,0);
        PrintArray(ans,0);
        int [] arr1 = {3,4,5,7,8,8,8,10};
        System.out.println(BinarySearch(arr1,4,0,arr.length-1));


    }

    private static int BinarySearch(int[] arr, int k, int start, int end) {


        if(start >= end)
            return -1;

        int mid = (start+end)/2;
        if(arr[mid] == k)
            return mid;
        if(arr[mid]>k)
            return BinarySearch(arr,k,start,mid-1);

            return BinarySearch(arr,k,mid+1,end);

    }

    private static int[] allIndices(int[] arr, int start, int data, int count) {
        if(start == arr.length){
            int [] base = new int [count];
            return base;
         }
        int [] indices = null;
        if(arr[start] == data)
            indices = allIndices(arr,start+1,data,count+1);
        else
            indices = allIndices(arr,start+1,data,count);

        if(arr[start] == data){
            indices[count] = start;
        }
        return indices;
    }

    private static int PrintMin(int[] arr, int i) {
        if (i == arr.length)
            return Integer.MAX_VALUE;

        int ans = PrintMin(arr, i + 1);
        if (arr[i] < ans) {
            ans = arr[i];
        }
        return ans;
    }

    private static int PrintMax(int[] arr, int start) {
        if (start == arr.length)
            return Integer.MIN_VALUE;

        int MaxNum = PrintMax(arr, start + 1);

        if (arr[start] > MaxNum) {
            MaxNum = arr[start];
        }

        return MaxNum;
    }

    private static int PrintLastIndex(int[] arr, int data, int start) {

        if (start == arr.length - 1)
            return -1;

        int index = PrintLastIndex(arr, data, start + 1);


        if (arr[start] == data && index == -1)
            return start;
        else
            return index;
    }

    private static void PrintArray(int[] arr, int i) {
        if (i == arr.length)
            return;

        System.out.print(arr[i] + "\t");
        PrintArray(arr, i + 1);
    }

    private static void BubbleSortRecursion(int[] arr, int start, int end) {
        if (end == 0)
            return;
        if (start == end) {
            BubbleSortRecursion(arr, 0, end - 1);
        } else {
            if (arr[start] > arr[start + 1]) {
                int temp = arr[start];
                arr[start] = arr[start + 1];
                arr[start + 1] = temp;
            }
            BubbleSortRecursion(arr, start + 1, end);
        }
    }

    private static int PrintFirstIndex(int[] arr, int data, int start) {

        if (start == arr.length - 1)
            return -1;
        if (arr[start] == data)
            return start;
        else {
            int ans = PrintFirstIndex(arr, data, start + 1);
            return ans;
        }
    }

    private static void PrintPattern(int i, int row, int col) {
        if (row == i)
            return;

        if (col > row) {
            System.out.println();
            PrintPattern(i, row + 1, 0);
        } else {
            System.out.print("*");
            PrintPattern(i, row, col + 1);
        }
    }

    private static boolean IsSorttedArray(int[] arr, int si) {
        if (si == arr.length - 1)
            return true;

        if (arr[si] > arr[si + 1])
            return false;
        else {
            boolean ans = IsSorttedArray(arr, si + 1);
            return ans;
        }
    }

    private static int PrintNthFibonacci(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;

        int Fn1 = PrintNthFibonacci(i - 1);
        int Fn2 = PrintNthFibonacci(i - 2);

        int Term = Fn1 + Fn2;

        return Term;
    }

    private static int PrintPower(int data, int i) {

        if (i == 0)
            return 1;
        int pnm1 = PrintPower(data, i - 1);
        int p = data * pnm1;
        return p;
    }

    private static int PrintFactorial(int i) {
        if (i == 0)
            return 1;

        int fnm1 = PrintFactorial(i - 1);
        int fn = i * fnm1;

        return fn;
    }

    private static void PrintSkip(int i) {
        if (i == 0)
            return;

        if (i % 2 == 1)
            System.out.println(i);
        PrintSkip(i - 1);
        if (i % 2 == 0)
            System.out.println(i);

    }

    private static void PrintBothTogether(int i) {
        if (i == 0)
            return;

        System.out.println(i);
        PrintBothTogether(i - 1);
        System.out.println(i);
    }

    private static void PrintWhileStackPopOut(int i) {

        if (i == 0)
            return;

        PrintWhileStackPopOut(i - 1);
        System.out.println(i);
    }

    private static void PrintWhileStackBuilding(int i) {

        if (i == 0)
            return;

        System.out.println(i);
        PrintWhileStackBuilding(i - 1);
    }
}



//public class Main
//{
//    public static void main(String[] args) {
//
//        System.out.println(Rec(2,5));
//    }
//
//    public static int Rec(int x,int p){
//        if(p == 1)
//            return x;
//
//        int ans = Rec(x,p/2);
//
//        if(p%2 == 0)
//            ans = ans*ans;
//        else
//            ans = ans*ans*x;
//
//        return ans;
//
//    }
//}