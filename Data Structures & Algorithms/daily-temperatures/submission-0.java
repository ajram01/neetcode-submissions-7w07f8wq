class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Deque<Integer> indexStack = new ArrayDeque<>();
        int[] solution = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++){

            while(!indexStack.isEmpty() && temperatures[indexStack.peek()] < temperatures[i]){
                int poppedIndex = indexStack.pop();
                solution[poppedIndex] = i - poppedIndex;
            }

            indexStack.push(i);

        }

        return solution;
        
    }
}
