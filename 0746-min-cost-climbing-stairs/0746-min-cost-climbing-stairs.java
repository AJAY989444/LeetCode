class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);

        return Math.min(solve(cost, 0, dp), solve(cost, 1, dp));
    }

    public int solve(int[] cost, int i, int[] dp) {
        if (i >= cost.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int oneStep = solve(cost, i + 1, dp);
        int twoStep = solve(cost, i + 2, dp);

        return dp[i] = cost[i] + Math.min(oneStep, twoStep);
    }
}