class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0,s,set,dp);
    }
    boolean solve(int i,String s,Set<String> set,int[] dp){
        if(i==s.length()) return true;
        if(dp[i]!=-1) return dp[i]==1;
        for(int end=i+1;end<=s.length();end++){
            String word=s.substring(i,end);
            if(set.contains(word)&&solve(end,s,set,dp)){
                dp[i]=1;
                return true;
            }
        }
        dp[i]=0;
        return false;
    }
}