class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Deque<Integer>[] buckets = new Deque[nums.length + 1];
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int curr : nums){
            freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);
        }

        for (int key : freqMap.keySet()){

            int freqValue = freqMap.get(key);

            if (buckets[freqValue] == null){
                buckets[freqValue] = new ArrayDeque<>();
            }
            buckets[freqMap.get(key)].push(key);
        }

        int[] result = new int[k];

        int added = 0;
        int round = nums.length;

        while (added < k){

            if (buckets[round] != null){
                while (!buckets[round].isEmpty() && added < k){
                    result[added] = buckets[round].pop();
                    added++;
                }
            }
            round--;

        }

        return result;

        
    }
}
