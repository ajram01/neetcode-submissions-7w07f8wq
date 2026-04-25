class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        int greatest = 0;

        for (int num : nums){

            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int num : freqMap.keySet()){

            int freq = freqMap.get(num);
            if (buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        int toAdd = k;
        List<Integer> result = new ArrayList<>();

        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--){

            if (buckets[i] != null){
                result.addAll(buckets[i]);
            }

        }

        int[] res = new int[k];

        for( int i = 0; i < k; i++){
            res[i] = result.get(i);
        }

        return res;


    }
}
