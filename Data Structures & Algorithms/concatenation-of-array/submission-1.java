class Solution {
    public int[] getConcatenation(int[] nums) {
        
        int size = nums.length;
        int[] returnArray = new int[nums.length * 2];

        System.arraycopy(nums,0,returnArray,0,size);
        System.arraycopy(nums,0,returnArray,size,size);

        return returnArray;

    }
}