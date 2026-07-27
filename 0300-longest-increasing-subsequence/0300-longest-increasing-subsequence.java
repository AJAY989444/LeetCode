class Solution {
    public int lengthOfLIS(int[] nums) {
        return lis(nums);
    }

    public int lis(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] < nums[i]) {
                    int val = dp[j];
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        int max = dp[0];

        for(int i = 0; i < dp.length; i++) {
            max  = Math.max(max,dp[i]);
        }

        return max;

    }
}