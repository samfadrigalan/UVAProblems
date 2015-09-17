import java.util.Scanner;

/**
 * @author samanthafadrigalan
 * Problem Number: 10424
 * Problem Link: https://uva.onlinejudge.org/external/104/10424.pdf
 */
class LoveCalculator {
    public static Scanner in;
    public static String a, b;
    public static double ratio;
    
    public static void init () {
        in = new Scanner(System.in);
    }
    
    public static int getSum(String name) {
        name = name.toLowerCase();
        int sum = 0;
        for(int i=0; i<name.length(); i++) {
            int ascii = (int) name.charAt(i);
            if(97 <= ascii && ascii <= 122) {
                sum += (ascii - 96);
            }
        }
        return getFinSum(sum);
    }
    
    public static int getFinSum(int sum) {
        int finSum = sum % 10;
        sum /= 10;
        while(sum > 0) {
            finSum += sum % 10;
            sum /= 10;
        }
        if((finSum/10) > 0) {
            return getFinSum(finSum);
        }
        else {
            return finSum;
        }
    }
    
    public static void getRatio (int a, int b) {
        if(a==0 && b ==0) {
            ratio = -1;
        }
        else if(a > b) {
            ratio = (double) b / (double) a;
            ratio *= 100;
        }
        else {
            ratio = (double) a / (double) b;
            ratio *= 100;
        }
    }
    
    public static void output() {
        if(ratio >= 0) {
            System.out.printf("%.2f ", ratio);
            System.out.println("%");
        }
        else {
            System.out.println();
        }
    }
    
    public static void input() {
        a = in.nextLine().trim();
        b = in.nextLine().trim();
    }
    
    public static void process() {
        getRatio(getSum(a), getSum(b));
    }
    
    
    public static void main(String[] args) {
        init();
        while(in.hasNext()) {
            input();
            process();
            output();
        }
    }
    
}
