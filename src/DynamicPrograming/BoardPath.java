package DynamicPrograming;

public class BoardPath {
    public static void main(String[] args) {
         int n =10;
        System.out.println(BPRec(0,n));
        System.out.println(BPRecTD(0,n,new int [n]));
        System.out.println(BPBU(n));
        System.out.println(BPBUSE(n));
    }

    //T.C -O(6^n)
    public static int BPRec(int curr , int end){

        if(curr == end)
             return 1;
        if(curr > end)
             return 0;
        int cnt =0;
        for(int dice =1;dice<=6;dice++){
            cnt += BPRec(curr+dice,end);
        }

        return cnt;
    }

    //T.C - O(N)
    //S.C - O(n) + rec Space
    public static int BPRecTD(int curr , int end,int [] strg){

        if(curr == end)
            return 1;
        if(curr > end)
            return 0;
        if(strg[curr] != 0)
             return strg[curr];
        int cnt =0;
        for(int dice =1;dice<=6;dice++){
            cnt += BPRecTD(curr+dice,end,strg);
        }
        strg[curr] = cnt;

        return cnt;
    }
    //T.C - O(N)
    //S.C - O(N)
    public static  int BPBU(int end){
        int strg[] = new int [end+6];

        strg[end] =1;
        for(int i = end-1;i>=0;i--){
            int cnt=0;
            for(int dice =1;dice<=6;dice++){
                cnt +=strg[i+dice];
            }
            strg[i] = cnt;
        }

        return strg[0];
    }
    //As we know to get the cnt of any no. we require the value of next 6 values so instead of using array we use 6 variables and continuously updates their values
    //T.C-O(N)
    //S.C-O(1) //size of array will be 6
    public static int BPBUSE(int end ){
        int [] strg = new int [6];

        strg[0] =1;
        for(int slide =1;slide<=end;slide++){
            int sum =0;
            for(int i =0;i<6;i++)
                 sum += strg[i];
            for(int i = 5;i>=1;i--)
                strg[i] = strg[i-1];

            strg[0] = sum;

        }

        return strg[0];
    }
}
