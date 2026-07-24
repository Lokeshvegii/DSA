class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1.isdigit() and num2.isdigit():
            return str(int(num1) * int (num2))
        return ""
