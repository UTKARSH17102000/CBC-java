package Recursion.get;

import java.util.ArrayList;
import java.util.Scanner;

public class getMazePath {


    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        System.out.println(MazePath(0,0,n,n));
        System.out.println(MazePathD(0,0,n,n));
    }

    private static ArrayList<String> MazePathD(int ch, int cv, int eh, int ev) {
        if(ch == eh && cv == ev){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        if(ch > eh || cv >ev){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }

        ArrayList<String> mr = new ArrayList<>();

        ArrayList<String> rrh = MazePathD(ch+1,cv,eh,ev);
        for(String rrhs:rrh){
            mr.add("H" + rrhs);
        }
        ArrayList<String> rrv = MazePathD(ch,cv+1,eh,ev);
        for(String rrvs:rrv){
            mr.add("V" + rrvs);
        }

        ArrayList<String> rrd = MazePathD(ch+1,cv+1,eh,ev);
        for(String rrds:rrd){
            mr.add("D" + rrds);
        }
        return mr;
    }

    private static ArrayList<String> MazePath(int ch, int cv, int eh, int ev) {

        if(ch == eh && cv == ev){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        if(ch>eh || cv>ev){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }

        ArrayList<String> mr = new ArrayList<>();

        ArrayList<String> rrh = MazePath(ch+1,cv,eh,ev);
        for(String rrhs:rrh){
            mr.add("H" + rrhs);
        }
        ArrayList<String> rrv = MazePath(ch,cv+1,eh,ev);
        for(String rrvs:rrv){
            mr.add("V" + rrvs);
        }

        return mr;
    }
}
