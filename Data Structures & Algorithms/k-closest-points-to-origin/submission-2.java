class Solution {
    public int[][] kClosest(int[][] points, int k) {

        Queue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1])
        );

        for (int[] curr : points){

            minHeap.offer(curr);

        }

        int[][] returnList = new int [k][2];

        for (int i = 0; i < k; i++){

            int[] curr = minHeap.poll();
            returnList[i][0] = curr[0];
            returnList[i][1] = curr[1];
        }
        
        return returnList;
    }
}
