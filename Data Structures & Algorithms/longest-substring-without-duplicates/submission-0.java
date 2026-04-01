class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int best = 0;

        Set<Character> seen = new HashSet<>();

        for (int right = 0; right < s.length(); right++){

            char c = s.charAt(right);

            while (seen.contains(c)){
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(c);

            best = Math.max(best, right - left + 1);

        }

        return best;

    }
}
