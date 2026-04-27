class Solution {

    public String encode(List<String> strs) {

        StringBuilder encodedString = new StringBuilder();

        for (String word : strs){
            
            int charCount = word.length();
            encodedString.append(charCount).append("#").append(word);

        }

        return encodedString.toString();

    }

    public List<String> decode(String str) {

        List<String> decodedStrings = new ArrayList<>();

        int left = 0;

        while (left < str.length()){
            int right = left;

            while (str.charAt(right) != '#'){
                right++;
            }

            int strLength = Integer.parseInt(str.substring(left, right));

            int wordStart = right + 1;
            int wordEnd = wordStart + strLength;

            decodedStrings.add(str.substring(wordStart, wordEnd));

            left = wordEnd;
        }

        return decodedStrings;
    }
}
