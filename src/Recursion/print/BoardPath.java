package Recursion.print;

import java.util.Collections;

public class BoardPath {
    public static void main(String[] args) {

        System.out.println(CountBoardPath(0,10));
        PrintBoardPath(0,10,"");
    }

    private static void PrintBoardPath(int curr, int end, String result) {

        if(curr == end){
            System.out.print(result +"  ");
            return;
        }

        if(curr > end)
            return;

        for(int i=1;i<=6;i++){
            PrintBoardPath(curr+i,end,result+i);
        }
    }

    private static int CountBoardPath(int curr, int end) {

        if(curr == end)
            return 1;

        if(curr > end)
            return 0;

        int count =0;

        for(int i =1;i<=6;i++){
            count = count + CountBoardPath(curr+i,end);
        }

        return count;
    }
}
