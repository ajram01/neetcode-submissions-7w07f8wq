class Solution {
    public boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) return true;
        if (s.length() > t.length()) return false;

        int currSChar = 0;

        for (int i = 0; i < t.length(); i++){
            if (t.charAt(i) == s.charAt(currSChar)){
                currSChar++;
                if (currSChar == s.length()) return true;
            }
        }

        return false;

    }
}