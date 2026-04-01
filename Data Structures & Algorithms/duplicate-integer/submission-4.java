class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        Map<Integer, Integer> intFreq = new HashMap<>();

        for (int i = 0; i < nums.length; i++){

            intFreq.put(nums[i], intFreq.getOrDefault(nums[i], 0) + 1);

        }

        for (Map.Entry<Integer, Integer> entry : intFreq.entrySet()){

            if(entry.getValue() > 1){
                return true;
            }

        }

        return false;



    }
}