class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        MAX = 2 ** 31 - 1
        MIN = -(2 ** 31)
        if dividend == MIN and divisor == -1:
            return MAX
        negative = (dividend < 0) ^ (divisor < 0)

        divisor = abs(divisor)
        dividend = abs(dividend)
        quotient = 0

        while dividend >= divisor:
            temp = divisor
            multiple = 1
            while dividend >= (temp << 1):
                temp <<= 1
                multiple <<= 1
            dividend -= temp
            quotient += multiple
        return -quotient if negative else quotient 
        
        