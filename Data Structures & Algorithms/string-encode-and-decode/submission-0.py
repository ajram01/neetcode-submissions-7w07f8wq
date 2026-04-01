class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""
        for string in strs:
            res += str(len(string)) + "$" + string
        return res

    def decode(self, s: str) -> List[str]:
        res = []
        iterator = 0

        while iterator < len(s):
            j = iterator
            while s[j] !=  "$":
                j += 1 
            length = int(s[iterator:j])
            iterator = j + 1
            j = iterator + length
            res.append(s[iterator:j])
            iterator = j
        return res



        
