class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        re = [-1] * n
        st = []

        for i in range(2 * n - 1, -1, -1):
            cu = nums[i % n]

            while st and st[-1] <= cu:
                st.pop()

            if i < n:
                if st:
                    re[i] = st[-1]
                
            st.append(cu)
        
        return re