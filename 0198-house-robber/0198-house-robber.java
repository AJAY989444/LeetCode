class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, 0, dp);
    }

    public int solve(int[] nums, int i, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) { // DP
            return dp[i];
        }

        int robbed = nums[i] + solve(nums, i + 2, dp);
        int notRobbed = solve(nums, i + 1, dp);

        return dp[i] = Math.max(robbed, notRobbed);
    }
}