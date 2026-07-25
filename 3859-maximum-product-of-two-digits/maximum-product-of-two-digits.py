class Solution:
    def maxProduct(self, n: int) -> int:
        if n < 10:
            return n
        f = s = 0

        while n:
            d = n % 10
            if d >= f:
                s = f
                f = d
            elif d > s:
                s = d
            n //= 10

        return  f * s
