class Solution:
    def largestInteger(self, nums: List[int], k: int) -> int:
        fq = {}

        for i in range(len(nums) - k + 1):
            se = set(nums[i: i + k])

            for x in se:
                fq[x] = fq.get(x, 0) + 1
        
        re = -1

        for x, count in fq.items():
            if count == 1:
                re = max(re, x)
        
        return re
