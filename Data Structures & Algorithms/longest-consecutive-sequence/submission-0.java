class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> seenNums = new HashSet<>();
        int maxLength = 0;

        for (int num : nums){
            seenNums.add(num);
        }

        for (int num : seenNums){
            int length = 1;
            if (!seenNums.contains(num - 1)){
                int currNum = num;
                while (seenNums.contains(currNum + 1)){
                    length++;
                    currNum++;
                }
            }
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
