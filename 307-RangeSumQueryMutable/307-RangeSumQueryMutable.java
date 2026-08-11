// Last updated: 11/08/2026, 20:55:01
class NumArray {

    int[] arr;
    int[] nums; 
    public NumArray(int[] nums) {
        this.nums=nums;
       arr = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            int index = i + 1;
            while(index < arr.length){
                arr[index] += nums[i];
                index += index & (-index);
            }
        }
    }
    
    public void update(int index, int val) {
        int re =val-nums[index];
        nums[index]=val;
        index++;
        while(index<arr.length){
          arr[index] += re;
          index += index & (-index);
        }
    }
    
    public int sumRange(int left, int right) {
        int sum=prefixSum(right+1)-prefixSum(left);
        return sum;
    }

    public int prefixSum(int idx) {
        int sum=0;
        while(idx > 0){
          sum += arr[idx];
          idx -= idx & (-idx);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */