class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // -1 Cannot be taken because negative values cab be present in the ans -100 <= matrix[i][j] <= 100 & 1 <= n <= 100 so
        // min = n(100) * -100 = -10000 & max = n(100) * 100 = 10000, so take a number out of this range suppose -999999 
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] row : dp) {
            Arrays.fill(row,-999999);
        }

        for(int cc = 0; cc < matrix[0].length; cc++) {
            ans = Math.min(ans,min(ans,matrix,0,cc,dp));
        }

        return ans;
    }

    public int min(int ans , int[][] mat, int cr, int cc,int[][] dp) {
        if(cc < 0 || cc == mat.length) {
            return Integer.MAX_VALUE;
        }

        if( cr == mat.length - 1) {
            return mat[cr][cc];
        }

        if(dp[cr][cc] != -999999) {
            return dp[cr][cc];
        }

        int ld = min(ans, mat, cr + 1, cc - 1,dp);
        int rd = min(ans, mat, cr + 1, cc,dp);
        int d = min(ans, mat, cr + 1, cc + 1,dp);

        return dp[cr][cc] = Math.min(ld, Math.min(rd,d)) + mat[cr][cc];
        
    }
}