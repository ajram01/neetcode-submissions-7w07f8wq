class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> nums = new ArrayDeque<>();
        int num1 = 0;
        int num2 = 0;

        for (String item : tokens){

            switch(item){
                case "+":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    nums.push(num2 + num1);
                    break;
                case "-":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    nums.push(num2 - num1);
                    break;
                case "/":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    nums.push(num2 / num1);
                    break;
                case "*":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    nums.push(num2 * num1);
                    break;
                default:
                    nums.push(Integer.parseInt(item));
                    break;
            }

        }

        return nums.pop();
        
    }
}
