class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones){
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 == stone2){
                continue;
            } else {

                int newStone = 0;

                if (stone1 > stone2){
                    newStone = stone1 - stone2;
                } else {
                    newStone = stone2 - stone1;
                }

                maxHeap.add(newStone);
            }
        }

        if (maxHeap.size() == 1){
            return maxHeap.peek();
        }

        return 0;
        
    }
}
