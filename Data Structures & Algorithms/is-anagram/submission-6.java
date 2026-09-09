class Solution {
    public boolean isAnagram(String s, String t) {

        char[] freqArray = new char[26];

        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            freqArray['z' - curr] += 1;
        }

        for (int j = 0; j < t.length(); j++){
            char curr = t.charAt(j);
            freqArray['z' - curr] -= 1;
        }

        for (int a = 0; a < freqArray.length; a++){
            if (freqArray[a] != 0) return false;
        }

        return true;

    }
}
