class Solution:
    def myAtoi(self, s: str) -> int:
        MAX = (2 ** 31) - 1
        MIN = -(2 ** 31)
        
        i, n  = 0 , len(s)

        while i < n and s[i] == " ":
            i += 1

        if i == n:
            return 0
        
        sign = 1
        if s[i] == '+':
            i += 1
        elif s[i] == '-':
            sign = -1
            i += 1

        num = 0

        while i < n and s[i].isdigit():
            d = int(s[i])
            if num > (MAX - d) // 10:
                return MAX if sign == 1 else  MIN
            
            num = num * 10 + d
            i += 1

        return sign * num
        