class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int left=0,right=m - 1;
        while(left<n && 0<=right){
            int value = matrix[left][right];
            if(target==value) return true;
            else if(target<value) right--;
            else left++;
        }
        return false;
    }
}
