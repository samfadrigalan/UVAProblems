import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * @author samanthafadrigalan
 * Problem Number: 11559
 * Problem Link: https://uva.onlinejudge.org/external/115/11559.pdf
 */
class EventPlanning {
    public static Scanner Reader;
    
    public static void init() {
        Reader = new Scanner(System.in);
    }
    
    public static void solveCase(int numParticipants) throws IOException{
        int budget = Reader.nextInt();
        int numHotels = Reader.nextInt();
        int numWeeks = Reader.nextInt();
        
        int minCost = Integer.MAX_VALUE;
        
        for(int i=0; i<numHotels; i++) {
            int costPerPerson = Reader.nextInt();
            for(int j=0; j<numWeeks; j++) {
                if(Reader.nextInt() >= numParticipants) {
                    int cost = costPerPerson * numParticipants;
                    if(minCost > cost) {
                        minCost = cost;
                    }
                }
            }
        }
        
        if(minCost > budget) {
            System.out.println("stay home");
        }
        else {
            System.out.println(minCost);
        }
    }
    
    public static void main(String[] args) throws IOException{
        init();
        while(Reader.hasNext()) {
            int numParticipants = Reader.nextInt();
            solveCase(numParticipants);
        }
    }
    
}
