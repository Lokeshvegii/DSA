class Solution:
    def intToRoman(self, num: int) -> str:
        # roman = {'M': 1000, 'CM' : 900, 'D': 500, 'CD' : 400, 'C' : 100,'XC' : 90, 'L' : 50,'XL' : 40, 'X' : 10, 'IX': 9, 'V' : 5, 'IV' : 4, 'I' : 1}
        # s = ""
        # for symbol, value in roman.items():
        #     while num >= value:
        #         s = s + symbol
        #         num = num - value
        # return s
        symbols = ['M', 'CM', 'D', 'CD', 'C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I']
        s = ""
        values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        for i in range(len(values)):
            while num >= values[i]:
                s = s + symbols[i]
                num = num - values[i]
        return s
