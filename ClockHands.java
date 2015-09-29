import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author samanthafadrigalan
 * Date: 9/29/15
 * Problem Number: 579
 * Problem Link: https://uva.onlinejudge.org/external/5/579.pdf
 */
public class ClockHands {
    public static double hourHand, minHand;
    public static double angle;
    public static String TERMINATOR = "0:00";
    
    
    public static void init() {
        Reader.init(System.in);
    }
    
    public static boolean input() throws IOException{
        boolean flag = true;
        String line = Reader.next();
        if(line.equals(TERMINATOR)){
            flag = false;
        }
        else {
            String[] inputArr = line.split(":");
            hourHand = Integer.parseInt(inputArr[0]);
            minHand = Integer.parseInt(inputArr[1]);
        }
        return flag;
    }
    
    public static void hourToAngle(){
        hourHand *= 30;
        hourHand += ((minHand/60) * 30);
    }
    
    public static void minToAngle(){
        minHand *= 6;
    }
    
    public static void process(){
        hourToAngle();
        minToAngle();
        
        if(hourHand == minHand) {
            angle = 0;
        }
        else {
            if(minHand > hourHand) {
                double temp = hourHand;
                hourHand = minHand;
                minHand = temp;
            }
            
            angle = hourHand - minHand;
            if(angle > 180) {
                angle = 360 - angle;
            }
        }
    }
    
    public static void output() {
        System.out.printf("%.3f\n", angle);
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
        while(input()){
            process();
            output();
        }
    }
    
}
