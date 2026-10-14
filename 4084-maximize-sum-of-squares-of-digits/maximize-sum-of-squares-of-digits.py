class Solution:
    def maxSumOfSquares(self, num: int, sum: int) -> str:
        if sum > 9 * num:
            return ""
        k = sum // 9
        sum %= 9
        st = ""
        st =  '9' * k
        if(sum > 0):
            st += str(sum)
        st += '0' * (num - len(st))
        return st