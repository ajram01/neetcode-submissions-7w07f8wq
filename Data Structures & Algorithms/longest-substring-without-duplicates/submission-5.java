class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> currSeen = new HashSet<>();

        int left = 0;
        int longestSubstring = 0;

        for (int right = 0; right < s.length(); right++){

            while (currSeen.contains(s.charAt(right))){

                currSeen.remove(s.charAt(left));
                left++;

            }

            currSeen.add(s.charAt(right));

            longestSubstring = Math.max(longestSubstring, right - left + 1);


        }

        return longestSubstring;
        
    }
}
