class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int a=f(n-1,coins,amount);
        if(a>=1e9) return -1;
        return a;
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
