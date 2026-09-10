class Solution {

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length,ans=0;
        dp=new int[n][m];
        for(int[] d:dp) Arrays.fill(d,-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=Math.max(ans,f(n,m,i,j,matrix,Integer.MIN_VALUE));
            }
        }
        return ans;
    }
    int f(int n,int m,int i,int j,int[][] arr,int prev){
        if(i<0 || j<0 || i>=n || j>=m || arr[i][j]<=prev) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int res=1;
        for(int[] d:directions){
            res=Math.max(res,1+f(n,m,i+d[0],j+d[1],arr,arr[i][j]));
        }
        return dp[i][j]=res;
    }
}
