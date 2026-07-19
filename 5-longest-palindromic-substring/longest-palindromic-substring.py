class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) <= 1 or s == s[::-1]:
            return s
        start = 0
        max_len = 1
        for end in range(1, len(s)):
            odd_start = end - max_len - 1
            even_start = end - max_len
            odd_sub = s[odd_start : end + 1]
            even_sub = s[even_start : end + 1]
            if odd_start >= 0 and odd_sub == odd_sub[::-1]:
                start = odd_start
                max_len += 2
                continue
            if even_start >= 0 and even_sub == even_sub[::-1]:
                start = even_start
                max_len += 1

        return s[start: start + max_len]
            