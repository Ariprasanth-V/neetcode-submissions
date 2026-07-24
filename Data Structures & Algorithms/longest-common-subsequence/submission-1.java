class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(),m=text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return lcs(text1,text2,0,0,dp);
    }

    private int lcs(String s,String t,int i,int j,int[][] dp){
        if(i==s.length() || j==t.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) return dp[i][j]=1+lcs(s,t,i+1,j+1,dp);
        return dp[i][j]=Math.max(lcs(s,t,i+1,j,dp),lcs(s,t,i,j+1,dp));
    }
}
