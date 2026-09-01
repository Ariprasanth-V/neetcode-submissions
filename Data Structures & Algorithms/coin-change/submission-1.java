class Solution {
    public int coinChange(int[] nums, int amount) {
        int n=nums.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%nums[0]==0) dp[0][i]=i/nums[0];
            else dp[0][i]=(int)1e9;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int exclude=dp[i-1][j];
                int include=Integer.MAX_VALUE;
                if(j>=nums[i]) include=1+dp[i][j-nums[i]];
                dp[i][j]=Math.min(exclude,include);
            }
        }
        return (dp[n-1][amount]>=1e9)?-1:dp[n-1][amount];
    }
    int f(int i,int[] coins,int target){
        if(i==0){
            if(target%coins[0]==0) return target/coins[0];
            return (int) 1e9; 
        }
        int exclude=f(i-1,coins,target);
        int include=Integer.MAX_VALUE;
        if(target>=coins[i]) include=1+f(i,coins,target-coins[i]);
        return Math.min(exclude,include);
    }
}
