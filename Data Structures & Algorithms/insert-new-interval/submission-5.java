class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> newList = new ArrayList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            newList.add(intervals[i]);
            i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];

        while ( i < intervals.length && intervals[i][0] <= end){

            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);

            i++;

        }

        newList.add(new int[] {start, end});

        while (i < intervals.length){
            newList.add(intervals[i]);
            i++;
        }

        return newList.toArray(new int[newList.size()][]);
        
    }

    // Time Complexity: O(n) we do the same work we iterate through the entire input array + 1 for the newInterval which is dropped as constants are dropped
    
    // Space Complexity: O(n) we create an array list to store basically the entire input array + 1 at worst none overlap
 }
