import java.util.*;
/**
 * @author samanthafadrigalan
 * Problem Number: 11799
 * Problem Link: https://uva.onlinejudge.org/external/117/11799.pdf
 */

class HorrorDash {
    public static Scanner in;
    
    public static void init() {
        in = new Scanner(System.in);
    }
    
    public static void solve() {
        int numCases = Integer.parseInt(in.nextLine());
        for(int i=1; i<=numCases; i++){
            if(in.hasNext()) {
                String nums = in.nextLine();
                solveCase(nums, i);
            }
        }
    }
    
    public static void solveCase(String numsStr, int caseNum) {
        String[] nums = numsStr.trim().split("\\s+");
        int max = Integer.parseInt(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(max < Integer.parseInt(nums[i])){
                max = Integer.parseInt(nums[i]);
            }
        }
        output(caseNum, max);
    }
    
    public static void output(int caseNum, int ans) {
        System.out.printf("Case %d: %d\n", caseNum, ans);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        init();
        solve();
    }
    
}
