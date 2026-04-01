class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        res = defaultdict(list) # mapping charCount to list of Anagrams

        for string in strs:
            count = [0] * 26 # a ... z

            for char in string:
                count [ord(char) - ord("a")] += 1

            res[tuple(count)].append(string)
        return res.values()

        