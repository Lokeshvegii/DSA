class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        maxi = 1
        pal_str = s[0]
        for i in range(len(s)):
            for j in range(i, len(s)):
                sub_str = s[i: j + 1]
                if(sub_str == sub_str[::-1] and len(sub_str) > maxi):
                    maxi = len(sub_str)
                    pal_str = sub_str
        return pal_str

            