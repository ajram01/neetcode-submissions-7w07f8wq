class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> seen = new HashSet<>();

        int longestSub = 0;
        int currSub = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++){

            if (!seen.add(s.charAt(right))){

                while (s.charAt(left) != s.charAt(right)){
                    seen.remove(s.charAt(left));
                    currSub--;
                    left++;
                }
                seen.remove(s.charAt(left));
                currSub--;
                left++;
            }

            seen.add(s.charAt(right));
            currSub++;

            longestSub = Math.max(longestSub, currSub);

        }

        return longestSub;
        
    }
}
