package DynamicPrograming;

public class LCS {


    public static void main(String[] args) {

        String s ="abccga";
        System.out.println(LCSrec(s,0,s.length()-1));
        System.out.println(LCSBU(s));
        System.out.println(LCSTD(s,0,s.length()-1,new int [s.length()][s.length()]));
    }

    // First we check if first and last char are same then we remove both  char and call for smaller string
    // if they did not match then we make two calls one by removing 1 char and then by removing second char

    public  static  int LCSrec(String s , int si , int ei){
        if(si>ei)
            return 0;
        if(si == ei)
             return 1;
        int ans =0;
        if(s.charAt(si) == s.charAt(ei))
            ans = LCSrec(s,si+1,ei-1)+2;
        else{
            int o1 = LCSrec(s,si+1,ei);
            int o2 = LCSrec(s,si,ei-1);
            ans = Math.max(o1,o2);
        }
        return ans;
    }

    public  static  int LCSTD(String s , int si , int ei, int [][] strg){
        if(si>ei)
            return 0;
        if(si == ei)
            return 1;
        if(strg[si][ei]!=0)
             return  strg[si][ei];
        int ans =0;

        if(s.charAt(si) == s.charAt(ei))
            ans = LCSTD(s,si+1,ei-1,strg)+2;
        else{
            int o1 = LCSTD(s,si+1,ei,strg);
            int o2 = LCSTD(s,si,ei-1,strg);
            ans = Math.max(o1,o2);
        }
        strg[si][ei] =ans;
        return ans;
    }

    public  static int LCSBU(String s){
        int [][] strg = new int [s.length()][s.length()];

        int n=s.length();
        for(int slide =0;slide<=n-1;slide++){
            for(int si =0;si<= n-slide-1;si++){
                int ei = si+slide;

                if(si == ei) {
                    strg[si][ei] = 1;
                }else{
                    int ans =0;

                    if(s.charAt(si) == s.charAt(ei))
                        ans = strg[si+1][ei-1]+2;
                    else{
                        int o1 =strg[si+1][ei];
                        int o2 = strg[si][ei-1];
                        ans = Math.max(o1,o2);
                    }
                    strg[si][ei] =ans;
                }

            }
        }

        return strg[0][n-1];
    }
}
