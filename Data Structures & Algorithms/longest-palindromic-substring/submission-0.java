class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int resind=0,reslen=0;
        int[][] dp=new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1]==1)) {
                    dp[i][j]=1;
                    if(reslen<j-i+1){
                        resind=i;
                        reslen=j-i+1;
                    }
                }
            }
        }
        return s.substring(resind,reslen+resind);
    }
}
