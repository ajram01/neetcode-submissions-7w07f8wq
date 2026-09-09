class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);
        }

        for (int j = 0; j < t.length(); j++){
            char curr = t.charAt(j);
            freqMap.put(curr, freqMap.getOrDefault(curr, 0) - 1);
        }

        for (int freq : freqMap.values()){
            if (freq != 0) return false;
        }

        return true;

    }
}
