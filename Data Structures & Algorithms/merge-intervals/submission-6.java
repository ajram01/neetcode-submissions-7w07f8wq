class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        int beg = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> returnIntervals = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++){

            if (intervals[i][0] <= end){

                end = Math.max(end, intervals[i][1]);

            } else {

                returnIntervals.add(new int[] {beg, end});
                beg = intervals[i][0];
                end = intervals[i][1];
            }

        }

        returnIntervals.add(new int[] {beg, end});

        return returnIntervals.toArray(new int[returnIntervals.size()][]);

    }
}
