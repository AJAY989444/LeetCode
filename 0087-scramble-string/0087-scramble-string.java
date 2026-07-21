class Solution {
    public boolean isScramble(String s1, String s2) {

        int n = s1.length();

        if (n != s2.length()) {
            return false;
        }

        boolean[][][] dp = new boolean[n][n][n + 1];

        // Base case: length 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        // Build for increasing length
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                for (int j = 0; j + len <= n; j++) {

                    // Try every possible split
                    for (int split = 1; split < len; split++) {

                        // Case 1: No swap
                        boolean noSwap =
                                dp[i][j][split]
                                &&
                                dp[i + split][j + split][len - split];

                        // Case 2: Swap
                        boolean swap =
                                dp[i][j + len - split][split]
                                &&
                                dp[i + split][j][len - split];

                        if (noSwap || swap) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0][n];
    }
}