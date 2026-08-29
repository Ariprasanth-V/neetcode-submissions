class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
        // for(int[] row:dp) Arrays.fill(row,-1);
        // return f(0,-1,nums,dp);

        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int len=dp[i+1][j+1];
                if(j==-1 || nums[i]>nums[j]){
                    len=Math.max(len,1+dp[i+1][i+1]);
                }
                dp[i][j+1]=len;
            }
        }
        return dp[0][0];
    }

    int f(int i,int j,int[] nums,int[][] dp){
        if(nums.length==i) return 0;
        if(dp[i][j+1]!=-1) return dp[i][j+1];
        int len=f(i+1,j,nums,dp);
        if(j==-1||nums[i]>nums[j]){
            len=Math.max(len,1+f(i+1,i,nums,dp));
        }
        return dp[i][j+1]=len;
    }
}
