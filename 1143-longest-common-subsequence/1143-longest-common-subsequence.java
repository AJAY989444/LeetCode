class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < dp.length; i++) {
         for (int j = 0; j < dp[0].length; j++) {
               dp[i][j] = -1;
            }
        }
        return lcs(text1, text2,0,0,dp);
    }

    public int lcs(String t1, String t2, int i, int j,int[][] dp) {
        int ans = 0;

        if(i >= t1.length() || j >= t2.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(t1.charAt(i) == t2.charAt(j)) {
            ans = 1 + lcs(t1,t2,i + 1, j + 1,dp);
        } else {
            int f = lcs(t1,t2,i + 1,j,dp);
            int s = lcs(t1,t2,i,j + 1,dp);
            ans = Math.max(f,s);
        }

        return dp[i][j] = ans;
    }
}