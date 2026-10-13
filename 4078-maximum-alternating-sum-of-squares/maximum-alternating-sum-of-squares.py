class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        nums1  = [a * a for a in nums]
        nums1 = sorted(nums1, reverse = True)
        sum = 0
        for i in range(len(nums) // 2):
            sum += nums1[i] - nums1[-1 - i]
        if len(nums) % 2 == 1:
            sum += nums1[len(nums) // 2]
        return sum