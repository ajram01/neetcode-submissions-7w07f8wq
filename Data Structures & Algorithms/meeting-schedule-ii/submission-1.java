/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0){
            return 0;
        }

        List<int[]> newList = new ArrayList<>();

        for (Interval curr : intervals){

            newList.add(new int[]{curr.start, 1});
            newList.add(new int[]{curr.end, -1});

        }

        Collections.sort(newList, (a,b) -> a[0] == b[0] ? a[1] - b[1] : Integer.compare(a[0], b[0]));

        int currRooms = 0;
        int maxRooms = 0;

        for (int[] curr : newList){

            currRooms += curr[1];
            
            maxRooms = Math.max(maxRooms, currRooms);
        }

        return maxRooms;

        // Time Complexity: O(n logn) because we sort the array list

        // Space Complexity: O(n) As we create an arraylist to store the times 

    }
}
