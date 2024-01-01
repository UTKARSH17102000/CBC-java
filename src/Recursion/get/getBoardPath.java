package Recursion.get;

import java.util.ArrayList;


public class getBoardPath {

    public static void main(String[] args) {


        System.out.println(getBoradPathResults(0,6));
        System.out.println(getBoradPathResults(0,6).size());
    }

    private static ArrayList<String> getBoradPathResults(int curr, int data) {

        if(curr == data){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        if(curr > data){
            ArrayList<String> NegetiveBase = new ArrayList<>();
            return NegetiveBase;
        }


        ArrayList<String> mr = new ArrayList<>();

        for(int dice=1;dice<=6;dice++){

            ArrayList<String> rr = getBoradPathResults(curr+dice,data);

            for(String rrs : rr){
                mr.add(dice + rrs);
            }

        }
        return mr;
    }
}
