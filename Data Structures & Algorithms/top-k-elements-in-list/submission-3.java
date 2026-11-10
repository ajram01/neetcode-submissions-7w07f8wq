class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        List<Deque<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++){

            buckets.add(new ArrayDeque<>());

        }

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int curr : nums){

            freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);

        }

        for (int num : freqMap.keySet()){

            buckets.get(freqMap.get(num)).push(num);

        }

        int[] returnList = new int[k];

        int i = 0;
        int currBucket = buckets.size() - 1;

        while (i < k){

            while (buckets.get(currBucket).peek() != null){
                returnList[i] = buckets.get(currBucket).pop();
                i++;
            }

            currBucket--;

        }

        return returnList;
        
    }
}
