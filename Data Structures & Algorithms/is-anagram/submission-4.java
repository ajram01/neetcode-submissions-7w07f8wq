class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Integer> sSeen = new HashMap<>();
        Map<Character, Integer> tSeen = new HashMap<>();

        for (char curr : s.toCharArray()){
            sSeen.put(curr, sSeen.getOrDefault(curr, 0) + 1);
        }
        for (char curr : t.toCharArray()){
            tSeen.put(curr, tSeen.getOrDefault(curr, 0) + 1);
        }

        return sSeen.equals(tSeen);

    }
}
