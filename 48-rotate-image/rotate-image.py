class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
            
        for k in range (n):
            l = 0
            r = n-1
            while l < r:
                matrix[k][l], matrix[k][r] = matrix[k][r], matrix[k][l]
                r -= 1
                l += 1
        