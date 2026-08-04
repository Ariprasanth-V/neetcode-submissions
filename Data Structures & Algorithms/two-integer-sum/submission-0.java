class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) map.put(nums[i],i);
        for(int indx=0;indx<nums.length;indx++){
            int diff=target-nums[indx];
            if(map.containsKey(diff)&&map.get(diff)!=indx) return new int[]{indx,map.get(diff)};
        }
        return new int[0];
    }
}
