class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++){

            char curr = s.charAt(i);

            if (curr == '[' || curr == '{' || curr == '('){
                stack.push(curr);
            } else {

                if (stack.peek() == null) return false;

                char top = stack.pop();

                if (curr == ')' && top == '('){
                    continue;
                } else if (curr == '}' && top == '{'){
                    continue;
                } else if (curr == ']' && top == '['){
                    continue;
                } else {
                    return false;
                }

            }

        }

        return stack.isEmpty();
        
    }
}
