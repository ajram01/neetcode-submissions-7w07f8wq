class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> newList = new ArrayList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            newList.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        newList.add(newInterval);

        while (i < intervals.length){
            newList.add(intervals[i]);
            i++;
        }

        return newList.toArray(new int[newList.size()][]);
        
    }
}
