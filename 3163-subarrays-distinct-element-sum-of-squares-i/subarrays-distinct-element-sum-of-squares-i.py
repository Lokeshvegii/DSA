class Solution:
    def sumCounts(self, nums: List[int]) -> int:
        n = len(nums)
        z = 0
        for i in range(n):
            s = set()
            for j in range(i, n):
                s.add(nums[j])
                z += len(s) ** 2
        return z
