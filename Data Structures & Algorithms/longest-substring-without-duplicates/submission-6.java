class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> seen = new HashSet<>();

        int longestSub = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++){

            while (seen.contains(s.charAt(i))){

                seen.remove(s.charAt(left));
                left++;

            }
            seen.add(s.charAt(i));

            int currSub = i - left + 1;

            longestSub = Math.max(longestSub, currSub);

        }

        return longestSub;
        
    }
}
