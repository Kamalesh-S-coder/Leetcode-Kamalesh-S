// Last updated: 11/08/2026, 20:55:14
class NumArray {
    public int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;

        for(int i=left; i<=right; i++) {
            sum += nums[i];
        }

        return sum;
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */ 