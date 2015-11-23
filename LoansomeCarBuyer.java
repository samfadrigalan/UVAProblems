import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * @author samanthafadrigalan
 * Date: 9/20/15
 * Problem Number: 10114
 * Problem Link: https://uva.onlinejudge.org/external/101/10114.pdf
 */
public class LoansomeCarBuyer {
    public static double down, loan;
    public static int duration, numDepreciations, months;
            
    public static void init() {
        Reader.init(System.in);
    }
    
    public static boolean input() throws IOException{
        boolean flag = false;
        duration = Reader.nextInt();
        if(duration >= 0) {
            flag = true;
            down = Reader.nextDouble();
            loan = Reader.nextDouble();
            numDepreciations = Reader.nextInt();
        }
        return flag;
    }
    
    public static void process() throws IOException{
        double monthly = loan / duration;
        months = Reader.nextInt();
        numDepreciations--;
        int nextMonth = 0;
        double rate = Reader.nextDouble();
        double nextRate = rate;
        double carValue = loan + down - ((loan + down) * rate);
        double debt = loan;
        
        while(debt >= carValue) {
            months++;
            debt -= monthly;
            if(numDepreciations > 0 && months > nextMonth) {
                nextMonth = Reader.nextInt();
                nextRate = Reader.nextDouble();
                numDepreciations--;
            }
            if(nextMonth == months) {
                rate = nextRate;
            }
            
            carValue -= (carValue * rate);
        }
        
        while(numDepreciations > 0) {
            Reader.next();
            Reader.next();
            numDepreciations--;
        }
    }
    
    public static void output() {
        if(months == 1) {
            System.out.printf("1 month\n");
        }
        else {
            System.out.printf("%d months\n", months);
        }
    }
    
    public static class Reader{
        static BufferedReader reader;
        static String[] lines;
        static int count;
        
        static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            lines = new String[0];
            count = -1;
        }
        
        static String next() throws IOException {
            while(lines.length == 0 || count >= lines.length) {
                String temp = reader.readLine();
                if(temp != null) {
                    lines = temp.trim().split("\\s+");
                    count = 0;
                }
            }
            return lines[count++];
        }
        
        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        
        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
    
    public static void main(String[] args) throws IOException{
        init();
        boolean flag = input();
        while(flag) {
            process();
            output();
            flag = input();
        }
    }
}
