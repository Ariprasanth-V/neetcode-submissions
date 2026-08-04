class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1,maxi=0;
        while(left<right){
            int h=Math.min(height[left],height[right]);
            int w=right-left;
            maxi=Math.max(maxi,h*w);
            if(height[left]<height[right]) left++;
            else right--;
        }
        return maxi;
    }
}
