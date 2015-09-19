//package primecuts;
import java.util.Scanner;
/**
 * @author samanthafadrigalan
 * Date: 9/19/15
 * Problem Number: 406
 * Problem Link: https://uva.onlinejudge.org/external/4/406.pdf
 */
public class PrimeCuts {
    public static Scanner in;
    public static final int MAX_PRIMES = 200;
    public static final int MAX_NUM = 1000;
    public static int[] sieve;
    public static int[] primes;
    public static int N, C;
    public static int numPrimes;
    public static int iStart, iEnd;
    
    public static void init() {
        in = new Scanner(System.in);
        populatePrimes();
    }
    
    public static void populatePrimes () {
        sieve = new int[MAX_NUM + 1];
        primes = new int[MAX_PRIMES];
        primes[0] = 1;
        int iPrimes = 1;
        sieve[1] = 1;
        
        for(int i=2; i<=MAX_NUM; i++) {
            if(sieve[i] != -1) {
                primes[iPrimes++] = i;
                sieve[i] = iPrimes;
                for(int j=i+i; j<=MAX_NUM; j+=i) {
                    sieve[j] = -1;
                }
            }
            else {
                sieve[i] = iPrimes;
            }
        }
    }
    
    public static void input() {
        N = in.nextInt();
        C = in.nextInt();
        System.out.printf("%d %d:", N, C);
    }
    
    public static void process() {
        C *= 2;
        findNumPrimes();
        if(numPrimes % 2 != 0) {
            C--;
        }
        if(C < numPrimes) {
            iStart = (numPrimes - C) / 2;
            iEnd = iStart + C -1;
        }
        else {
            iStart = 0;
            iEnd = numPrimes - 1;
        }
    }
    
    public static void findNumPrimes() {
        numPrimes = sieve[N];
    }
    
    public static void output() {
        String output = "";
        for(int i=iStart; i<=iEnd; i++) {
            output += " " + primes[i] ;
        }
        System.out.println(output + "\n");
    }

    public static void main(String[] args) {
        init();
        while(in.hasNext()) {
            input();
            process();
            output();
        }
        in.close();
    }
    
}
