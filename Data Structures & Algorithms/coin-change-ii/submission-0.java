class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<=amount;i++) dp[0][i]=(i%coins[0]==0)?1:0;
        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int ex=dp[i-1][t];
                int in=0;
                if(coins[i]<=t) in=dp[i][t-coins[i]];
                dp[i][t]=ex+in;
            }
        }
        return dp[n-1][amount];
    }
}
