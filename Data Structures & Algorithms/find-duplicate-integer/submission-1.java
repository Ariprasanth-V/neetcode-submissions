class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]) swap(nums,i,correct);
            else i++;
        }
        for(int i=0;i<n;i++) if(nums[i]!=i+1) return nums[i];
        return 0;
    }
    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
