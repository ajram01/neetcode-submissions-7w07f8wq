class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0){
            return new int[][] {};
        }

        List<int[]> newList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++){

            if (intervals[i][0] <= end){
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            } else {
                newList.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }

        }

        newList.add(new int[] {start, end});
        
        return newList.toArray(new int[newList.size()][]);
    }
}
