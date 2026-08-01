class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return min(grid,0,0,dp);
    }

    public int min(int[][] grid, int i, int j,int[][]dp) {
        if(i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int d  = min(grid,i+1,j,dp);
        int r = min(grid,i,j + 1,dp);

        return dp[i][j] = Math.min(d,r) + grid[i][j];
    }
}