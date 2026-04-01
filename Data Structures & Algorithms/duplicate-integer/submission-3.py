class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        freqMap = {}

        for num in nums:
            if num not in freqMap:
                freqMap[num] = 1
            else:
                freqMap[num] += 1
        
        for key, value in freqMap.items():
            if value > 1:
                return True
        return False
         