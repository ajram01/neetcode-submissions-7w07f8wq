class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagrams = new HashMap<>();

        for (String curr : strs){
            int[] freq = new int[26];
            for (int i = 0; i < curr.length(); i++){

                char currChar = curr.charAt(i);
                freq[currChar - 'a'] += 1;

            }

            String freqKey = Arrays.toString(freq);

            if (anagrams.containsKey(freqKey)){
                anagrams.get(freqKey).add(curr);
            } else {
                List<String> list = new ArrayList();
                list.add(curr);
                anagrams.put(freqKey, list);
            }

        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> group : anagrams.values()){
            result.add(group);
        }

        return result;
        
    }
}
