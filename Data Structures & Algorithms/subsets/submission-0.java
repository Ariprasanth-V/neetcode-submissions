class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return list;
    }
    private void backtrack(int[] nums,int start){
        list.add(new ArrayList<>(ans));
        for(int i=start;i<nums.length;i++){
            ans.add(nums[i]);
            backtrack(nums,i+1);
            ans.remove(ans.size()-1);
        }
    }
    }
