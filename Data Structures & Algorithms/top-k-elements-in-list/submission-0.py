class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        intMap = Counter(nums)
        
        mostCommon = intMap.most_common(k)

        ans = [element for element, count in mostCommon]

        return ans
            
        