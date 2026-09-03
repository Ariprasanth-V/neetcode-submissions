class Solution {
    public int missingNumber(int[] nums) {
        for(int i=0;i<nums.length;){
            int correct=nums[i];
            if(correct<nums.length && nums[i]!=nums[correct]){
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }
            else{
                i++;
            }
        }
        for(int j=0;j<nums.length;j++) if(j!=nums[j]) return j;
        return nums.length;
    }
}
