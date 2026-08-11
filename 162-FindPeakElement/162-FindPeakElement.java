// Last updated: 11/08/2026, 20:58:16

class Solution {
    public int findPeakElement(int[] nums) {
        //brute force
        int n= nums.length;
        for(int i=0;i<n;i++){

            boolean left = (i==0) || (nums[i]>nums[i-1]); // check left neighbor

            boolean right = (i==n-1) || (nums[i]>nums[i+1]); // check right neighbor
            // both left & right less than i so true
            if(left && right){
                return i;
            }
        }
        return -1; // if no solution found
    }
}