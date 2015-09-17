import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * @author samanthafadrigalan
 * Problem Number: 11498
 * Problem Link: https://uva.onlinejudge.org/external/114/11498.pdf
 */
public class DivisionOfNlognia {
    
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
    }
    
    public static void init() {
        Reader.init(System.in);
    }
    
    public static void solveCase(int numCases) throws IOException{
        int oX = Reader.nextInt();
        int oY = Reader.nextInt();
        
        for(int i=0; i<numCases; i++){
            int x = Reader.nextInt();
            int y = Reader.nextInt();
            
            if(x == oX || y == oY) {
                System.out.println("divisa");
            }
            else {
                int diffX = x - oX;
                int diffY = y - oY;
                
                if(diffY > 0) {
                    if (diffX > 0) {
                        System.out.println("NE");
                    }
                    else {
                        System.out.println("NO");
                    }
                }
                else {
                    if (diffX > 0) {
                        System.out.println("SE");
                    }
                    else {
                        System.out.println("SO");
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        init();
        int numQueries = Reader.nextInt();
        while(numQueries > 0) {
            solveCase(numQueries);
            numQueries = Reader.nextInt();
        }
    }
    
}
