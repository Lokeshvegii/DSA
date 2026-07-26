class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        st = []
        gt = {}
        for cu in reversed(nums2):

            while st and st[-1] <= cu:
                st.pop()
            
            if not st:
                gt[cu] = -1
            else:
                gt[cu] = st[-1]

            st.append(cu)

        return [gt[i] for i in nums1]