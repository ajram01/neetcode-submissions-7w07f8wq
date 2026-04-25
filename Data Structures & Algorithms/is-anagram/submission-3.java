class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int left = 0;

        Map<Character, Integer> string1 = new HashMap<>();
        Map<Character, Integer> string2 = new HashMap<>();

        while (left != s.length()){

            char s1 = s.charAt(left);
            int s1SeenCount = string1.getOrDefault(s1, 0) + 1;
            string1.put(s1, s1SeenCount);

            char s2 = t.charAt(left);
            int s2SeenCount = string2.getOrDefault(s2, 0) + 1;
            string2.put(s2, s2SeenCount);

            left++;

        }

        return string1.equals(string2);

    }
}
