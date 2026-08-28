class Solution {
    public boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) return true;
        if (s.length() > t.length()) return false;

        char[] tArr = t.toCharArray();
        int currSChar = 0;

        for (char curr : tArr){
            if (curr == s.charAt(currSChar)){
                currSChar++;
                if (currSChar == s.length()) return true;
            }
        }

        return false;

    }
}