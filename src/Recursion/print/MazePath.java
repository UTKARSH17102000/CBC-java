package Recursion.print;

public class MazePath {
    public static void main(String[] args) {

     System.out.println(countMazePath(0,0,2,2));
     System.out.println(countMazePathD(0,0,2,2));
     PrintMazePath(0,0,2,2,"");
     System.out.println();
     PrintMazePathD(0,0,2,2,"");
    }

    private static void PrintMazePathD(int sh, int sv, int eh, int ev, String s) {

        if(sh == eh && sv == ev){
            System.out.print(s+"   ");
            return;
        }


        if(sh > eh ||  sv>ev)
            return;

        PrintMazePathD(sh+1,sv,eh,ev,s+"H");
        PrintMazePathD(sh,sv+1,eh,ev, s+"V");
        PrintMazePathD(sh+1,sv+1,eh,ev, s+"D");
    }

    private static void PrintMazePath(int sh, int sv, int eh, int ev, String s) {

        if(sh == eh && sv == ev){
            System.out.print(s+"    ");
            return;
        }


        if(sh > eh ||  sv>ev)
           return;

         PrintMazePath(sh+1,sv,eh,ev,s+"H");
         PrintMazePath(sh,sv+1,eh,ev, s+"V");

    }

    private static int countMazePathD(int sh, int sv, int eh, int ev) {

        if(sh == eh && sv == ev)
            return 1;
        if(sh > eh ||  sv>ev)
            return 0;

        int ch = countMazePathD(sh+1,sv,eh,ev);
        int cv = countMazePathD(sh,sv+1,eh,ev);
        int cd = countMazePathD(sh+1,sv+1,eh,ev);
        return ch + cv + cd;
    }

    private static int countMazePath(int sh, int sv, int eh, int ev) {

        if(sh == eh && sv == ev)
            return 1;

        if(sh > eh ||  sv>ev)
            return 0;

        int ch = countMazePath(sh+1,sv,eh,ev);
        int cv = countMazePath(sh,sv+1,eh,ev);
        
        return ch + cv;

    }
}
