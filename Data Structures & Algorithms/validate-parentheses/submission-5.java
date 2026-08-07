class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        char[] input = s.toCharArray();

        for (int i = 0; i < input.length; i++){
            
            if (input[i] == '(' || input[i] == '{' || input[i] == '['){
                stack.push(input[i]);
            } else {
                if (stack.isEmpty()) return false;
                
                char topChar = stack.peek();

                if (topChar == '(' && input[i] == ')' || topChar == '{' && input[i] == '}' || topChar == '[' && input[i] == ']'){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) return false;

        return true;
        
    }
}
