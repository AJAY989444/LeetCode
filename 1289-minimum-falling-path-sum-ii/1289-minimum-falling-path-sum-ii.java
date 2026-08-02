class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row : dp) {
            Arrays.fill(row,-99999);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < grid[0].length; i++) {
            ans = Math.min(ans,min(grid,0,i,dp));
        }

        return ans;
    }

    public int min(int[][]grid,int cr, int cc,int[][] dp) {

        if(cr == grid.length - 1) {
            return grid[cr][cc];
        }

        if(dp[cr][cc] != -99999) {
            return dp[cr][cc];
        }
         int ans = Integer.MAX_VALUE;
         for(int col = 0; col < grid[0].length; col++) {
            if(col != cc) {
                ans = Math.min(ans,min(grid,cr + 1, col,dp));
            }
         }

         return dp[cr][cc] = ans + grid[cr][cc];
    }
}