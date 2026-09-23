class Solution {
    public int lastStoneWeight(int[] stones) {

        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int curr : stones){
            maxHeap.offer(curr);
        }

        while (maxHeap.size() >= 2){

            int rockA = maxHeap.poll();
            int rockB = maxHeap.poll();

            rockA = rockA - rockB;

            if (rockA > 0){
                maxHeap.offer(rockA);
            }
        }

        
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
        
    }
}
