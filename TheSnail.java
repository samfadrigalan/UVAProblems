import java.util.Scanner;

/**
 * @author samanthafadrigalan
 * Problem Number: 573
 * Problem Link: https://uva.onlinejudge.org/external/5/573.pdf
 */
class TheSnail {
    public static Scanner in;
    
    public static void init() {
        in = new Scanner(System.in);
    }
    
    public static void solveCase (double height, double climb, double slide, double fatigue) {
        boolean done = false;
        double distLost = Math.round(climb * fatigue)/100.0;
        double position = 0.00;
        int day = 1;
        position += climb;
        if(succeeded(position, height)) {
            done = true;
        }
        else {
            position -= slide;
            if(!done && failed(position)) {
                done = true;
            }
        }
         
        while(!done) {
            day++;
            climb = Math.round((climb - distLost) * 100.0) / 100.0;
            if(climb >= 0) {
                position = Math.round((position + climb) * 100.0) / 100.0;
            }
            
            if(succeeded(position, height)) {
                done = true;
            }
            else {
                position = Math.round((position-slide) * 100.0) / 100.0;
                if(!done && failed(position)) {
                    done = true;
                }
            }
        }
        
        if(succeeded(position, height)) {
            output(true, day);
        }
        else {
            output(false, day);
        }
        
    }
    
    public static boolean failed (double position) {
        return position < 0;
    }
    
    public static boolean succeeded (double position, double height) {
        return position > height;
    }
    
    public static void output (boolean success, int day) {
        if(success) {
            System.out.printf("success on day %d\n", day);
        }
        else {
            System.out.printf("failure on day %d\n", day);
        }
    }
    
    public static void input() {
        String H = in.next();
        while(!"0".equals(H)) {
            String[] nums = in.nextLine().trim().split("\\s+");
            solveCase(Double.parseDouble(H), Double.parseDouble(nums[0]), Double.parseDouble(nums[1]), Double.parseDouble(nums[2]));
            H = in.next();
        }
    }
    
    public static void main(String[] args) {
        init();
        input();
    } 
}
