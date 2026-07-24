class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not haystack:
            return -1
        else:
            if needle not in haystack:
                return -1
            return haystack.index(needle)
        