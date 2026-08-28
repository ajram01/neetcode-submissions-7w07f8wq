class Solution {
    public int[] replaceElements(int[] arr) {

        Deque<Integer> maxStack = new ArrayDeque<>();
        int currMax = -1;
        int len = arr.length - 1;

        for (int i = len; i >= 0; i--){
            maxStack.push(currMax);
            currMax = Math.max(currMax, arr[i]);
        }
        
        for (int i = 0; i < len; i++){
            arr[i] = maxStack.pop();
        }

        arr[len] = -1;
        return arr;
    }
}