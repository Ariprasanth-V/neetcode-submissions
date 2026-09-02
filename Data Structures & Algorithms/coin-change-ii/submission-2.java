class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        for(int i=0;i<=amount;i++) prev[i]=(i%coins[0]==0)?1:0;
        for(int i=1;i<n;i++){
            int[] cur=new int[amount+1];
            for(int t=0;t<=amount;t++){
                int ex=prev[t];
                int in=0;
                if(coins[i]<=t) in=cur[t-coins[i]];
                cur[t]=ex+in;
            }
            prev=cur;
        }
        return prev[amount];
    }
}
