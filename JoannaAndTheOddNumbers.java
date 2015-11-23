import java.util.Scanner;
import java.math.BigInteger;
/**
 * @author samanthafadrigalan
 * Date: 11/22/15
 * Problem Number: 913
 * Problem Link: https://uva.onlinejudge.org/external/9/913.pdf
 */
public class JoannaAndTheOddNumbers {
    static Scanner in;
    static BigInteger num;

    static void init() {
        in = new Scanner(System.in);
        num = BigInteger.ONE;
    }

    static boolean input() {
        if(!in.hasNext()) {
            return false;
        }
        else {
            num = new BigInteger(in.nextLine().trim());
            return true;
        }
    }

    static void process() {
        if(num != BigInteger.ONE) {
//            num = num * ((num+1)/2) + ((num+1)/2) - 1;
//            num = (num * 3) - 6;
            BigInteger temp = num.add(BigInteger.ONE);
            temp = temp.divide(new BigInteger("2"));
            num = num.multiply(temp);
            num = num.add(temp);
            num = num.subtract(BigInteger.ONE);
            num = num.multiply(new BigInteger("3"));
            num = num.subtract(new BigInteger("6"));
        }
    }

    static void output() {
        System.out.println(num);
    }



    public static void main(String[] args) {
        init();
        while(input()) {
            process();
            output();
        }
    }

}
