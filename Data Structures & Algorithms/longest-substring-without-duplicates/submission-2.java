class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> seen = new HashSet<>();
        int longestSubstring = 0;
        int currSubstring = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++){

            if (seen.add(s.charAt(right))){
                currSubstring++;
            } else {

                while (s.charAt(left) != s.charAt(right)){
                    seen.remove(s.charAt(left));
                    currSubstring--;
                    left++;
                }
                seen.add(s.charAt(right));
                left++;
            }

            longestSubstring = Math.max(longestSubstring, currSubstring);

        }

        return longestSubstring;
        
    }
}
