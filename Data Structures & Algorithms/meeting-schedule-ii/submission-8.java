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

        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        Queue<Integer> end = new PriorityQueue<>();

        for (Interval in : intervals){

            if (!end.isEmpty() && end.peek() <= in.start){
                end.poll();
            }
            end.offer(in.end);
        }

        return end.size();

    

    }
}
