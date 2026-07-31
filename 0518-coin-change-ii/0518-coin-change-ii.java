class Solution {
    public int change(int amount, int[] coins) {
        return coin(coins,amount);
    }

    public int coin(int[] coin, int amount) {

        int[][] dp = new int[amount + 1][coin.length + 1];

        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        for(int am = 1; am < dp.length; am++) { // amount
            for(int i = 1; i < dp[0].length; i++) { // coin
                int inc = 0;
                int exc = 0;

                if(am >= coin[i - 1]) {
                    inc = dp[am - coin[i - 1]][i];
                }

                exc = dp[am][i - 1];

                dp[am][i] = inc + exc;
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}