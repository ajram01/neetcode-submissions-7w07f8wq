class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {


        Arrays.sort(intervals, (a, b) -> (a[1] == b[1]) ? (Integer.compare(a[0], b[0])) : (Integer.compare(a[1], b[1])));
        
        int toRemove = 0;
        int currRemove = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++){

            if (end > intervals[i][0]){

                toRemove++;

            } else {
                end = intervals[i][1];
            }

        }

        return toRemove;


    }
}
