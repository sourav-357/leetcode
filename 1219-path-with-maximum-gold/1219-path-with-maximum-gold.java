class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int maxGold = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, find(i, j, n, m, grid));
                }
            }
        }

        return maxGold;
    }

    int find(int row, int col, int n, int m, int[][] grid) {
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0) {
            return 0;
        }

        int gold = grid[row][col];
        grid[row][col] = 0;

        int right = right = find(row, col + 1, n, m, grid);
        int down = find(row + 1, col, n, m, grid);
        int left = find(row, col - 1, n, m, grid);
        int up = find(row - 1, col, n, m, grid);

        grid[row][col] = gold;
        return gold + Math.max(right, Math.max(down, Math.max(left, up)));
    }
}