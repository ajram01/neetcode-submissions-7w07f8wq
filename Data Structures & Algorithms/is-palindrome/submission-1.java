class Solution {
    public boolean isPalindrome(String s) {
        
        String lowerInput = s.toLowerCase();
        lowerInput = lowerInput.replaceAll("[^a-z0-9]", "");
        System.out.println(lowerInput);

        int start = 0, end = lowerInput.length() - 1;

        while (start <= end){

            if (lowerInput.charAt(start) != lowerInput.charAt(end)){
                return false;
            }

            start++;
            end--;

        }

        return true;


    }
}
