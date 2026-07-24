class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/ x
            n = -n

        a = 1.0
        while n:
            if n % 2 == 1:
                a *= x
            x *= x
            n //= 2

        return a
