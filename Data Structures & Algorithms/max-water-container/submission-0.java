class Solution {
    public int maxArea(int[] heights) {

        int left = 0, right = heights.length - 1;
        int max = 0;

        while (left < right){
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int area = width * height;

            max = Math.max(max, area);

            if (heights[left] >= heights[right]){
                right--;
            } else{
                left++;
            }

        }

        return max;
        
    }
}
