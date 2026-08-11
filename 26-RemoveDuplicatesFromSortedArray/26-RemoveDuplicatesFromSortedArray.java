// Last updated: 11/08/2026, 21:02:06
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int delete=0;
        while(i<nums.length-1-delete){
            if(nums[i] == nums[i+1]){
                for(int j=i+1;j<nums.length-1;j++){
                    nums[j]=nums[j+1];

                }
                delete++;
            }
            else{
                i++;
            }
        }
        return nums.length-delete;
    }
}