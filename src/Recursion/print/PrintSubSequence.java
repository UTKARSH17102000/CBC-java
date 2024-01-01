package Recursion.print;

public class PrintSubSequence {

    public static void main(String[] args) {

        String str = "abcd";
        SubSequence(str,"");
       System.out.println(CountSubSequence(str));
    }

    private static int CountSubSequence(String str) {
        if(str.length() == 0){ ;
            return 1;
        }

        char c = str.charAt(0);
        String res = str.substring(1);

       int l =  CountSubSequence(res);
       int r =  CountSubSequence(res);
       return  l+r;
    }

    private static void SubSequence(String str, String ans) {

        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        char c = str.charAt(0);
        String res = str.substring(1);

        SubSequence(res,ans);
        SubSequence(res,ans+c);
    }
}
