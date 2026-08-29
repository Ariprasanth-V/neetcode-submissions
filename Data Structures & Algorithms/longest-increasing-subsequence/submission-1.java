class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length+1][nums.length+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return f(0,-1,nums,dp);
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
