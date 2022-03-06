import java.util.HashMap;
import java.util.Scanner;
import edu.princeton.cs.algs4.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        // Keeps track of each parties' number of seats
        HashMap seatAllocations = new HashMap<Integer, Integer>();
        MaxPQ parties = new MaxPQ<Party>(n);

        // Add the parties to the parties priority queue and to the seat allocation map
        for (int i = 1; i <= n; i++) {
            int id = i;
            int votes = s.nextInt();
            Party party = new Party(id, votes);
            seatAllocations.put(id, 0);
            parties.insert(party);
        }
        s.close();

        // Allocate parliament seats (m) until all are allocated,
        while (m > 0) {
            Party currentParty = (Party) parties.max();
            currentParty.incrementSeats();
            currentParty.setQuotient();

            int id = currentParty.getId();
            int seats = currentParty.getSeats();
            seatAllocations.put(id, seats);

            parties.delMax();
            parties.insert(currentParty);
            m--;
        }

        // Loops over and prints the values of the seat allocation map
        for (Object object : seatAllocations.values()) {
            System.out.println(object);
        }
    }
}
