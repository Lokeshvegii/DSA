class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int r = 0; r < m; r++) {
            dfs(grid, r, 0);
            dfs(grid, r, n - 1);
        }

        for(int c = 0; c < n; c++) {
            dfs(grid, 0, c);
            dfs(grid, m - 1, c);
        }

        int count = 0;

        for(int r = 1; r < m - 1; r++) {
            for(int c = 1; c < n - 1; c++) {
                if(grid[r][c] == 0) {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }
    private void dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 1) {
            return;
        }
        grid[r][c] = 1;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}