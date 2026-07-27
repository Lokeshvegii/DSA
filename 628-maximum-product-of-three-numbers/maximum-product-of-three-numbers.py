class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        f = s = t = float('-inf')
        m1 = m2 = float('inf')
        for n in nums:
            if n >= f:
                t = s
                s = f
                f = n
            elif n >= s :
                t = s
                s = n
            elif n > t:
                t = n
            
            if n <= m1:
                m2 = m1
                m1 = n
            elif n < m2:
                m2 = n

        return max(f * s * t, f * m1 * m2)
