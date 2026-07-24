class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        re = []

        def backtrack(re, p, o,c):
            if len(p) == 2 * n:
                re.append(p)
                return
            if o < n:
                backtrack(re, p + "(", o + 1, c)
            if c < o:
                backtrack(re, p + ")", o, c + 1)

        backtrack(re, "", 0, 0)
        return re


        