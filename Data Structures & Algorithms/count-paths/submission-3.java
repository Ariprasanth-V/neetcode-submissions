class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid=new int[m][n];
        int[][] dp=new int[m][n];
        for(int[] d:dp) Arrays.fill(d,-1);
        return f(m-1,n-1,grid,dp);
    }
    int f(int i,int j,int[][] grid,int[][] dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=f(i-1,j,grid,dp);
        int left=f(i,j-1,grid,dp);
        return dp[i][j]=up+left;
    }
}
