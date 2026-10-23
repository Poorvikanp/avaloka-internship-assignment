import java.util.Arrays;
import java.util.PriorityQueue;

public class EventScheduler {

    
    public static boolean canAttendAll(int[][] events) {

        if (events == null || events.length <= 1) {
            return true;
        }

        
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

      
        for (int i = 1; i < events.length; i++) {

            int previousEnd = events[i - 1][1];
            int currentStart = events[i][0];

           
            if (previousEnd > currentStart) {
                return false;
            }
        }

        return true;
    }


   
    public static int minRoomsRequired(int[][] events) {

        if (events == null || events.length == 0) {
            return 0;
        }

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for (int[] event : events) {

            int start = event[0];
            int end = event[1];

            if (!endTimes.isEmpty() && endTimes.peek() <= start) {
                endTimes.poll();
            }

            
            endTimes.offer(end);
        }

        return endTimes.size();
    }
}