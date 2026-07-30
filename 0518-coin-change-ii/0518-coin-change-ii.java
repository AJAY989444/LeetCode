class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return coin(coins,amount,0,dp);
    }

    public int coin(int[] coin, int amount, int idx, int[][] dp) {
        if(amount == 0) {
            return 1;
        }

        if(idx == coin.length) {
            return 0;
        }

        if(dp[amount][idx] != -1) {
            return dp[amount][idx];
        }

        int inc = 0;
        int exc = 0;

        if(amount >= coin[idx]) {
        inc = coin(coin,amount - coin[idx],idx,dp);
        }

        exc = coin(coin, amount, idx + 1,dp);

        return dp[amount][idx] = inc + exc;
    }
}