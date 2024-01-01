package TimeComplexity;


import java.util.Arrays;
import java.util.Scanner;

public class BestPrimeSOE {

    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        way1Prime(n);

        System.out.println("************************************************");

        way2Prime(n);
        System.out.println("************************************************");
        way3Prime(n);
        System.out.println("************************************************");

        SOE(n);
    }

    private static void way3Prime(int n) {


        for(int i =2;i<=n;i++){

            int count =0;
            for(int j =1;j*j<=i;j++){
                if(i%j == 0)
                    count++;
            }

            count++;

            if(count == 2)
                System.out.println(i);
        }
    }

    private static void way2Prime(int n) {

        for(int i =2;i<=n;i++){

            int count =0;
            for(int j =1;j<=i/2;j++){
                if(i%j == 0)
                    count++;
            }

            count++;

            if(count == 2)
                System.out.println(i);
        }
    }

    private static void way1Prime(int n) {

        for(int i =2;i<=n;i++){

            int count =0;
            for(int j =1;j<=n;j++){
                if(i%j == 0)
                    count++;
            }

            if(count == 2)
                System.out.println(i);
        }
    }

    private static void SOE(int n) {

        boolean [] primes = new boolean[n+1];

        Arrays.fill(primes,true);

        primes[0] = primes[1] = false;
        for(int table =2;table*table <= n;table++){
            if(primes[table] == false)
                continue;

            for(int mul =2 ; table*mul<=n;mul++){
                primes[table*mul] = false;
            }
        }

        for(int i =1;i< primes.length;i++){
            if(primes[i])
                System.out.println(i);
        }

    }
}
