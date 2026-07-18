class Solution:
    def reverse(self, x: int) -> int:
        reverse = 0
        MAX = (2 ** 31) - 1
        MIN = -(2 ** 31)
        while x != 0:
            d = x % 10 if x >= 0 else -(-x % 10)
            x = int(x / 10)
            if  reverse > MAX // 10 or (reverse == MAX // 10) and d > 7:
                return 0
            if reverse < int(MIN / 10) or (reverse == int(MIN / 10)) and d < -8:
                return 0
            
            reverse = reverse * 10 + d

        return reverse

        