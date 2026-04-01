class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        left, right = 0, len(nums) - 1

        while left <= right:

            midway_point = (right + left) // 2

            if nums[midway_point] > target:
                right = midway_point - 1
            elif nums[midway_point] < target:
                left = midway_point + 1
            else:
                return midway_point
        return -1

