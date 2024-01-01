package Backtracking;

public class QueenPermCombi {

    static int count;
    static int countC;
    static int countq2;
    static int countq21;
    static int Kcountq21;

    public static void main(String[] args) {


        QueenPerm(new boolean[4],0,2,"");

        System.out.println("*******************");

        QueenCombi(new boolean[4],0,2,"",-1);


        System.out.println("*******************");

        QueenCombiBoxRespect(new boolean[4], 0,0,2,"");

        System.out.println("*******************");
        QueenCombiBoxRespect2D(new boolean[2][2], 0,0,0,2,"");

        System.out.println("*******************");
        QueenCombiBoxRespect2DKill(new boolean[3][4], 0,0,0,3,"");

        System.out.println("*******************");
        Queen2Combi(new boolean[4][4], 0,0,4,"");
        System.out.println("*******************");
        Queen2CombiKill(new boolean[4][4], 0,0,4,"");
        System.out.println("*******************");
        KQueen2CombiKill(new boolean[4][4], 0,0,3,"");
    }

    private static void KQueen2CombiKill(boolean[][] board, int row, int qpsf, int tq, String ans) {
        if(qpsf == tq ){
            Kcountq21++;
            System.out.println(Kcountq21 + "" + ans);
            return;
        }

        if(row == board.length)
            return;


        for(int col =0;col<board[0].length;col++){

            if (isItSafeToPlaceQueen(board,row,col)){
                board[row][col] = true;
                KQueen2CombiKill(board, row+1, qpsf+1, tq, ans + "{"+ row +" " + col+"}");
                board[row][col] = false;
            }
        }
        KQueen2CombiKill(board, row+1, qpsf, tq, ans);

    }

    private static void Queen2CombiKill(boolean[][] board, int row, int qpsf, int tq, String ans) {
        if(qpsf == tq ){
            countq21++;
            System.out.println(countq21 + "" + ans);
            return;
        }

        if(row == board.length)
            return;


        for(int col =0;col<board[0].length;col++){

            if (isItSafeToPlaceQueen(board,row,col)){
                board[row][col] = true;
                Queen2CombiKill(board, row+1, qpsf+1, tq, ans + "{"+ row +" " + col+"}");
                board[row][col] = false;
            }

        }
    }

    private static void Queen2Combi(boolean[][] board, int row, int qpsf, int tq, String ans) {

        if(qpsf == tq ){

            countq2++;
            System.out.println(countq2 + "" + ans);
            return;
        }

        if(row == board.length)
            return;


        for(int col =0;col<board[0].length;col++){
            board[row][col] = true;
            Queen2Combi(board, row+1, qpsf+1, tq, ans + "{"+ row +" " + col+"}");
            board[row][col] = false;
        }

    }


    private static void QueenCombiBoxRespect2DKill(boolean[][] board, int row, int col , int qpsf, int tq, String ans) {

        // positive base case
        if(qpsf == tq){
            System.out.println(ans);
            return;
        }
        // negetive
        if(col == board[0].length){
            row++;
            col=0;
        }
        if(row == board.length)
            return;
        // place only if place is safe
        if(isItSafeToPlaceQueen(board,row,col)){
            //place queens
            board[row][col] = true;
            QueenCombiBoxRespect2DKill(board,row ,col+1,qpsf+1,tq,ans+" {" +  + row + "," + col+ "} ");
            //undo
            board[row][col] = false;
        }
        //not place
        QueenCombiBoxRespect2DKill(board,row,col+1,qpsf,tq,ans);

    }

    private static boolean isItSafeToPlaceQueen(boolean[][] board, int row, int col) {


        int r =row-1;
        int c = col;

        while(r>=0){
            if(board[r][c])
               return false;
            r--;
        }


         r =row;
         c = col-1;

        while(c>=0){
            if(board[r][c])
                return false;
            c--;
        }
        r =row-1;
        c = col-1;

        while(c>=0  && r>=0){
            if(board[r][c])
                return false;
            c--;
            r--;
        }
        r =row-1;
        c = col+1;

        while(r>=0  && c<board[0].length){
            if(board[r][c])
                return false;
            c++;
            r--;
        }

        return true;
    }


    private static void QueenCombiBoxRespect2D(boolean[][] board, int row, int col , int qpsf, int tq, String ans) {
        // positive base case
        if(qpsf == tq){
            System.out.println(ans);
            return;
        }
        // negetive
        if(col == board[0].length){
            row++;
            col=0;
        }
        if(row == board.length)
            return;

        //place queens
        board[row][col] = true;
        QueenCombiBoxRespect2D(board,row ,col+1,qpsf+1,tq,ans+" {" +  + row + "," + col+ "} ");
        //undo
        board[row][col] = false;
        //not place
        QueenCombiBoxRespect2D(board,row,col+1,qpsf,tq,ans);

    }

    private static void QueenCombiBoxRespect(boolean[] board, int col , int qpsf, int tq, String ans) {
// positive base case
     if(qpsf == tq){
         System.out.println(ans);
         return;
     }
// negetive
        if(col == board.length)
            return;

        //place queens
        board[col] = true;
        QueenCombiBoxRespect(board,col+1,qpsf+1,tq,ans+" " + "b" +col);
        //undo
        board[col] = false;
        //not place
        QueenCombiBoxRespect(board,col+1,qpsf,tq,ans);

    }

    private static void QueenCombi(boolean[] boxes, int qpsf, int tq, String ans,int lastindex) {
        if(qpsf== tq){
            count++;
            System.out.println(count+" "+ ans);
            return;
        }

        for(int i =lastindex+1;i<boxes.length;i++){

                boxes[i] = true;
                QueenCombi(boxes,qpsf+1,tq,ans + "q"+qpsf+"b"+i+" ",i);
                boxes[i] = false;

        }

    }

    private static void QueenPerm(boolean[] boxes, int qpsf, int tq, String ans) {

        if(qpsf== tq){
            countC++;
            System.out.println(countC+" "+ ans);
            return;
        }

        for(int i =0;i<boxes.length;i++){
          //  System.out.println(i);
            if(boxes[i] == false){
                boxes[i] = true;
                QueenPerm(boxes,qpsf+1,tq,ans + "q"+qpsf+"b"+i+" ");
                boxes[i] = false;
            }
        }
    }
}
