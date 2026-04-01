class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> charFreqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++){

            charFreqMap.put(s.charAt(i), charFreqMap.getOrDefault(s.charAt(i), 0) + 1);

            charFreqMap.put(t.charAt(i), charFreqMap.getOrDefault(t.charAt(i), 0) - 1);

        }

        for (int value : charFreqMap.values()){

            if (value != 0) return false;
        }

        return true;
    }
}
