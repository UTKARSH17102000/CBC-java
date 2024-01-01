package DynamicPrograming;

public class WildcardPatternMatching {
    public static void main(String[] args) {

        String src = "abcdef";
        String pat = "a?*************";
        System.out.println(WildCardMatchingRec(src,pat));
        System.out.println(WildcardPatternMatchingBU(src,pat));
        System.out.println(WildCardMatchingRec(src,pat,0,0));
        System.out.println(WildCardMatchingTD(src,pat,0,0,new int [src.length()][pat.length()]));
    }

    //For every char there are 3 options
    // 1 - both char matches then we simply call substrings
    // 2 - if pat contains ? on that char then simply replace that ? with src char and call for ros and rop
    // 3 - if there is * in pat then there are two options
    //     1 - we replace * with blank then src does not change but pattern become rop
    //     2 - we replace * with char then src changes to ros but pattern remains same

    // base case
    // if both length = 0 return true;
    // if src length != 0 but patter length ==0 return false
    // Special case src length == 0 but patter length != 0
    // then 1 if pattern contains all * then we return true bcoz * can be blank
    //  but if pat contains a char which is not * then we return false
    public static boolean WildCardMatchingRec(String src , String pat){

        if(src.length() == 0 && pat.length()== 0)
         return true;
        if(src.length() != 0 && pat.length() ==0)
             return  false;
        if(src.length() == 0 && pat.length() != 0){
            for(int i =0;i<pat.length();i++){
                if(pat.charAt(i) != '*'){
                    return false;
                }
            }

            return  true;
        }
        char chs = src.charAt(0);
        char chp = pat.charAt(0);

        String ros = src.substring(1);
        String rop = pat.substring(1);
        boolean ans ;
        if(chp == chs || chp == '?')
           ans = WildCardMatchingRec(ros,rop);
        else if(chp == '*'){
          boolean blank =  WildCardMatchingRec(src,rop);
          boolean multiple =   WildCardMatchingRec(ros,pat);

          ans = blank || multiple;
        }else{
          ans = false;
        }

        return ans;
    }

    public static boolean WildCardMatchingRec(String src , String pat,int svidx, int pvidx){

        if(src.length() == svidx && pat.length()== pvidx)
            return true;
        if(src.length() != svidx && pat.length() ==pvidx)
            return  false;
        if(src.length() == svidx && pat.length() != pvidx){
            for(int i =pvidx;i<pat.length();i++){
                if(pat.charAt(i) != '*'){
                    return false;
                }
            }

            return  true;
        }
        char chs = src.charAt(svidx);
        char chp = pat.charAt(pvidx);

        boolean ans ;
        if(chp == chs || chp == '?')
            ans = WildCardMatchingRec(src, pat, svidx+1, pvidx+1);
        else if(chp == '*'){
            boolean blank =  WildCardMatchingRec(src, pat, svidx, pvidx+1);
            boolean multiple =   WildCardMatchingRec(src, pat, svidx+1, pvidx);

            ans = blank || multiple;
        }else{
            ans = false;
        }

        return ans;
    }

    public static boolean WildCardMatchingTD(String src , String pat,int svidx, int pvidx, int [][] strg){

        if(src.length() == svidx && pat.length()== pvidx)
            return true;
        if(src.length() != svidx && pat.length() ==pvidx)
            return  false;
        if(src.length() == svidx && pat.length() != pvidx){
            for(int i =pvidx;i<pat.length();i++){
                if(pat.charAt(i) != '*'){
                    return false;
                }
            }

            return  true;
        }
        if(strg[svidx][pvidx] != 0)
             return strg[svidx][pvidx] == 1 ? false : true;

        char chs = src.charAt(svidx);
        char chp = pat.charAt(pvidx);

        boolean ans ;
        if(chp == chs || chp == '?')
            ans = WildCardMatchingTD(src, pat, svidx+1, pvidx+1,strg);
        else if(chp == '*'){
            boolean blank =  WildCardMatchingTD(src, pat, svidx, pvidx+1,strg);
            boolean multiple =   WildCardMatchingTD(src, pat, svidx+1, pvidx,strg);

            ans = blank || multiple;
        }else{
            ans = false;
        }
        // if ans == true store 2
        // if ans == false store 1
        // when 0 ans is not computed yet

        strg[svidx][pvidx] = (ans == true ? 2 :1);

        return ans;
    }


    // Each cell stores weather the src string present under that and pattern string on his right present matches or not
    // for each cell we need its bottom and right cell to be filled first
    // so we go right to left and bottom to up

    // T.C - (src.length * pat.length)
    public static boolean WildcardPatternMatchingBU(String src,String pat){

        boolean [][] strg = new boolean[src.length()+1][pat.length()+1];

        strg[src.length()][pat.length()] = true;

        for(int row = src.length();row>=0;row--){
            for(int col = pat.length()-1;col>=0;col--){
                if(row == src.length()){
                    if(pat.charAt(col) == '*')
                        strg[row][col] = strg[row][col+1];
                    else{
                        strg[row][col] =  false;
                    }
                    continue;
                }
                char chs = src.charAt(row);
                char chp = pat.charAt(col);

                boolean ans ;
                if(chp == chs || chp == '?')
                    ans = strg[row+1][col+1];
                else if(chp == '*'){
                    boolean blank = strg[row][col+1];
                    boolean multiple =  strg[row+1][col];

                    ans = blank || multiple;
                }else{
                    ans = false;
                }
                // if ans == true store 2
                // if ans == false store 1
                // when 0 ans is not computed yet

                strg[row][col] = ans;

            }
        }

        return strg[0][0];
    }

}
