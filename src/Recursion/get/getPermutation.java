package Recursion.get;
import java.util.ArrayList;
import java.util.Scanner;

public class getPermutation {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String str = scn.next();
        System.out.println(getPermutationSeq(str));
    }

    private static ArrayList<String> getPermutationSeq(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char c = str.charAt(0);
        String res = str.substring(1);
        ArrayList<String> rr = getPermutationSeq(res);
        ArrayList<String> mr = new ArrayList<>();

        for(String rrs : rr){
            for(int i =0 ;i<=rrs.length();i++){
                String val = rrs.substring(0,i) + c + rrs.substring(i);
                mr.add(val);
            }
        }
        return mr;
    }
}



// to insert char in a string we can
// insert at i position = str.substring(0,i) + c + str.substring(i);
// remove at i position = str.substring(0,i) + str.substring(i+1);
// replace k at i position = str.substring(0,i) + k +  str.substring(i+1);


// number of  Permutations  of a string = n! where n is the length of a string ex abc  = [abc, bac, bca, acb, cab, cba]
// we think that recursion do his work so bigger problem is to find for abc whereas smaller problem is to find for bc and then add a to it in same way smaller problem for bc is to find for c and then add b on one posi prior to c to make bc and add one after c to make cb and rest of the job recursion .
//we do that we add the char at every position of string present in arraylist rr and the add the value to the result mr then return that .
