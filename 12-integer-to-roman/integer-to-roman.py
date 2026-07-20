class Solution:
    def intToRoman(self, num: int) -> str:
        symbols = ['M', 'CM', 'D', 'CD', 'C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I']
        values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        s = ""
        for i in range(len(values)):
            while num >= values[i]:
                s = s + symbols[i]
                num = num - values[i]
        return s
