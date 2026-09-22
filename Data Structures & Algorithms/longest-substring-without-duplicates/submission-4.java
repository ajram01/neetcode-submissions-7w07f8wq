class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> currSeen = new HashSet<>();

        int left = 0;
        int longestSubstring = 0;
        int currSubstring = 0;

        for (int right = 0; right < s.length(); right++){

            if (!currSeen.add(s.charAt(right))){

                while (s.charAt(left) != s.charAt(right)){

                    currSeen.remove(s.charAt(left));
                    currSubstring--;
                    left++;

                }

                currSeen.remove(s.charAt(left));
                currSubstring--;
                left++;

            }

            currSeen.add(s.charAt(right));
            currSubstring++;

            longestSubstring = Math.max(longestSubstring, currSubstring);


        }

        return longestSubstring;
        
    }
}
