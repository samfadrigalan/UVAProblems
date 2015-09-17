import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * @author samanthafadrigalan
 * Problem Number: 11507
 * Problem Link: https://uva.onlinejudge.org/external/115/11507.pdf
 */
class Bender {
    public static String[] legend;
    public static String[][] map;
    
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
        legend = new String[] {"+z", "-z", "+y", "-y", "+x", "-x"};
        map = new String[][] {{"-x", "+x", "+z", "+z"},
                              {"+x", "-x", "-z", "-z"},
                              {"+y", "+y", "-x", "+x"},
                              {"-y", "-y", "+x", "-x"},
                              {"+z", "-z", "+y", "-y"},
                              {"-z", "+z", "-y", "+y"}};
    }
    
    public static void solveCase(int length) throws IOException{
        String current = "+x";
        for(int i=1; i<length; i++) {
            String dir = Reader.next();
            if(!dir.equals("No")) {
                int currentIndex = findIndex(current);
                int dirIndex = findIndex(dir);
                current = map[currentIndex][dirIndex];
            }
        }
        System.out.println(current);
    }
    
    public static int findIndex(String dir) {
        int i;
        for(i=0; i<legend.length; i++) {
            if(legend[i].equals(dir)) {
                break;
            }
        }
        return i;
    }
    
    public static void main(String[] args) throws IOException{
        init();
        int length = Reader.nextInt();
        while(length != 0) {
            solveCase(length);
            length = Reader.nextInt();
        }
    }
    
}
