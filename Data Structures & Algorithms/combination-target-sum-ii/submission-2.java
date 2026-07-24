class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0);
        return list;
    }

    private void backtrack(int[] nums,int target,int start){
        if(target<0) return;
        else if(target==0) list.add(new ArrayList<>(ans));
        else{
            for(int i=start;i<nums.length;i++){
                if(i>start && nums[i]==nums[i-1]) continue;
                ans.add(nums[i]);
                backtrack(nums,target-nums[i],i+1);
                ans.remove(ans.size()-1);
            }
        }
    }
}
