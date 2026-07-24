class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums,target,0);
        return list;
    }
    private void backtrack(int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{ 
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(nums, remain - nums[i], i); 
            tempList.remove(tempList.size() - 1);
        }
    }
    }
}
